package ch.hslu.sw09;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

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
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Temperatur.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testGetDegreeCelsius() {
        assertThat(new Temperatur(100.001f).getDegreeCelsius()).isEqualTo(-173.149f, offset(0.001f));
    }

    @Test
    public void testSetKelvin() {
        final Temperatur testTemp = new Temperatur();
        testTemp.setKelvin(500.123f);
        assertThat(testTemp.getDegreeKelvin()).isEqualTo(500.123f);
    }

    @Test
    public void testGetDegreeKelvin() {
        assertThat(new Temperatur(3.15f).getDegreeKelvin()).isEqualTo(3.15f, offset(0.0001f));
    }

    @Test
    public void testGetDegreeFahrenheit() {
        assertThat(new Temperatur(273.15f).getDegreeFahrenheit()).isEqualTo(32f, offset(0.0001f));
    }

    @Test
    public void testIncreaseTemperatur() {
        final Temperatur testTemp = new Temperatur();
        testTemp.increaseTemperatur(25f);
        assertThat(testTemp.getDegreeCelsius()).isEqualTo(45f);
    }

    @Test
    public void testDecreaseTemperatur() {
        final Temperatur testTemp = new Temperatur();
        testTemp.decreaseTemperatur(654.321f);
        assertThat(testTemp.getDegreeCelsius()).isEqualTo(-634.321f);
    }

    @Test
    public void testToString() {
        assertThat(new Temperatur().toString()).startsWith("Temperatur{").contains("293").endsWith("293.15}");
    }

}
