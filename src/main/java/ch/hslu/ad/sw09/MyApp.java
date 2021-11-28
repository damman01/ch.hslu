package ch.hslu.ad.sw09;

import java.util.Arrays;
import java.util.Scanner;

public class MyApp {
    public static void main(String args[]) {
        System.out.println("type in a number to add to the heap, type 'm' to get the max value, 'e' to exit");
        FixedIntegerHeap heap = new FixedIntegerHeap(10); // printing only 'works' for 10 items
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            if (s.equals("e")) {
                break;
            } else if (s.equals("m")) {
                System.out.println(heap.getMax());
            } else {
                heap.insert(Integer.valueOf(s));
            }
            printHeap(heap);
            System.out.println(Arrays.toString(heap.getHeap()));

            System.out.println("-".repeat(205));
        }
        in.close();
    }

    private static void printHeap(FixedIntegerHeap heap) {
        int size = heap.getSize();
        int height = getLevelForIndex(size) + 1;
        for (int i = 0; i <= size / 2; i++) {
            System.out.print(" ".repeat((height - i) * 2));
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) <= size; j++) { // Each row has 2^n nodes
                System.out.print(heap.getHeap()[j + (int) Math.pow(2, i) - 1] + " ".repeat(height - (i + 1)));
            }
            System.out.println();
        }
    }

    private static int getLevelForIndex(int x) {
        return x == 0 ? 1 : (int) (Math.log(x) / Math.log(2)) + 1; // = log(x) with base 10 / log(2) with base 10
    }

}
