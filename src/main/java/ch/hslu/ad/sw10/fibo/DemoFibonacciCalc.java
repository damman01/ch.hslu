package ch.hslu.ad.sw10.fibo;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw01.recursion.Fibonacci;

/**
 * Codevorlage für die Verwendung von RecursiveTask mit einem Fork-Join-Pool.
 */
public final class DemoFibonacciCalc {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.sw10.fibo.DemoFibonacciCalc.class);

    private static final Map<String, Function<Integer, Long>> METHODS = new HashMap<>();
    static {
        METHODS.put("Conc. recursive", DemoFibonacciCalc::fiboConcurrentRecursive);
        METHODS.put("Func. recursive ", DemoFibonacciCalc::fiboRecursive);
        METHODS.put("Func. iterative", DemoFibonacciCalc::fiboIterative);
        METHODS.put("Func. recursive w/ mem", Fibonacci::fiboRec2);
    }

    private static final int FIBO_DEPTH = 42;

    public static void main(final String[] args) {
        LOG.info("starting fibo calls with n={}", FIBO_DEPTH);
        for (Entry<String, Function<Integer, Long>> method : METHODS.entrySet()) {
            Instant start = Instant.now();
            long result = method.getValue().apply(FIBO_DEPTH);
            Instant end = Instant.now();
            LOG.info("{} result = {}", method.getKey(), result);
            LOG.info("{} : {} ms.", method.getKey(), Duration.between(start, end).toMillis());
        }
    }

    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    public static long fiboConcurrentRecursive(final int n) {
        final ForkJoinPool pool = new ForkJoinPool();
        final FibonacciTask task = new FibonacciTask(n);
        return pool.invoke(task);
    }
}
