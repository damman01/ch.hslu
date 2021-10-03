package ch.hslu.ad.sw02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ListIteratorTest {

    @Test
    public void hasNextValidTest() {
        // given
        List<String> testList = new SingleList<>();
        testList.add("Element 1");
        testList.add("Element 2");
        testList.add("Element 3");
        Iterator<String> testIterator = testList.iterator();

        // when
        boolean result = testIterator.hasNext();

        // then
        assertTrue(result);
    }

    @Test
    public void hasNextEmptyListTest() {
        // given
        List<String> testList = new SingleList<>();
        Iterator<String> testIterator = testList.iterator();

        // when
        boolean result = testIterator.hasNext();

        // then
        assertFalse(result);
    }

    @Test
    public void nextEmptyListTest() {
        // given
        List<String> testList = new SingleList<>();
        Iterator<String> testIterator = testList.iterator();

        // when & then
        assertThrows(NoSuchElementException.class, () -> testIterator.next());
    }

    @Test
    public void nextValidTest() {
        // given
        List<String> testList = new SingleList<>();
        testList.add("Element 1");
        testList.add("Element 2");
        String lastElement = "Element 3";
        testList.add(lastElement);
        Iterator<String> testIterator = testList.iterator();

        // when
        String result = testIterator.next();

        // then
        assertEquals(lastElement, result);
    }

    @Test
    public void nextAndHasNextSingleItemListTest() {
        // given
        List<String> testList = new SingleList<>();
        String onlyElement = "alone";
        testList.add(onlyElement);
        Iterator<String> testIterator = testList.iterator();

        // when & then - order sensitive
        assertTrue(testIterator.hasNext());
        assertEquals(onlyElement, testIterator.next());
        assertFalse(testIterator.hasNext());
    }

}
