/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.oop.sw08;

import java.util.Objects;

/**
 *
 * @author Dominic Ammann
 */
public class Temperatur implements Comparable<Temperatur>{
    
  private float degreeCelsius;

  /**
   * Raumtemperatur von 20°C
   */
  public Temperatur() { 
    this(20.0f);
  }

  
  public Temperatur(float degreeCelsius) { 
    this.degreeCelsius = degreeCelsius;
  }

  public float getDegreeCelsius() { 
    return this.degreeCelsius;
  }

  public void setDegreeCelsius(float degreeCelsius) { 
    this.degreeCelsius = degreeCelsius;
  }

  public float getDegreeKelvin() { 
    return this.degreeCelsius + 273.15f;
  }

  public float getDegreeFahrenheit() { 
    return this.degreeCelsius * 1.8f + 32;
  }

  public void increaseTemperatur(float degreeCelsius) { 
    this.degreeCelsius += degreeCelsius;
  }

  public void decreaseTemperatur(float degreeCelsius) { 
    this.degreeCelsius -= degreeCelsius;
  }
  
  /**
     * Vergleichder Temperatur
     * @param other Temperatur die verglichen wird
     * @return "kleiner als ist -1, gleich ist 0, grösser als ist +1"
     */
    @Override
    public int compareTo(Temperatur other) {
        return Float.compare(this.degreeCelsius, other.degreeCelsius);
    }
    
    
    @Override
    public String toString() {
        return "Temperatur{" + "degreeCelsius=" + degreeCelsius + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.degreeCelsius);
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
            return Objects.equals(this.degreeCelsius, other.degreeCelsius);
        }
    }
