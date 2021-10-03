package ch.hslu.ad.sw01.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void fiboRec1_testRecursionBase() {
        // given
        int n = 1;

        // when
        long result = Fibonacci.fiboRec1(n);

        // then
        assertEquals(1, result);
    }

    @Test
    public void fiboRec1_testLowNumber() {
        // given
        int n = 3;

        // when
        long result = Fibonacci.fiboRec1(n);

        // then
        assertEquals(2, result);
    }

    @Test
    public void fiboRec1_testHighNumber() {
        // given
        int n = 30;

        // when
        long result = Fibonacci.fiboRec1(n);

        // then
        assertEquals(832040, result);
    }

    @Test
    public void fiboRec2_testRecursionBase() {
        // given
        int n = 1;

        // when
        long result = Fibonacci.fiboRec2(n);

        // then
        assertEquals(1, result);
    }

    @Test
    public void fiboRec2_testLowNumber() {
        // given
        int n = 3;

        // when
        long result = Fibonacci.fiboRec2(n);

        // then
        assertEquals(2, result);
    }

    @Test
    public void fiboRec2_testHighNumber() {
        // given
        int n = 30;

        // when
        long result = Fibonacci.fiboRec2(n);

        // then
        assertEquals(832040, result);
    }

    @Test
    public void fiboIter_testRecursionBase() {
        // given
        int n = 0;

        // when
        long result = Fibonacci.fiboIter(n);

        // then
        assertEquals(0, result);
    }

    @Test
    public void fiboIter_testLowNumber() {
        // given
        int n = 3;

        // when
        long result = Fibonacci.fiboIter(n);

        // then
        assertEquals(2, result);
    }

    @Test
    public void fiboIter_testHighNumber() {
        // given
        int n = 30;

        // when
        long result = Fibonacci.fiboIter(n);

        // then
        assertEquals(832040, result);
    }

}
