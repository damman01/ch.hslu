/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw05.shape;

/**
 * Klasse Circle Berechnet die Dimensionen eines Kreises
 *
 *
 * @author Dominic Ammann
 */
public final class Circle extends Shape {

    private int diameter;

    public Circle(final int x, final int y, final int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public void setDiameter(final int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public int getPerimeter() {
        return this.diameter * (int) Math.PI;
    }

    public int getArea() {
        return ((int) Math.pow((this.diameter / 2), 2)) * (int) Math.PI;
    }

}
