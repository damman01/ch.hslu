package ch.hslu.oop.sw10;

import java.util.Scanner;

import org.apache.logging.log4j.*;

public class App {

    private static Logger LOG = LogManager.getLogger(App.class);

    public App() {
    }

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        TemperaturHistory verlauf = new TemperaturHistory();
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if (!input.equals("exit")) {
                try {
                    float value = Float.valueOf(input);
                    verlauf.addTemp(Temperatur.createFromKelvin(value));
                    LOG.trace("Temperatur= " + input);
                } catch (IllegalArgumentException ex) {
                    LOG.trace("Keine Zahl eingegeben");
                } finally {
                }
            }
        } while (!input.equals("exit"));

        System.out.println(verlauf);

        System.out.println("Programm beendet.");
        scanner.close();
    }
}
