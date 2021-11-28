package ch.hslu.ad.sw10.array.sum;

import java.util.concurrent.RecursiveTask;

/**
 * Codebeispiel zu RecursiveTask für die Summierung eines int-Arrays.
 */
//@SuppressWarnings("serial")
public final class SumTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 4;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sumierer Task.
     * 
     * @param array Interger-Array.
     */
    public SumTask(final int[] array) {
        this(array, 0, array.length);
    }

    private SumTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if ((max - min) <= THRESHOLD) {
            for (int i = min; i < max; i++) {
                sum += array[i];
            }
        } else {
            final int mid = min + (max - min) / 2;
            final SumTask taskLeft = new SumTask(array, min, mid);
            taskLeft.fork();
            final SumTask taskRight = new SumTask(array, mid, max);
            sum = taskRight.invoke() + taskLeft.join();
        }
        return sum;
    }
}
