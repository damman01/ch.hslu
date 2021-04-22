/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw05.shape;

/**
 * Klasse Rectangle Berechnet die Dimensionen eines Rechtecks
 *
 *
 * @author Dominic Ammann
 */
public final class Square extends Shape {

    private int side;

    public Square(final int x, final int y, final int side) {
        super(x, y);
        this.side = side;
    }

    public void changeDimension(final int newSide) {
        this.side = newSide;
    }

    public int getSide() {
        return this.side;
    }

    @Override
    public int getPerimeter() {
        return (4 * this.side);
    }

    @Override
    public int getArea() {
        return this.side * this.side;
    }

}
