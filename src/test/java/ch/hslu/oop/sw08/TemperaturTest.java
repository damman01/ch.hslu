package ch.hslu.oop.sw08;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.Test;


/**
 *
 * @author Dominic Ammann at HSLU
 */
public class TemperaturTest {
    /**
     * Test für Equals Contract
     */
    //@Test
    //void testEqualsContract() {
    //    EqualsVerifier.forClass(Temperatur.class).suppress(Warning.NONFINAL_FIELDS).verify();
    //}
    
    @Test
    public void testGetDegreeCelsius() {
        assertThat(new Temperatur(100.001f).getDegreeCelsius()).isEqualTo(100.001f);
    }

    @Test
    public void testSetDegreeCelsius() {
        final Temperatur testTemp = new Temperatur();
        testTemp.setDegreeCelsius(500.123f);
        assertThat(testTemp.getDegreeCelsius()).isEqualTo(500.123f);
    }

    @Test
    public void testGetDegreeKelvin() {
        assertThat(new Temperatur(-270f).getDegreeKelvin()).isEqualTo(3.15f, offset(0.0001f));
    }

    @Test
    public void testGetDegreeFahrenheit() {
        assertThat(new Temperatur(0f).getDegreeFahrenheit()).isEqualTo(32f, offset(0.0001f));
    }

    @Test
    public void testIncreaseTemperatur() {
        final Temperatur testTemp = new Temperatur();
        testTemp.increaseTemperatur(456.123f);
        assertThat(testTemp.getDegreeCelsius()).isEqualTo(476.123f);
    }

    @Test
    public void testDecreaseTemperatur() {
        final Temperatur testTemp = new Temperatur();
        testTemp.decreaseTemperatur(654.321f);
        assertThat(testTemp.getDegreeCelsius()).isEqualTo(-634.321f);
    }
    
    
    @Test
    public void testToString() {
        assertThat(new Temperatur().toString()).startsWith("Temperatur{").contains("20").endsWith("20.0}");
    }

    
}
