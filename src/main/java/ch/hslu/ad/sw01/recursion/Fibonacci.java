package ch.hslu.ad.sw01.recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    
    private Fibonacci() {
    }

    public static long fiboRec1(int n) {
        if (n == 0 || n == 1) { // Rekursionsbasis
            return n;
        }
        return fiboRec1(n - 2) + fiboRec1(n - 1); // Rekursionsvorschrift
    }

    private static List<Long> fiboRecord = new ArrayList<>(List.of(0L, 1L)); // Rekursionsbasis

    public static long fiboRec2(int n) {
        if (n >= fiboRecord.size()) {
            Long currentFibo = fiboRec2(n - 2) + fiboRec2(n - 1); // Rekursionsvorschrift
            fiboRecord.add(currentFibo);
            return currentFibo;
        }

        return fiboRecord.get(n);
    }

    public static long fiboIter(int n) {
        List<Long> recordList = new ArrayList<>(List.of(0L, 1L));
        for (int i = 2; i <= n; i++) {
            recordList.add(recordList.get(i - 2) + recordList.get(i - 1));
        }
        return recordList.get(n);
    }

}
