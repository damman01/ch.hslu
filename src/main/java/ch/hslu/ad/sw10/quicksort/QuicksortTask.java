package ch.hslu.ad.sw10.quicksort;

import java.util.*;
import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public final class QuicksortTask extends RecursiveAction {

    private static final int DEFAULT_THRESHOLD = 10;
    private final int threshold;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1, DEFAULT_THRESHOLD);
    }
    public QuicksortTask(int[] array, final int threshold) {
        this(array, 0, array.length - 1, threshold);
    }

    private QuicksortTask(final int[] array, final int min, final int max, final int threshold) {
        this.array = array;
        this.min = min;
        this.max = max;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        int up = min;
        int down = max - 1;
        int t = array[max];
        do {
            while (array[up] < t) {
                up++;
            }
            while (array[down] >= t && down > up) {
                down--;
            }
            if (up < down) {
                exchange(array, up, down);
            }
        } while (up < down);

        exchange(array, up, max);

        List<QuicksortTask> tasks = new ArrayList<>();

        if (min < up - 1) {
            int size = (up - 1) - min + 1;
            if (size < threshold) {
                Arrays.sort(array, min, up);
            } else {
                tasks.add(new QuicksortTask(array, min, up - 1, threshold));
            }
        }

        if (max > up + 1) {
            int size = max - (up + 1) + 1;
            if (size < threshold) {
                Arrays.sort(array, up + 1, max + 1);
            } else {
                tasks.add(new QuicksortTask(array, up + 1, max, threshold));
            }
        }

        if (!tasks.isEmpty()) {
            invokeAll(tasks);
        }
    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param data        Zeichen‐Array
     * @param firstIndex  Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static void exchange(final int data[], final int firstIndex, final int secondIndex) {
        int tmp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = tmp;
    }
}
