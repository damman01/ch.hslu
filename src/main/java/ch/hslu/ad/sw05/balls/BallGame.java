package ch.hslu.ad.sw05.balls;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.event.MouseInputAdapter;

import org.apache.logging.log4j.*;

import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;


public class BallGame {

    private static final String[] COLOR_CODES = { "red", "black", "blue", "yellow", "green", "magenta" };
    private static Logger log = LogManager.getLogger(BallGame.class);
    

    private static final int MIN_DIAMETER = 20;
    private static final int MAX_DIAMETER = 50;

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        MouseInputAdapter mouseEventListener = new MouseInputAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    createFallingBall(me);
                } else if (me.getButton() == MouseEvent.BUTTON3) {
                    try {
                        log.info("attempt to shutdown executor");
                        executor.shutdown();
                        executor.awaitTermination(10, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        log.info("tasks interrupted");
                    } finally {
                        if (!executor.isTerminated()) {
                            log.info("cancel non-finished tasks");
                        }
                        executor.shutdownNow();
                        log.info("shutdown finished");
                        System.exit(0);
                    }
                }
            }
        };

        Canvas.getCanvas(mouseEventListener);
        
    }

    private static void createFallingBall(MouseEvent mouseEvent) {
        Canvas canvas = Canvas.getCanvas();
        int diameter = getRandomNumber(MIN_DIAMETER, MAX_DIAMETER);
        int xPosition = mouseEvent.getX() - diameter / 2;
        int yPosition = mouseEvent.getY() - diameter / 2;
        String color = COLOR_CODES[getRandomNumber(0, COLOR_CODES.length)];

        Circle c = new Circle(diameter, xPosition, yPosition, color);
        c.makeVisible();
        log.info("Created Ball: {}", c);

        Runnable task = () -> {
            final int steps = getRandomNumber(20, 40);

            // falling
            while (c.getY() + c.getDiameter() < canvas.getHeight() && !Thread.currentThread().isInterrupted()) {
                int distanceToBottom = canvas.getHeight() - (c.getY() + c.getDiameter());
                try {
                    TimeUnit.SECONDS.sleep(1);
                    c.moveVertical(steps < distanceToBottom ? steps : distanceToBottom);
                } catch (InterruptedException e) {
                    log.error("ball movement interrupted", e);
                    Thread.currentThread().interrupt();
                }
            }

            // shrink
            while (c.getDiameter() > 5 && !Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    c.changeSize(c.getDiameter() - 1);
                    c.moveVertical(1);
                } catch (InterruptedException e) {
                    log.error("ball movement interrupted", e);
                    Thread.currentThread().interrupt();
                }
            }

            c.makeInvisible();
            log.info("erased");
        };
        executor.submit(task);
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
