package ch.hslu.ad.sw08;

import java.util.Comparator;
import java.util.Objects;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(final int x, final int y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public String toString() {
        return String.format("Point [x=%s, y=%s, length=%3.2f]", x, y, getLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;

        return x == other.x && y == other.y;
    }

    @Override
    public int compareTo(Point other) {
        return Comparator.comparingInt(Point::getX).thenComparingInt(Point::getY).compare(this, other);
    }

}
