/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;


/**
 * 
 * @author Dominic Ammann
 */
public final class Blei extends Element{

    public Blei() {
        super("Blei", new Temperatur(327.5f), new Temperatur(1749f));
    }
    
    public Blei(Temperatur temp) {
        super("Blei", temp, new Temperatur(327.5f), new Temperatur(1749f));
    }
    
    public Blei(float temp) {
        super("Blei", temp, (327.5f), (1749f));
    }
}
