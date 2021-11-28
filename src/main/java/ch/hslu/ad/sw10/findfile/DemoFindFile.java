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
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "1146.html";
        final File rootDir = new File(System.getProperty("user.home"));
        LOG.info("Start searching '{}' recursive in '{}'", search, rootDir);

        LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
        final FindFileTask root = new FindFileTask(search, rootDir);
        Instant start = Instant.now();
        String result = root.invoke();
        LOG.info(result);
        Instant end = Instant.now();
        LOG.info("Found in {} ms.", Duration.between(start, end).toMillis());

        start = Instant.now();
        FindFile.findFile(search, rootDir);
        end = Instant.now();
        LOG.info("Found in {} ms.", Duration.between(start, end).toMillis());

    }
}
