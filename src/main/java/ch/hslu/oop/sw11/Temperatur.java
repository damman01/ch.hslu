/**
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.oop.sw11;

import java.util.Objects;

import org.apache.logging.log4j.*;

/**
 *
 * @author domin
 */
public final class Temperatur implements Comparable<Temperatur> {

    public static final float KELVIN_OFFSET = 273.15f;
    public static final float MIN_KELVIN = 0f;
    private static Logger LOG = LogManager.getLogger(Temperatur.class);

    private float kelvin;

    /**
     * 
     * @param kelvin Wert der Temperatur
     * @throws IllegalArgumentException
     */
    private Temperatur(final float kelvin) throws IllegalArgumentException {
        String errorMessage = null;
        if (kelvin < Temperatur.MIN_KELVIN) {
            errorMessage = "Eingegebene Temperatur unter Absolutem Nullpunkt!";
        }
        if (errorMessage != null) {
            LOG.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        this.kelvin = kelvin;
        LOG.trace("Eine Temperatur mit {}° Kelvin wurde erzeugt", this.kelvin);
    }

    /**
     * Methode die ein Temperaturobjekt mit der Einheit °Kelvin erzeugt
     * 
     * @param kelvin Wert der Temperatur in Kelvin
     * @return Temperaturobjekt
     * @throws IllegalArgumentException Wird bei Eingabe einer falschen Temperatur geworfen
     */
    public static Temperatur createFromKelvin(final float kelvin) throws IllegalArgumentException {
        return new Temperatur(kelvin);
    }

    /**
     * Methode die ein Temperaturobjekt mit der Einheit °Celsius erzeugt
     * 
     * @param celsius Wert der Temperatur in Celsius
     * @return Temperaturobjekt
     * @throws IllegalArgumentException Wird bei Eingabe einer falschen Temperatur geworfen
     */
    public static Temperatur createFromCelsius(final float celsius) throws IllegalArgumentException {
        return new Temperatur(Temperatur.celsiusToKelvin(celsius));
    }

    /**
     * Diese Methode gibt den Wert der Temperatur in °Celsius zurück
     * @return Wert der Temperatur in °Celsius
     */
    public float getDegreeCelsius() {
        return Temperatur.kelvinToCelsius(this.kelvin);
    }

    public float getDegreeKelvin() {
        return this.kelvin;
    }

    public float getDegreeFahrenheit() {
        return (this.kelvin - Temperatur.KELVIN_OFFSET) * 1.8f + 32;
    }

    public void increaseTemperatur(final float kelvin) {
        this.kelvin += kelvin;
    }

    public void decreaseTemperatur(final float kelvin) {
        this.kelvin -= kelvin;
    }

    /**
     * Konvertiert eine Temperatur von °Celsius in °Kelvin
     *
     * @param celsius Wert der Temperatur die umgrechnet werden soll
     * @return Wert der Temperatur in Kelvin
     */
    public static float celsiusToKelvin(final float celsius) {
        return celsius + Temperatur.KELVIN_OFFSET;
    }

    /**
     * Konvertiret eine Temperatur von °Kelvin in °Celsius
     *
     * @param kelvin Wert der Temperatur die umgrechnet werden soll
     * @return Wert der Temperatur in °Celsius
     */
    public static float kelvinToCelsius(final float kelvin) {
        return kelvin - Temperatur.KELVIN_OFFSET;
    }

    /**
     * Vergleich der Temperatur
     *
     * @param other Temperatur die verglichen wird
     * @return "kleiner als ist -1, gleich ist 0, grösser als ist +1"
     */
    @Override
    public int compareTo(final Temperatur other) {
        return Float.compare(this.kelvin, other.kelvin);
    }

    @Override
    public String toString() {
        return "\n Temperatur{" + "Kelvin=" + kelvin + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.kelvin);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Temperatur)) {
            return false;
        }
        final Temperatur other = (Temperatur) obj;
        return Objects.equals(this.kelvin, other.kelvin);
    }
}
