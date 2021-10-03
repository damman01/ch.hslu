package ch.hslu.ad.sw01.recursion;

public class Ackermann {

    public static void main(String[] args) {
        for (int m = 1; m <= 3; m++) {
            for (int n = 0; n <= 12; n++) {
                calls = 0;
                System.out.println(String.format("%-20s %-20s %-20s %-20s", m, n, ackermann(m, n), calls));
            }
        }

    }

    private static long calls = 0;

    public static long ackermann(long m, long n) {
        calls++;
        if (m == 0)
            return n + 1;
        if (n == 0)
            return ackermann(m - 1, 1);
        return ackermann(m - 1, ackermann(m, n - 1));
    }

}
