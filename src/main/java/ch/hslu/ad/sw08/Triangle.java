package ch.hslu.ad.sw08;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class Triangle implements Comparable<Triangle> {

    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        if (p1 == null || p2 == null || p3 == null)
            throw new IllegalArgumentException("Triangle points can't be null");
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return Point.of(p1.getX(), p1.getY());
    }

    public Point getP2() {
        return Point.of(p2.getX(), p2.getY());
    }

    public Point getP3() {
        return Point.of(p3.getX(), p3.getY());
    }

    public Point[] getPoints() {
        return Stream.of(getP1(), getP2(), getP3()).sorted(Comparator.comparing(Point::getLength))
                .toArray(Point[]::new);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;

        return Objects.equals(p1, other.p1) && Objects.equals(p2, other.p2) && Objects.equals(p3, other.p3);
    }

    @Override
    public int compareTo(Triangle other) {
        // natural order: distance to points
        // warning: doesn't fully compare to equals method above
        Point[] thisPoints = this.getPoints();
        Point[] otherPoints = other.getPoints();
        int result = 0;
        for (int i = 0; i < thisPoints.length; i++) {
            result = Comparator.comparingDouble(Point::getLength).compare(thisPoints[i], otherPoints[i]);
            if (result != 0)
                return result;
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("Triangle [points=%s %s %s]", getPoints(), getPoints(), getPoints());
    }

}
