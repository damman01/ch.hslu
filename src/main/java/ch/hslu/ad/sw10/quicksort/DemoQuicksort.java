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
        final int size = 300_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Init. Checksum : {}", result);

        final QuicksortTask sortTask = new QuicksortTask(array);
        Instant start = Instant.now();
        pool.invoke(sortTask);
        Instant end = Instant.now();
        LOG.info("QuicksortTask  : {} sec.", Duration.between(start, end).toSeconds());

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Conc. Checksum : {}", result);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. Checksum : {}", result);

        start = Instant.now();
        Sort.quickInsertionSort(array);
        end = Instant.now();
        LOG.info("QuicksortRec.  : {} sec.", Duration.between(start, end).toSeconds());

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Recu. Checksum : {}", result);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. checksum : {}", result);
        Arrays.sort(array);
        LOG.info("Arrays.sort    : {} sec.", '?');
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Sort checksum  : {}", result);
    }
}
