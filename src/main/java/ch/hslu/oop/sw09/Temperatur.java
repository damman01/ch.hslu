/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.oop.sw09;

import java.util.Objects;

/**
 *
 * @author domin
 */
public final class Temperatur implements Comparable<Temperatur> {

    public static final float KELVIN_OFFSET = 273.15f;
    private float kelvin;

    /**
     * Raumtemperatur von 20°C
     */
    public Temperatur() {
        this(20.0f + KELVIN_OFFSET);
    }

    public Temperatur(float kelvin) {
        this.kelvin = kelvin;
    }

    public float getDegreeCelsius() {
        return Temperatur.kelvinToCelsius(this.kelvin);
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
    }

    public float getDegreeKelvin() {
        return this.kelvin;
    }

    public float getDegreeFahrenheit() {
        return (this.kelvin - Temperatur.KELVIN_OFFSET) * 1.8f + 32;
    }

    public void increaseTemperatur(float kelvin) {
        this.kelvin += kelvin;
    }

    public void decreaseTemperatur(float kelvin) {
        this.kelvin -= kelvin;
    }

    /**
     * Konvertiert eine Temperatur von °Celsius in °Kelvin
     *
     * @param celsius Wert der Temperatur die umgrechnet werden soll
     * @return Wert der Temperatur in Kelvin
     */
    public static float celsiusToKelvin(float celsius) {
        return celsius + Temperatur.KELVIN_OFFSET;
    }

    /**
     * Konvertiret eine Temperatur von °Kelvin in °Celsius
     *
     * @param kelvin Wert der Temperatur die umgrechnet werden soll
     * @return Wert der Temperatur in °Celsius
     */
    public static float kelvinToCelsius(float kelvin) {
        return kelvin - Temperatur.KELVIN_OFFSET;
    }

    /**
     * Vergleich der Temperatur
     *
     * @param other Temperatur die verglichen wird
     * @return "kleiner als ist -1, gleich ist 0, grösser als ist +1"
     */
    @Override
    public int compareTo(Temperatur other) {
        return Float.compare(this.kelvin, other.kelvin);
    }

    @Override
    public String toString() {
        return "Temperatur{" + "Kelvin=" + kelvin + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.kelvin);
    }

    @Override
    public boolean equals(Object obj) {
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
