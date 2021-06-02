package ch.hslu.sw10;

import java.util.Iterator;
import java.util.Scanner;

import org.apache.logging.log4j.*;

import ch.hslu.sw09.*;

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
            try {
                float value = Float.valueOf(input);
                verlauf.addTemp(new Temperatur(value));
                LOG.trace("Temperatur= " + input);
            } catch (NumberFormatException ex) {
                LOG.trace("Falsche Eingabe");
            }
            finally{
            }
        } while (!input.equals("exit"));

        final Iterator<Temperatur> iterator = verlauf.iterator();
            while (iterator.hasNext()) {
                final Temperatur temp = iterator.next();
                System.out.println(temp);
            }

        System.out.println("Programm beendet.");
        scanner.close();
    }
}
