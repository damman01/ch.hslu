package ch.hslu.ad.sw10.findfile;

import java.io.File;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

public final class FindFileTask extends CountedCompleter<String> {

    private final String regex;
    private final File dir;
    private final AtomicReference<String> result;
    private static final String INITIAL_RESULT_VALUE = null;

    /**
     * Erzeugt eine File-Such-Aufgabe.
     *
     * @param regex Ausdruck der den Filenamen enthält.
     * @param dir   Verzeichnis in dem das File gesucht wird.
     */
    public FindFileTask(String regex, File dir) {
        this(null, regex, dir, new AtomicReference<>(INITIAL_RESULT_VALUE));
    }

    private FindFileTask(final CountedCompleter<?> parent, final String regex, final File dir,
            final AtomicReference<String> result) {
        super(parent);
        this.regex = regex;
        this.dir = dir;
        this.result = result;
    }

    @Override
    public void compute() {
        final File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    this.addToPendingCount(1); // prepare framework for new task
                    new FindFileTask(this, regex, file, result).fork(); // start new task asynchronous
                } else if (regex.equalsIgnoreCase(file.getName())
                        && result.compareAndSet(INITIAL_RESULT_VALUE, file.getParent())) {
                    this.quietlyCompleteRoot(); // send completed signal to root
                    break;
                }
            }
        }
        propagateCompletion(); // end current task
    }

    @Override
    public String getRawResult() {
        return result.get();
    }
}
