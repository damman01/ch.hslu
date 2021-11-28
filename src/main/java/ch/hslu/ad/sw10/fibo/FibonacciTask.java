package ch.hslu.ad.sw10.fibo;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public final class FibonacciTask extends RecursiveTask<Long> {

    private final int n;

    public FibonacciTask(final int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n > 1) {
            ForkJoinTask<Long> lastNumber = new FibonacciTask(n - 1).fork();
            FibonacciTask penultimateNumber = new FibonacciTask(n - 2);
            return penultimateNumber.compute() + lastNumber.join();
        }

        return Long.valueOf(n);
    }
}
