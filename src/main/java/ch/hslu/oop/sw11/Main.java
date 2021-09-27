package ch.hslu.oop.sw11;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Fahrzeug seat = new Fahrzeug("Seat Ibiza");

        seat.switchon();
        seat.switchOffMotor();
        seat.switchon();
        seat.switchoff();
        seat.switchon();

    }
        
    
    
}
