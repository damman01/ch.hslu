package ch.hslu.ad.sw10.mergesort;

/**
 * Codebeispiel zu Mergesort für die Sortierung eines int-Arrays.
 */
public final class MergesortRecursive {

    private static int[] array;

    private MergesortRecursive() {
    }

    /**
     * Sortiert ein int-Array mit dem Mergesort-Algorithmus.
     * 
     * @param a int-Array zum Sortieren
     */
    public static void mergeSort(final int[] a) {
        array = new int[a.length]; // zusätzlicher Speicher fürs Mergen
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * Interner Mergesort mit Ober- und Untergrenze.
     * 
     * @param a     int-Array zum Sortieren.
     * @param left  Linke Grenze.
     * @param right Rechte Grenze.
     */
    private static void mergeSort(final int a[], final int left, final int right) {
        int i, j, k, m;
        if (right > left) {
            m = (right + left) / 2; // Mitte ermitteln
            mergeSort(a, left, m); // linke Hälfte sortieren
            mergeSort(a, m + 1, right); // rechte Hälfte sortieren
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
}
