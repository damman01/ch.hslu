package ch.hslu.oop.sw12;

import ch.hslu.oop.sw11.*;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import org.apache.logging.log4j.*;

public final class Main {

    private static Logger lLOG = LogManager.getLogger(Main.class);
    static String filelocation = ".\\ch.hslu\\src\\main\\java\\ch\\hslu\\oop\\sw12\\Testfile.dat";
    static String temperaturFile = ".\\ch.hslu\\src\\main\\java\\ch\\hslu\\oop\\sw12\\Temperaturfile.dat";

    public static void main(String[] args) throws IOException {

        writeTextFile(filelocation);

        final FileInputStream fis = new FileInputStream(filelocation);
        try (final DataInputStream dis = new DataInputStream(fis)) {
            final Double value = dis.readDouble();
            final Byte byteValue = dis.readByte();
            lLOG.trace("Double from File: {}", value);
            lLOG.trace("Byte from File:   {}", byteValue);

        } catch (IOException e) {
            lLOG.debug("File ist fehlerhaft!");
        }
        
        readTextFile(filelocation);

        String input;
        Scanner scanner = new Scanner(System.in);
        TemperaturHistory verlauf = new TemperaturHistory();
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if (!input.equals("exit")) {
                try {
                    float tempValue = Float.parseFloat(input);
                    verlauf.addTemp(Temperatur.createFromKelvin(tempValue));
                    lLOG.trace("Temperatur= {}" ,input);
                } catch (IllegalArgumentException ex) {
                    lLOG.trace("Keine Zahl eingegeben");
                }
                
            }
        } while (!input.equals("exit"));

        try (PrintWriter pwTemp = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temperaturFile), StandardCharsets.UTF_8)));) {
            pwTemp.println(verlauf);
        }
        scanner.close();

    }

    public static void writeTextFile(final String file) {
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)));) {
            pw.print(121354);
            pw.print(121354.678d);
            pw.flush();
        } catch (IOException ioe) {
            lLOG.error(ioe.getMessage(), ioe);
        }
        lLOG.trace("file {} created", file);
    }

    public static void readTextFile(final String file) {
        if (new File(file).exists()) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                String line;
                lLOG.trace("Reading from {}", file);
                while ((line = br.readLine()) != null) {
                    lLOG.trace(line);
                }
            } catch (IOException ioe) {
                lLOG.error(ioe.getMessage(), ioe);
            }
        } 
    }

}
