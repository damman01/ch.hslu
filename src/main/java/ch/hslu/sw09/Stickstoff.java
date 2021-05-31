/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;

/**
 *
 * @author domin
 */
public final class Stickstoff extends Element{

    public Stickstoff() {
        super("Stickstoff", new Temperatur(-210f), new Temperatur(-195.8f));  
    }
    
    public Stickstoff(Temperatur temp) {
        super("Stickstoff", temp,new Temperatur(-210f), new Temperatur(-195.8f));  
    }
    
    public Stickstoff(float temp) {
        super("Stickstoff", temp,(-210f), (-195.8f));  
    }
}
