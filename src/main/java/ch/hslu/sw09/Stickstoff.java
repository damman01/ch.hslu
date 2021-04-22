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
public final class Stickstoff extends Element{

    public Stickstoff() {
        super(new Temperatur(-210f), new Temperatur(-195.8f));  
    }
    
    public Stickstoff(Temperatur temp) {
        super(temp,new Temperatur(-210f), new Temperatur(-195.8f));  
    }
    
    public Stickstoff(float temp) {
        super(temp,(-210f), (-195.8f));  
    }
}
