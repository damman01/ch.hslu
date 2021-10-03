package ch.hslu.ad.sw01.recursion;

import java.util.EnumMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AhaExample {
    private static Map<TaskType, Long> taskInvocationCount = new EnumMap<>(TaskType.class);
    private static final Logger LOG = LogManager.getLogger(AhaExample.class);

    public static void main(String[] args) {
        int n = 1;
        int b = 2; // base number
        for (int i = 1; i <= 16; i++) {
            n = n * b;
            task(n);
        }
    }

    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2();
            task2();
            task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3();
                task3(); // T ~ n · n· 2
            }
        }
        logInvocationSummary(n);
    }

    private static void logInvocationSummary(int n) {
        LOG.log(Level.INFO,
                () -> String.format("%-20s %-20s %-20s %-20s %-20s", n, taskInvocationCount.get(TaskType.TASK1),
                        taskInvocationCount.get(TaskType.TASK2), taskInvocationCount.get(TaskType.TASK3),
                        taskInvocationCount.values().stream().mapToLong(Long::longValue).sum()));
        taskInvocationCount = new EnumMap<>(TaskType.class);
    }

    private static void task3() {
        logInvocationCount(TaskType.TASK3);
    }

    private static void logInvocationCount(TaskType type) {
        if (taskInvocationCount.containsKey(type)) {
            taskInvocationCount.put(type, taskInvocationCount.get(type).longValue() + 1);
        } else {
            taskInvocationCount.put(type, 1L);
        }
    }

    private static void task2() {
        logInvocationCount(TaskType.TASK2);
    }

    private static void task1() {
        logInvocationCount(TaskType.TASK1);
    }
}

enum TaskType {
    TASK1, TASK2, TASK3;
}
