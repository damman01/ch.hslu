package ch.hslu.ad.sw04.hashtable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.*;
import org.junit.platform.commons.annotation.Testable;

import ch.hslu.ad.sw01.Allocation;

public class AllocHashTableTest {

    @Test
    void testAdd() {
        AllocHashTable testTable = new AllocHashTable();
        Allocation testElement = new Allocation(1, 10);

        testTable.add(testElement);

        assertThat(testTable.isFull()).isFalse();
        assertThat(testTable.contains(testElement)).isTrue();
        assertThat(testTable.size()).isOne();
    }

    @Test
    void testAddDupe() {
        AllocHashTable testTable = new AllocHashTable();
        Allocation testElement = new Allocation(1, 20);

        testTable.add(testElement);

        assertThat(testTable.add(testElement)).isFalse();

    }

    @Test
    void testAddSameIndex() {

        AllocHashTable testTable = new AllocHashTable();
        Allocation testElement1 = new Allocation(1, 30);
        Allocation testElement2 = new Allocation(1, 40);

        testTable.add(testElement1);

        assertThat(testTable.add(testElement2)).isTrue();
        assertThat(testTable.contains(testElement1)).isTrue();
        assertThat(testTable.contains(testElement2)).isTrue();
        assertThat(testTable.size()).isEqualTo(2);

    }

    @Test
    void testAddNullElement() {
        HashTable<Allocation> testTable = new AllocHashTable();
        Allocation testElement = null;

        assertThatIllegalArgumentException().isThrownBy(() -> testTable.add(testElement))
                .withMessage("Element can't be NULL");

    }

    @Test
    void testRemoveElement() {
        AllocHashTable testTable = new AllocHashTable();
        Allocation testElement = null;

        assertThatIllegalArgumentException().isThrownBy(() -> testTable.remove(testElement))
                .withMessage("Element can't be NULL");

    }

    @Test
    void testContainsNull() {
        AllocHashTable testTable = new AllocHashTable();
        Allocation testElement = null;

        assertThat(testTable.contains(testElement)).isFalse();

    }

    @Test
    void testAddFullTable() {

        AllocHashTable testTable = fillTable();
        Allocation testElement = new Allocation(11, 10);

        assertThatIllegalStateException().isThrownBy(() -> testTable.add(testElement))
                .withMessage("Hashtable already full");
        assertThat(testTable.isFull()).isTrue();
        assertThat(testTable.size()).isEqualTo(10);
    }

    @Testable
    AllocHashTable fillTable() {

        AllocHashTable testTable = new AllocHashTable();
        testTable.add(new Allocation(1, 10));
        testTable.add(new Allocation(2, 10));
        testTable.add(new Allocation(3, 10));
        testTable.add(new Allocation(4, 10));
        testTable.add(new Allocation(5, 10));
        testTable.add(new Allocation(6, 10));
        testTable.add(new Allocation(7, 10));
        testTable.add(new Allocation(8, 10));
        testTable.add(new Allocation(9, 10));
        testTable.add(new Allocation(10, 10));

        return testTable;
    }

    @Test
    void testFillTable() {
        assertThat(fillTable().isFull()).isTrue();
    }

}
