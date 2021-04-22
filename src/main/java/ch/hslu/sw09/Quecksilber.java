/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;

import ch.hslu.sw08.*;

/**
 *
 * @author domin
 */
public final class Quecksilber extends Element{

    public Quecksilber() {
        super(new Temperatur(-30.83f), new Temperatur(356.7f));
    }
    
    public Quecksilber(Temperatur temp) {
        super(temp,new Temperatur(-30.83f), new Temperatur(356.7f));
    }
    
    public Quecksilber(float temp) {
        super(temp,(-30.83f), (356.7f));
    }
}
