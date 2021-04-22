/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;

import ch.hslu.sw08.*;
import java.util.Objects;

/**
 * 
 * @author Dominic Ammann
 */
public class Element {
    
    private final Temperatur temp;
    private final Temperatur pSchmelz;
    private final Temperatur pKondens;
    
    
    /**
     * Konstruktor für Element mit Übergabe von 3 float Werten
     * @param tempvar Aktuelle Temperatur
     * @param pSchmelzvar Schmelzpunkt 
     * @param pKondensvar Kondensationspunkt 
     */
    public Element(float tempvar, float pSchmelzvar, float pKondensvar){
        
        this.temp = new Temperatur (tempvar);
        this.pSchmelz = new Temperatur (pSchmelzvar);
        this.pKondens = new Temperatur (pKondensvar);   
    }
    
    /**
     * Konstruktor für Element mit Übergabe von 3 Temperaturen
     * @param temp Aktuelle Temperatur
     * @param pSchmelz Schmelzpunkt
     * @param pKondens Kondensationspunkt
     */
    public Element(Temperatur temp, Temperatur pSchmelz, Temperatur pKondens){
        
        this.temp = temp;
        this.pSchmelz = pSchmelz;
        this.pKondens = pKondens;   
    }
    /**
     * Konstruktor für Element bei Raumtemperatur mit Übergabe von 3 Temperaturen
     * @param temp Aktuelle Temperatur
     * @param pSchmelz Schmelzpunkt
     * @param pKondens Kondensationspunkt
     */
    public Element(Temperatur pSchmelz, Temperatur pKondens){
        
        this.temp = new Temperatur();
        this.pSchmelz = pSchmelz;
        this.pKondens = pKondens;
    }

    /**Ausgabe des Aggregatszustandes
     * @param temp aktuelle Temperatur
     * @return Agregatszustand des Elements bei der Temperatur temp
     */
    public String getAggregation(){
        String aggregation;
        
        if (temp.getDegreeKelvin() < pSchmelz.getDegreeKelvin()) {
            aggregation = "fest";
        }
        else if (temp.equals(pSchmelz)){
            aggregation = "Am Schmelzpunkt";
        }
        else if (temp.getDegreeKelvin() < pKondens.getDegreeKelvin()) {
            aggregation = "flüssig";
        }
        else if (temp.equals(pKondens)){
            aggregation = "Am Kondensationspunkt";
        }
        else {
            aggregation = "gasförmig";
        }

        return aggregation;
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
    
    @Override
    public String toString() {
        return "Element{" + "temp=" + temp + ", pSchmelz=" + pSchmelz + ", pKondens=" + pKondens + '}';
    }

    /**
     * Berechnung des HashCodes 
     * wird aus den 3 Objekten temp, pSchmelz und pKondesn berechnet
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.temp, this.pSchmelz, this.pKondens);
    }

    /**
     * Equals Methode 
     * @param zweites Temperatur Objekt
     * @return > = pos, = = 0, < = neg
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Element)) {
            return false;
        }
        final Element other = (Element) obj;
            return Objects.equals(this.temp, other.temp) && Objects.equals(this.pKondens, other.pKondens) && Objects.equals(this.pSchmelz, other.pSchmelz);
        }
}
