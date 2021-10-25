package ch.hslu.ad.sw04.hashtable;

import java.util.*;

import org.apache.logging.log4j.*;

import ch.hslu.ad.sw02.stack.StackArray;

public class MainHashTable {

    private static Logger lLOG = LogManager.getLogger(MainHashTable.class);
    private static int arraySize = 100000000;
    private static int testRuns = 20;

    public static void main(String[] args) {
        StackArray testStack = new StackArray(arraySize);

        for (int i = 1; i <= testRuns; i++) {
            long startTime = System.currentTimeMillis();

            int t = 0;
            for (int j = 0; j < arraySize; j++) {
                testStack.push("t= " + t++);

            }
            lLOG.info("MyStack Test{} Duration = {}", i, System.currentTimeMillis() - startTime);
            // clear stack
            while (!testStack.isEmpty()) {
                testStack.pop();
            }
        }

        @SuppressWarnings("java:S1149")
        Stack<String> testStack2 = new Stack<>();
        for (int i = 1; i <= testRuns; i++) {
            long startTime = System.currentTimeMillis();

            int t = 0;
            for (int j = 0; j < arraySize; j++) {
                testStack2.push("t= " + t++);

            }
            lLOG.info("Stack Test{} Duration = {}", i, System.currentTimeMillis() - startTime);
            // clear stack
            while (!testStack2.empty()) {
                testStack2.pop();
            }
        }

        ArrayDeque<String> testStack3 = new ArrayDeque<>(arraySize);
        for (int i = 1; i <= testRuns; i++) {
            long startTime = System.currentTimeMillis();

            int t = 0;
            for (int j = 0; j < arraySize; j++) {
                testStack3.addLast("t= " + t++);

            }
            lLOG.info("Deque Test{} Duration = {}", i, System.currentTimeMillis() - startTime);
            // clear stack
            testStack3.clear();
        }

    }

}
