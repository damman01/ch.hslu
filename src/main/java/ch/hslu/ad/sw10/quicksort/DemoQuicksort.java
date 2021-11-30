package ch.hslu.ad.sw10.quicksort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw08.Sort;
import ch.hslu.ad.sw10.array.init.RandomInitTask;
import ch.hslu.ad.sw10.array.sum.SumTask;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.sw10.quicksort.DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 1_000_000;
        final int[] array = new int[size];
        final int threshold = size/13;

        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.debug("Init. Checksum : {}", result);

        // Sortieren mit QuicksortTask
        final QuicksortTask sortTask = new QuicksortTask(array, threshold);
        Instant start = Instant.now();
        pool.invoke(sortTask);
        Instant end = Instant.now();
        LOG.info("QuicksortTask[s]: {}", Duration.between(start, end).toSeconds());

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Conc. Checksum : {}", result);

        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Init. Checksum : {}", result);

        // Sortieren mit QuickInsertionSort
        start = Instant.now();
        Sort.quickInsertionSort(array);
        end = Instant.now();
        LOG.info("QuicksortRec.[s]: {}", Duration.between(start, end).toSeconds());

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Recu. Checksum : {}", result);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Init. checksum : {}", result);

        // Sortieren mit Arrays.Sort
        start = Instant.now();
        Arrays.sort(array);
        end = Instant.now();
        LOG.info("Arrays.sort [s]: {}", Duration.between(start, end).toMillis());
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Sort checksum  : {}", result);
    }
}
