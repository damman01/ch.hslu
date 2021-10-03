package ch.hslu.ad.sw01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SimpleMemoryTest {

    @Test
    public void allocate_testWhenEmpty() {
        // given
        Memory testMemory = new SimpleMemory(16);

        // when
        Allocation result = testMemory.allocate(6);

        // then
        assertNotNull(result);
        assertEquals(0, result.getAddress());
        assertEquals(6, result.getSize());
    }

    @Test
    public void allocate_testWhenContainingAllocations() {
        // given
        Memory testMemory = new SimpleMemory(16);
        testMemory.allocate(6);

        // when
        Allocation result = testMemory.allocate(4);

        // then
        assertNotNull(result);
        assertEquals(6, result.getAddress());
        assertEquals(4, result.getSize());
    }

    @Test
    public void allocate_testWhenFull() {
        // given
        Memory testMemory = new SimpleMemory(16);
        testMemory.allocate(6);

        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testMemory.allocate(32));
        String actualMessage = exception.getMessage();

        // then
        String expectedMessage = "it would exceed provided memory size";
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void free_test() {
        // given
        Memory testMemory = new SimpleMemory(16);
        Allocation testAllocation = testMemory.allocate(6);

        // when
        testMemory.free(testAllocation);

        // then
        assertEquals(0, testMemory.getCurrentSize());
    }

    @Test
    public void free_testNotContaining() {
        // given
        Memory testMemory = new SimpleMemory(16);
        Allocation illegalAllocation = new Allocation(0, 16);

        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testMemory.free(illegalAllocation));
        String actualMessage = exception.getMessage();

        // then
        String expectedMessage = "provided allocation is allocated";
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getCurrentSize_test() {
        // given
        Memory testMemory = new SimpleMemory(16);
        testMemory.allocate(6);

        // when
        long result = testMemory.getCurrentSize();

        // then
        assertEquals(6, result);
    }

    @Test
    public void getFreeMemorySize_test() {
        // given
        Memory testMemory = new SimpleMemory(16);
        testMemory.allocate(6);

        // when
        long result = testMemory.getFreeMemorySize();

        // then
        assertEquals(10, result);
    }

    @Test
    public void getFreeFittingAddress_testEmptyMemory() {
        // given
        SimpleMemory testMemory = new SimpleMemory(16);

        // when
        long result = testMemory.getFreeFittingAddress(8);

        // then
        assertEquals(0, result);
    }

    @Test
    public void getFreeFittingAddress_testContainingAllocation() {
        // given
        SimpleMemory testMemory = new SimpleMemory(16);
        testMemory.allocate(8);

        // when
        long result = testMemory.getFreeFittingAddress(4);

        // then
        assertEquals(8, result);
    }

    @Test
    public void getFreeFittingAddress_testContainingAllocationGaps() {
        // given
        SimpleMemory testMemory = new SimpleMemory(16);
        Allocation testAllocation = testMemory.allocate(8);
        testMemory.allocate(4);
        testMemory.free(testAllocation);

        // when
        long result = testMemory.getFreeFittingAddress(8);

        // then
        assertEquals(0, result);
    }

    @Test
    public void getFreeFittingAddress_testContainingAllocationGaps2() {
        // given
        SimpleMemory testMemory = new SimpleMemory(16);
        Allocation testAllocation = testMemory.allocate(8);
        testMemory.allocate(4);
        testMemory.free(testAllocation);

        // when
        long result = testMemory.getFreeFittingAddress(9);

        // then
        assertEquals(12, result);
    }

}
