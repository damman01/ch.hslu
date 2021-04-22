/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw08;

/**
 *
 * @author domin
 */
public final class Blei extends Element{

    public Blei() {
        super(new Temperatur(327.5f), new Temperatur(1749f));
    }
    
    public Blei(Temperatur temp) {
        super(temp, new Temperatur(327.5f), new Temperatur(1749f));
    }
    
    public Blei(float temp) {
        super(temp, (327.5f), (1749f));
    }
}
