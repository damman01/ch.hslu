/*
 * Copyright 2021 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw10.fibo;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Codevorlage für die Verwendung von RecursiveTask mit einem Fork-Join-Pool.
 */
public final class DemoFibonacciCalc {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.ad.sw10.fibo.DemoFibonacciCalc.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFibonacciCalc() {
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    /**
     * Berechnet den Fibonacci Wert für n 
     * parallelisiert mit Common Pool
     * 
     * @param n für die Fibonacci Berechnung
     * @return Resultat der Fibonacci Berechnung
     */
    public static long fiboCommonPool(final int n) {
        return new FibonacciTask(n).fork().join();
    }


    /**
     * Berechnet den Fibonacci Wert für n parallelisiert
     * verwendet den ForkJoinPool
     *
     * @param n für die Fibonacci Berechnung
     * @return Resultat der Fibonacci Berechnung
     */
    public static long fiboForkJoinPool(int n) {
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(n);
        return pool.invoke(task);
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        fiboCalc();
    }

    public static void fiboCalc(){
        final int n = 44;
        final FibonacciTask task = new FibonacciTask(n);
        LOG.info("fibo({}) start...", n);
        Instant start = Instant.now();
        long result = task.invoke();
        Instant end = Instant.now();
        LOG.info("Conc. recursive  = {}", result);
        LOG.info("Conc. recurs [ms]: {}", Duration.between(start, end).toMillis());
        start = Instant.now();
        result = fiboIterative(n);
        end = Instant.now();
        LOG.info("Func. iterative  = {}", result);
        LOG.info("Func. iterat [ns]: {}", Duration.between(start, end).toNanosPart());
        start = Instant.now();
        result = fiboRecursive(n);
        end = Instant.now();
        LOG.info("Func. recursive  = {}", result);
        LOG.info("Func. recurs [ms]: {}", Duration.between(start, end).toMillis());
        start = Instant.now();
        result = fiboCommonPool(n);
        end = Instant.now();
        LOG.info("Common Pool      = {}", result);
        LOG.info("Common Pool  [ms]: {}", Duration.between(start, end).toMillis());
        start = Instant.now();
        result = fiboForkJoinPool(n);
        end = Instant.now();
        LOG.info("ForkJoin Pool    = {}", result);
        LOG.info("ForkJoin Pool[ms]: {}", Duration.between(start, end).toMillis());
    }
}
