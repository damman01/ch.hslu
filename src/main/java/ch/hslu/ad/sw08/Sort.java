package ch.hslu.ad.sw08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import ch.hslu.ad.sw09.FixedIntegerHeap;
import ch.hslu.ad.sw09.IntegerHeap;
import ch.hslu.ad.sw10.mergesort.MergesortTask;
import ch.hslu.ad.sw10.quicksort.QuicksortTask;

public class Sort {

    /**
     * Sortiert das int-Array aufsteigend.
     * 
     * @param disarray Zu sortierendes Array.
     */
    public static void insertionSort(final int[] disarray) {
        insertionSort(disarray, 0, disarray.length);
    }

    public static void insertionSort(final int[] disarray, final int from, final int to) {
        int element;
        int j;
        for (int i = from + 1; i < to; i++) {
            element = disarray[i]; // next elt for insert
            j = i; // a[0]..a[j-1] already sorted
            while ((j > from) && (disarray[j - 1] > element)) {
                disarray[j] = disarray[j - 1]; // shift right
                j--; // go further left
            }
            disarray[j] = element; // insert elt
        } // a[0]...a[j] sorted
    }

    public static void selectionSort(final int[] disarray) {
        for (int i = 0; i < disarray.length - 1; i++) {
            int element = disarray[i];
            int replacementIndex = i;
            for (int j = i; j < disarray.length; j++) { // search only in unsorted part of the array
                if (disarray[j] < element) { // find smallest element
                    element = disarray[j];
                    replacementIndex = j;
                }
            }
            if (replacementIndex != i) { // dont replace if current item is the smallest one
                disarray[replacementIndex] = disarray[i];
                disarray[i] = element;
            }
        }
    }

    public static void bubbleSort(final int[] disarray) {
        boolean replacedSomething = false;
        for (int i = 0; i < disarray.length - 1; i++) { // n-1 loops should do the trick, but probably finished earlier
            for (int j = 1; j < disarray.length; j++) { // always start at the beginning of the array
                if (disarray[j - 1] > disarray[j]) { // current element larger then next one?
                    int temp = disarray[j]; // swap positions
                    disarray[j] = disarray[j - 1];
                    disarray[j - 1] = temp;
                    replacedSomething = true;
                }
            }
            if (!replacedSomething) {
                return; // nothing got replaced, we are done here
            }
        }
    }

    public static void shellSort(final int[] disarray) {
        List<Integer> steps = new ArrayList<>();
        int step = 1;
        while (step < disarray.length) {
            steps.add(step);
            step = step * 2 + 1;
        }
        for (int i = steps.size() - 1; i >= 0; i--) {
            step = steps.get(i);

            for (int j = step; j < disarray.length; j++) {
                int key = disarray[j];
                int k = j;
                while (k >= step && disarray[k - step] > key) {
                    disarray[k] = disarray[k - step];
                    k -= step;
                }
                disarray[k] = key;
            }

        }
    }

    public static final void quickInsertionSort(final int[] disarray) {
        quickInsertionSort(disarray, 0, disarray.length - 1);
    }

    private static final int QUICK_INSERT_SORT_DETERMINANT = 25;

    private static void quickInsertionSort(int[] a, int low, int high) {
        if (low < high) {
            if ((high - low) < QUICK_INSERT_SORT_DETERMINANT) {
                insertionSort(a, low, high);
                return;
            }

            int pivotIndex = getMedianOfThreePivotIndex(a, low, high);
            if (pivotIndex != high) {
                swap(a, pivotIndex, high);
            }
            int pivot = a[high];

            // Index of smaller element and
            // indicates the right position
            // of pivot found so far
            int i = (low - 1);

            for (int j = low; j <= high - 1; j++) {

                // If current element is smaller
                // than the pivot
                if (a[j] < pivot) {

                    // Increment index of
                    // smaller element
                    i++;
                    swap(a, i, j);
                }
            }
            int pi = (i + 1);
            swap(a, pi, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    public static final void quickSort(final int[] disarray) {
        quickSort(disarray, 0, disarray.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {

            int pivotIndex = getMedianOfThreePivotIndex(a, low, high);
            if (pivotIndex != high) {
                swap(a, pivotIndex, high);
            }
            int pivot = a[high];

            // Index of smaller element and
            // indicates the right position
            // of pivot found so far
            int i = (low - 1);

            for (int j = low; j <= high - 1; j++) {

                // If current element is smaller
                // than the pivot
                if (a[j] < pivot) {

                    // Increment index of
                    // smaller element
                    i++;
                    swap(a, i, j);
                }
            }
            int pi = (i + 1);
            swap(a, pi, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    public static int getMedianOfThreePivotIndex(int[] a, int low, int high) {
        int center = (low + high) / 2;
        if ((a[high] < a[center] && a[center] < a[low]) || (a[low] < a[center] && a[center] < a[high]))
            return center;
        else if ((a[center] < a[high] && a[high] < a[low]) || (a[low] < a[high] && a[high] < a[center]))
            return high;
        return low;
    }

    public static final void swap(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static final void heapSort(final int[] disarray) {
        if (disarray.length == 0) {
            return;
        }
        IntegerHeap heap = new FixedIntegerHeap(disarray.length);
        for (int i = 0; i < disarray.length; i++) {
            heap.insert(disarray[i]);
        }
        for (int i = 0; i < disarray.length; i++) {
            disarray[disarray.length - 1 - i] = heap.getMax();
        }
    }

    public static final void quickSortHSLU(final int[] a) {
        quickSortHSLU(a, 0, a.length - 1);
    }

    private static final void quickSortHSLU(final int[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        int t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                swap(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        swap(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1))
            quickSortHSLU(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right)
            quickSortHSLU(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    public static final void quickSortHSLUMedianPivot(final int[] a) {
        quickSortHSLUMedianPivot(a, 0, a.length - 1);
    }

    private static final void quickSortHSLUMedianPivot(final int[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)

        int pivotIndex = getMedianOfThreePivotIndex(a, left, right);
        if (pivotIndex != right) {
            swap(a, pivotIndex, right);
        }

        int t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] > t) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                swap(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        swap(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1))
            quickSortHSLUMedianPivot(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right)
            quickSortHSLUMedianPivot(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
    }

    private static int[] array;

    public static void mergeSortRec(final int[] a) {
        array = new int[a.length]; // zusätzlicher Speicher fürs Mergen
        mergeSortRec(a, 0, a.length - 1);
    }

    private static void mergeSortRec(final int a[], final int left, final int right) {
        int i, j, k, m;
        if (right > left) {
            m = (right + left) / 2; // Mitte ermitteln
            mergeSortRec(a, left, m); // linke Hälfte sortieren
            mergeSortRec(a, m + 1, right); // rechte Hälfte sortieren
            // "Mergen"
            for (i = left; i <= m; i++) { // linke Hälfte in Hilfsarray kopieren
                array[i] = a[i];
            }
            for (j = m; j < right; j++) { // rechte Hälfte umgekehrt in Hilfsa. kopieren
                array[right + m - j] = a[j + 1];
            }
            i = left;
            j = right; // Index für linke und rechte Hälfte
            for (k = left; k <= right; k++) { // füge sortiert in a ein
                if (array[i] <= array[j]) {
                    a[k] = array[i];
                    i++;
                } else {
                    a[k] = array[j];
                    j--;
                }
            }
        }
    }

    public static void mergeSort(int[] a, int threshold) {
        final MergesortTask sortTask = new MergesortTask(a, threshold);
        sortTask.invoke();
    }

    public static void mergeSort(int[] a) {
        final int cores = Runtime.getRuntime().availableProcessors();
        mergeSort(a, a.length / (cores + 1));
    }

    public static void mergeSortT25(int[] a) {
        mergeSort(a, 25);
    }

    public static void mergeSortT1k25(int[] a) {
        mergeSort(a, 1250);
    }

    public static void mergeSortT50(int[] a) {
        mergeSort(a, 50);
    }

    public static void mergeSortT100(int[] a) {
        mergeSort(a, 100);
    }

    public static void mergeSortT200(int[] a) {
        mergeSort(a, 200);
    }

    public static void quickSortForked(int[] a) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new QuicksortTask(a));
    }
}
