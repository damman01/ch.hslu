package ch.hslu.sw12;

import ch.hslu.sw11.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

import org.apache.logging.log4j.*;

public final class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);
    static String filelocation = ".\\src\\main\\java\\ch\\hslu\\sw12\\Testfile.txt";
    static String temperaturFile = ".\\src\\main\\java\\ch\\hslu\\sw12\\Temperaturfile.txt";

    public static void main(String[] args) throws IOException {

        writeTextFile(filelocation);

        final FileInputStream fis = new FileInputStream(filelocation);
        final DataInputStream dis = new DataInputStream(fis);
        final Double value = dis.readDouble();
        final Byte byteValue = dis.readByte();
        dis.close();

        LOG.trace("Double from File: {}", value);
        LOG.trace("Byte from File:   {}", byteValue);
        

        readTextFile(filelocation);

        String input;
        Scanner scanner = new Scanner(System.in);
        TemperaturHistory verlauf = new TemperaturHistory();
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if (!input.equals("exit")) {
                try {
                    float tempValue = Float.valueOf(input);
                    verlauf.addTemp(Temperatur.createFromKelvin(tempValue));
                    LOG.trace("Temperatur= " + input);
                } catch (IllegalArgumentException ex) {
                    LOG.trace("Keine Zahl eingegeben");
                } finally {
                }
            }
        } while (!input.equals("exit"));

        try (PrintWriter pwTemp = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temperaturFile), Charset.forName("UTF-8"))));) {
            pwTemp.println(verlauf);
        }
        scanner.close();

    }

    public static void writeTextFile(final String file) {
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8"))));) {
            pw.write("1, ");
            pw.println(200.002);
            pw.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
        LOG.trace("file {} created", file);
    }

    public static void readTextFile(final String file) {
        if (new File(file).exists()) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                LOG.trace("Reading from {}", file);
                while ((line = br.readLine()) != null) {
                    LOG.trace(line);
                }
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        } 
    }

}
