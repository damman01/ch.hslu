package ch.hslu.ad.sw10.findfile;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.sw10.findfile.DemoFindFile.class);

    /**
     * Main-Demo.
     * @param args
     */
    public static void main(String[] args) {
        final String search = "searchedFile.html";
        final File rootDir = new File(System.getProperty("user.home"));
        LOG.info("Start searching '{}' recursive in '{}'", search, rootDir);

        Instant start = Instant.now();
        FindFile.findFile(search, rootDir);
        Instant end = Instant.now();
        LOG.info("Found in {} ms.", Duration.between(start, end).toMillis());

        LOG.info("Search '{}' concurrent in '{}'", search, rootDir);
        final FindFileTask root = new FindFileTask(search, rootDir);
        start = Instant.now();
        String result = root.invoke();
        LOG.info(result);
        end = Instant.now();
        LOG.info("Found in {} ms.", Duration.between(start, end).toMillis());

        

    }
}
