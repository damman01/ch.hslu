package ch.hslu.ad.sw02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class SingleListTest {

	@Test
	public void testAddSingle() {
		List<String> testList = new SingleList<>();
		String newElement = "Test Element";

		testList.add(newElement);

		assertEquals(newElement, testList.getHead().getData());
		assertEquals(1, testList.size());
	}

	@Test
	void testAddNull() {
		List<String> testList = new SingleList<>();

		assertThrows(IllegalArgumentException.class, () -> testList.add(null));

	}

	@Test
	void testAddMulti() {
		List<String> testList = new SingleList<>();
		String elementOne = "Erstes Element";
		String elementTwo = "Zweites Element";
		String elementThree = "Drittes Element";

		testList.add(elementOne);
		testList.add(elementTwo);
		testList.add(elementThree);

		assertEquals(elementThree, testList.getHead().getData());
		assertEquals(elementTwo, testList.getHead().getNext().getData());
		assertEquals(3, testList.size());

	}

	@Test
	void removeExistingElementTest() {
		// given
		List<String> testList = new SingleList<>();
		String firstElement = "Element 1";
		String secondElement = "Element 2";
		String thirdElement = "Element 3";
		testList.add(firstElement);
		testList.add(secondElement);
		testList.add(thirdElement);

		// when
		testList.remove(secondElement);

		// then
		assertEquals(thirdElement, testList.getHead().getData());
		assertEquals(firstElement, testList.getHead().getNext().getData());
		assertEquals(2, testList.size());
	}

	@Test
	void testPop() {

		List<String> testList = new SingleList<>();
		String firstElement = "Element Eins";
		String secondElement = "Element Zwei";
		String thirdElement = "Element Drei";
		testList.add(firstElement);
		testList.add(secondElement);
		testList.add(thirdElement);

		String result = testList.pop();

		assertEquals(thirdElement, result);
		assertEquals(2, testList.size());

	}

	@Test
	void testPopEmpty() {
		List<String> testList = new SingleList<>();

		assertThrows(NoSuchElementException.class, () -> testList.pop());
	}

	@Test
	void testPopEmptiedList() {
		List<String> testList = new SingleList<>();

		String firstElement = "Element";
		testList.add(firstElement);

		String result = testList.pop();

		assertThrows(NoSuchElementException.class, () -> testList.pop());
		assertEquals(firstElement, result);
	}
}
