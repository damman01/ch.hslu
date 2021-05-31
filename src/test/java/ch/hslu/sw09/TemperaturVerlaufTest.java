/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Dominic Ammann
 */
public class TemperaturVerlaufTest {


    /**
     * Test of clear method, of class TemperaturVerlauf.
     */
    @Test
    public void testClear() {
        TemperaturVerlauf tempVerlauf = new TemperaturVerlauf();
        tempVerlauf.addTemp(new Temperatur());
        tempVerlauf.clear();
        assertThat(tempVerlauf.getCount()).isZero();
    }

    /**
     * Test of add method, of class TemperaturVerlauf.
     */
    @Test
    public void testAddTemp() {
        TemperaturVerlauf tempVerlauf = new TemperaturVerlauf();
        tempVerlauf.addTemp(new Temperatur(10.0f));
        tempVerlauf.addTemp(new Temperatur(20.0f));

        assertEquals(20.0f, (tempVerlauf.get(1)).getDegreeKelvin());
    }

    /**
     * Test of getMaxTemp method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetMaxTemp() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        verlauf.addTemp(new Temperatur(10.0f));
        verlauf.addTemp(new Temperatur(20.0f));
        verlauf.addTemp(new Temperatur(30.0f));
        verlauf.addTemp(new Temperatur(5.0f));

        assertEquals(30.0f, (verlauf.maxTemp()));

    }

    /**
     * Test of getCount method, of class TemperaturVerlauf.
     */
    @Test
    public void testGetCount() {
        TemperaturVerlauf tempVerlauf = new TemperaturVerlauf();
        tempVerlauf.addTemp(new Temperatur());
        tempVerlauf.addTemp(new Temperatur());
        tempVerlauf.addTemp(new Temperatur());
        assertThat(tempVerlauf.getCount()).isEqualTo(3);
    }

    /**
     * Test of compareTo method, of class TemperaturVerlauf.
     */
    @Test
    public void testCompareTo() {
        TemperaturVerlauf tempVerlauf = new TemperaturVerlauf();
        tempVerlauf.addTemp(new Temperatur(10f));
        
        TemperaturVerlauf newTempVerlauf = new TemperaturVerlauf();
        newTempVerlauf.addTemp(new Temperatur(20f));
        
        assertThat(tempVerlauf.compareTo(newTempVerlauf)).isZero();
    }

}
