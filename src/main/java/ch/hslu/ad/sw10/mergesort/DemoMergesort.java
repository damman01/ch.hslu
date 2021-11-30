package ch.hslu.ad.sw10.mergesort;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw10.array.init.RandomInitTask;
import ch.hslu.ad.sw10.array.sum.SumTask;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.sw10.mergesort.DemoMergesort.class);

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        mergeSortDemo();
        mergeSortDemo();
        mergeSortDemo();
    }

    public static void mergeSortDemo(){
        final int size = 100_000_000;
        final int[] array = new int[size];
        final int threshold = 20_000_000;
        LOG.info("Size            : {}", size);
        LOG.info("Threshold       : {}", threshold);

        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.debug("Init. Checksum  : {}", result);

        final MergesortTask sortTask = new MergesortTask(array, threshold);
        Instant start = Instant.now();
        pool.invoke(sortTask);
        Instant end = Instant.now();
        LOG.info("Conc. Mergesort : {}", Duration.between(start, end).toMillis());

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Merge Checksum  : {}", result);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Init. checksum  : {}", result);

        //start = Instant.now();
        //MergesortRecursive.mergeSort(array);
        //end = Instant.now();
        //LOG.info("MergesortRec.   : {}", Duration.between(start, end).toMillis());

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Sort checksum   : {}", result);

        
    }
}
