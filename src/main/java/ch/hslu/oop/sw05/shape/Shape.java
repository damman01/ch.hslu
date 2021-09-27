/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.oop.sw05.shape;

/**
 * Definiert eine abstrakte Form mit einer (x,y)-Position. Verlangt Methoden zur
 * Berechnung von Umfang und Fläche.
 *
 * @author Dominic Ammann
 */
public abstract class Shape {

    private int x;
    private int y;

    protected Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public final void move(final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public abstract int getPerimeter();

    public abstract int getArea();

}
