package ch.hslu.ad.sw10.quicksort;

import java.util.concurrent.RecursiveAction;

import ch.hslu.ad.sw08.Sort;

public final class QuicksortTask extends RecursiveAction {

    private static final int QUICK_INSERT_SORT_DETERMINANT = 2500;
    private final int[] a;
    private final int low;
    private final int high;

    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.a = array;
        this.low = min;
        this.high = max;
    }

    @Override
    protected void compute() {
        if (low < high) {
            if ((high - low) < QUICK_INSERT_SORT_DETERMINANT) {
                Sort.insertionSort(a, low, high + 1);
                return;
            }

            int pivotIndex = Sort.getMedianOfThreePivotIndex(a, low, high);
            if (pivotIndex != high) {
                Sort.swap(a, pivotIndex, high);
            }
            int pivot = a[high];

            // Index of smaller element and indicates the right position
            // of pivot found so far
            int i = (low - 1);

            for (int j = low; j <= high - 1; j++) {

                // If current element is smaller than the pivot
                if (a[j] < pivot) {

                    // Increment index of smaller element
                    i++;
                    Sort.swap(a, i, j);
                }
            }
            int pi = (i + 1);
            Sort.swap(a, pi, high);

            // Separately sort elements before partition and after partition
            invokeAll(new QuicksortTask(a, low, pi - 1), new QuicksortTask(a, pi + 1, high));
        }
    }
}
