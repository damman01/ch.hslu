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
public final class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(final int x, final int y, final int width, final int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void changeDimension(final int newWidth, final int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public int getWidht() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public int getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    @Override
    public int getArea() {
        return this.width * this.height;
    }

}
