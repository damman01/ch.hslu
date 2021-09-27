package ch.hslu.oop.sw08;

import java.util.ArrayList;
import java.util.List;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


final class PersonTest {
    /**
     * Test für Equals Contract
     */
    //@Test
    //void testEqualsContract() {
    //    EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    //}
    
    @Test
    void testEqualsContractComp() {
        EqualsVerifier.forClass(PersonNameComparator.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
    
    /**
     * Test für Konstruktor
     */
    @Test
    void testPerson() {
        final Person person = new Person("Strange", "Steven", 124);
        assertEquals("Strange", person.getNachname());
        assertEquals("Steven", person.getVorname());
        assertEquals(124, person.getpID());
    }
    
    /**
     * Test für toString Methode
     * 
     */
    @Test
    void testToString() {
        assertThat(new Person("Ammann", "Dominic", 51265).toString()).startsWith("Person").contains("Ammann").contains("Dominic").contains("51265");
        System.out.println(new Person("Ammann", "Dominic", 51265).toString());
    }
    
    /**
     * Test Equals
     * Beide Personen sind gleich
     */
    @Test
    void testEqualsValueEquals(){
        final Person p1 = new Person("Banner", "Bruce", 98796);
        final Person p2 = new Person("Banner", "Bruce", 98796);
        assertEquals(p1, p2);
    }
    
    /**
     * Test Equals
     * Zwei verschiedene Personen mit gleicher ID
     */
    @Test
    void testEqualsValueEqualsFalse(){
        final Person p1 = new Person("Stark", "Tony", 3000);
        final Person p2 = new Person("Iron", "Man", 3000);
        assertNotEquals(true, p1.equals(p2)); //FALSE = FALSE
    }
    
    /**
     * Test von Person1.equals(Person2)
     */
    @Test
    void testEqualsValueEqualsTrue(){
        final Person p1 = new Person("Wayne", "Bruce", 253465);
        final Person p2 = new Person("Wayne", "Bruce", 253465);
        assertTrue(p1.equals(p2));
    }
    
    /**
     * Test der HashCode generation
     * Mit einer Stelle Unterschied der ID
     */
    @Test
    void testHashCode(){
        final Person p1 = new Person("Kent", "Clarke", 651964218654l);
        final Person p2 = new Person("Kent", "Clarke", 651964218653l);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        assertTrue(p1.hashCode() != p2.hashCode());
    }
    
    /**
     * Test der compareTo Methode
     * "4000 &lt; 5000"
     */
    @Test
    void testCompareToKleinerAls(){
        assertThat(new Person("Parker", "Peter", 4000).compareTo(new Person("Parker", "Peter", 5000))).isNegative();
    }
    
    /**
     * Test der compareTo Methode
     * "6000 &gt; 5000"
     */
    @Test
    void testCompareToGleich(){
        assertThat(new Person("Parker", "Peter", 6000).compareTo(new Person("Parker", "Peter", 5000))).isPositive();
    }
    
    /**
     * Test compareTo
     * 0 = 0
     */
    @Test
    void testCompareToZero(){
        assertThat(new Person("Parker", "Peter", 0).compareTo(new Person("Parker", "Peter", 0))).isZero();
    }
    
    
    /**
     * Test PersonNameComparator
     * "Curry &lt; Zemo"
     */
    @Test
    void testPersonNameComparator() {
        final Person p1 = new Person("Curry", "Arthur", 5000);
        final Person p2 = new Person("Zemo", "Helmut", 6000);
        assertThat(new PersonNameComparator().compare(p1, p2)).isNegative();
    }
    
    /**
     * Test PersonNameComparator
     * "Atlana &gt; Arthur"
     */
    @Test
    void testPersonNameComparatorSame() {
        final Person p1 = new Person("Curry", "Athlana", 8000);
        final Person p2 = new Person("Curry", "Arthur", 2000);
        assertThat(new PersonNameComparator().compare(p1, p2)).isPositive();
    }
    
    
    @Test
    void testComparatorList()
    {
        final List<Person> helden = new ArrayList<>();
        
        helden.add(new Person("Curry", "Arthur", 2000));
        helden.add(new Person("Parker", "Peter", 0));
        helden.add(new Person("Wayne", "Bruce", 400));
        helden.add(new Person("Banner", "Bruce", 33413));
        helden.add(new Person("Stark", "Tony", 3000));
        
        
        helden.sort(new PersonNameComparator());
        
        for(Person p : helden)
            System.out.println(p);
        
        assertThat(helden.get(helden.size() - 1).getNachname()).isEqualTo("Wayne");
    }
    
    
}
