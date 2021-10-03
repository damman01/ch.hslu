package ch.hslu.ad.sw01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class AllocationTest {
    @Test
    public void equalsHashCodeContracts() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }

    @Test
    public void toStringTest() {
        // given
        Allocation testAllocation = new Allocation(0, 16);

        // when
        String result = testAllocation.toString();

        // then
        assertNotNull(result);
        assertTrue(result.contains("Allocation"));
        assertTrue(result.contains("address=0"));
        assertTrue(result.contains("size=16"));
    }

    @Test
    public void testCompareTo_lower() {
        // given
        Allocation first = new Allocation(0, 16);
        Allocation second = new Allocation(16, 16);

        // when
        int result = first.compareTo(second);

        // then
        assertTrue(result > 0);
    }

    @Test
    public void testCompareTo_equals() {
        // given
        Allocation first = new Allocation(0, 16);
        Allocation second = new Allocation(0, 16);

        // when
        int result = first.compareTo(second);

        // then
        assertEquals(0, result);
    }

    @Test
    public void testCompareTo_higher() {
        // given
        Allocation first = new Allocation(0, 16);
        Allocation second = new Allocation(16, 16);

        // when
        int result = second.compareTo(first);

        // then
        assertTrue(result < 0);
    }
}
