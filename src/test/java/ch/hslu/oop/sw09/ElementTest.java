package ch.hslu.oop.sw09;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {
    /**
     * Test für Equals Contract
     */
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Element.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
    
    /**
     * Test der Blei Klasse
     * Blei bei Raumtemperatur
     */
    @Test
    public void testBlei(){
        Blei blei = new Blei(20.0f);
        assertEquals("fest", blei.getAggregation().getName());
        System.out.println(blei);
    }
    
    /**
     * Test der Quecksilber Klasse
     * Quecksilber mit Übergabe einer float 
     */
    @Test
    public void testQuecksilber(){
        assertEquals("gasförmig", new Quecksilber(360f).getAggregation().getName());
    }
    
    /**
     * Test der Stickstoff Klasse
     * Stickstoff mit Übergabe einer Temperatur
     */
    @Test
    public void testStickstoff(){
        assertEquals("fest", new Stickstoff(-270f).getAggregation().getName());
    }
}

