package ch.hslu.ad.sw08;

import java.util.Arrays;
import java.util.Random;

public class TriangleEditor {

    private static final int TRIANGLE_COUNT = 10;
    private static final int MAX_COORDINATE = 50;
    private static final int MIN_COORDINATE = MAX_COORDINATE * -1;

    private static final Random random = new Random();

    public static void main(String[] args) {
        Triangle[] triangles = new Triangle[TRIANGLE_COUNT];
        for (int i = 0; i < TRIANGLE_COUNT; i++) {
            triangles[i] = new Triangle(getRandomPoint(), getRandomPoint(), getRandomPoint());
        }

        Arrays.sort(triangles);
        Arrays.stream(triangles).forEach(System.out::println);

    }

    private static Point getRandomPoint() {
        return Point.of(getRandomBoundedInt(), getRandomBoundedInt());
    }

    private static int getRandomBoundedInt() {
        return random.nextInt(MAX_COORDINATE - MIN_COORDINATE) + MIN_COORDINATE;
    }
}
