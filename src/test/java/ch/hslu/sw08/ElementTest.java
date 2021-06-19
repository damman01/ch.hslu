package ch.hslu.sw08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ElementTest {
    /**
     * Test für Equals Contract
     */
    //@Test
    //void testEqualsContract() {
    //    EqualsVerifier.forClass(Element.class).suppress(Warning.NONFINAL_FIELDS).verify();
    //}
    /**
     * Test Stickstoff bei Raumtemp
     * Mit float an Konstruktor
     */
    @Test
    public void testGetAggregationOfGold() {
        final Element gold = new Element (3000f, 1064.18f, 2970f);
        System.out.println(gold);
        assertEquals("gasförmig", gold.getAggregation());
    }
    
    
    /**
     * Test Quecksilber bei Raumtemp
     * Mit 3* Temperatur an Konstruktor
     */
    @Test
    public void testGetAggregationOfMagnesium() {
        final Element magnesium = new Element (new Temperatur (800f), new Temperatur (650f), new Temperatur (1110f));
        System.out.println(magnesium);
        assertEquals("flüssig", magnesium.getAggregation());
    }
    
    /**
     * Test Blei bei Raumtemp
     * Mit 2*Temperatur an Konstruktor
     * 
     */
    @Test
    public void testGetAggregationOfBarium() {
        final Element barium = new Element (new Temperatur (727f), new Temperatur (1637f));
        System.out.println(barium);
        assertEquals("fest", barium.getAggregation());
    }
    
    /**
     * Test getTemp bei 2 Temperaturen an Konstruktor
     */
    @Test
    public void testGetDegreeCelsius() {
        assertEquals(20.0f,new Element(new Temperatur (30f), new Temperatur (40f)).getDegreeCelsius());
    }
    
    /**
     * Test der Blei Klasse
     * Blei bei Raumtemperatur
     */
    @Test
    public void testBlei(){
        assertEquals("fest", new Blei().getAggregation());
    }
    
    /**
     * Test der Quecksilber Klasse
     * Quecksilber mit Übergabe einer float 
     */
    @Test
    public void testQuecksilber(){
        assertEquals("gasförmig", new Quecksilber(360f).getAggregation());
    }
    
    /**
     * Test der Stickstoff Klasse
     * Stickstoff mit Übergabe einer Temperatur
     */
    @Test
    public void testStickstoff(){
        assertEquals("fest", new Stickstoff(new Temperatur(-270f)).getAggregation());
    }
}

