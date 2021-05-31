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
public final class Quecksilber extends Element{

    public Quecksilber() {
        super("Quecksilber", new Temperatur(-30.83f), new Temperatur(356.7f));
    }
    
    public Quecksilber(Temperatur temp) {
        super("Quecksilber", temp,new Temperatur(-30.83f), new Temperatur(356.7f));
    }
    
    public Quecksilber(float temp) {
        super("Quecksilber", temp,(-30.83f), (356.7f));
    }
}
