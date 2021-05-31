/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;

import java.util.Objects;

/**
 * 
 * @author Dominic Ammann
 */
public abstract class Element {

    public enum AggregateState {
        LIQUID("flüssig"), SOLID("fest"), GAS("gasförmig");

        private final String name;

        private AggregateState(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static final float KELVIN_OFFSET = 273.15f;
    protected String element;
    protected Temperatur temp;
    protected Temperatur pSchmelz;
    protected Temperatur pKondens;

    /**
     * Konstruktor für Element mit Übergabe von 3 float Werten
     * 
     * @param element     Name des Elements
     * @param tempvar     Aktuelle Temperatur
     * @param pSchmelzvar Schmelzpunkt
     * @param pKondensvar Kondensationspunkt
     */
    public Element(String element, float tempvar, float pSchmelzvar, float pKondensvar) {

        this.element = element;
        this.temp = new Temperatur(tempvar + KELVIN_OFFSET);
        this.pSchmelz = new Temperatur(pSchmelzvar + KELVIN_OFFSET);
        this.pKondens = new Temperatur(pKondensvar + KELVIN_OFFSET);
    }

    /**
     * Ausgabe des Aggregatszustandes
     * 
     * @return Agregatszustand des Elements bei der Temperatur temp
     */
    public AggregateState getAggregation() {
        if (temp.getDegreeKelvin() < pSchmelz.getDegreeKelvin()) {
            return AggregateState.SOLID;
        } else if (temp.getDegreeKelvin() < pKondens.getDegreeKelvin()) {
            return AggregateState.LIQUID;
        } else {
            return AggregateState.GAS;
        }
    }

    public Temperatur getTemp() {
        return temp;
    }

    public Temperatur getpSchmelz() {
        return pSchmelz;
    }

    public Temperatur getpKondens() {
        return pKondens;
    }

    public float getDegreeCelsius() {
        return temp.getDegreeCelsius();
    }

    public String getElement() {
        return this.element;
    }

    @Override
    public String toString() {
        return "Element{Name=" + this.element + " temp=" + temp + ", pSchmelz=" + pSchmelz + ", pKondens=" + pKondens
                + ", Aggregatestate=" + this.getAggregation().getName() + '}';
    }

    /**
     * Berechnung des HashCodes wird aus den 3 Objekten temp, pSchmelz und pKondesn
     * berechnet
     * 
     * @return hashCode
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.element, this.temp, this.pSchmelz, this.pKondens);
    }

    /**
     * Equals Methode
     * 
     * @return > = pos, = = 0, < = neg
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Element)) {
            return false;
        }
        final Element other = (Element) obj;
        return Objects.equals(this.element, other.element) && Objects.equals(this.temp, other.temp)
                && Objects.equals(this.pKondens, other.pKondens) && Objects.equals(this.pSchmelz, other.pSchmelz);
    }
}
