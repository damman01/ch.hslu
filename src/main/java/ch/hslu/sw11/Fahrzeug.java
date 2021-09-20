/**
 * Stellt ein Fahrzeug dar mit
 * - Motor
 * - Volllicht
 * - Abblendlicht
 *
 * @author Dominic Ammann
 */
package ch.hslu.sw11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Fahrzeug implements Switchable{

    public String model;
    public Status state;
    private Motor motor;
    private Licht lichtVoll;
    private Licht lichtAbblend;

    public Fahrzeug(final String model) {
        this.state = Status.OFF;
        // Komponenten erzeugen
        this.motor = new Motor();
        this.lichtVoll = new Licht();
        this.lichtAbblend = new Licht();
        this.model = model;

        // Als Listener registrieren
        this.motor.addPropertyChangeListener(new PropertyChangeListener(){
            
            @Override
            public void propertyChange(final PropertyChangeEvent event) {
                handleMotorEvent("Motor", event);
            }
        });


        this.lichtVoll.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                handleLichtEvent("Volllicht", event);
            }
            
        });


        this.lichtAbblend.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                handleLichtEvent("Abblendlicht", event);
            }
            
        });
    }

    
    /** 
     * @param eventVomMotor Vom Motor geworfener Event
     * @param event Event
     */
    private void handleMotorEvent(String eventVomMotor, PropertyChangeEvent event) {
        System.out.println("Motor [" + eventVomMotor + "] [" + event.getNewValue() + "] ");
    }

    
    /** 
     * @param eventVomLicht Vom Licht geworfener Event
     * @param event Event
     */
    private void handleLichtEvent(String eventVomLicht, PropertyChangeEvent event) {
        System.out.println("Licht [" + eventVomLicht + "] [" + event.getNewValue() + "[ ");
    }


    @Override
    public void switchon() {
        this.state = Status.ON;
        this.motor.switchon();
        this.lichtAbblend.switchon();       
    }


    @Override
    public void switchoff() {
        this.state = Status.OFF;
        this.motor.switchoff();
        this.lichtAbblend.switchoff();        
    }


    @Override
    public boolean isSwitchedOn() {
        return this.state.compareTo(Status.ON) == 0;
    }


    @Override
    public boolean isSwitchedOff() {
        return this.state.compareTo(Status.OFF) == 0;
    }

    /**
     * Schaltet den Motor aus
     */
    public void switchOffMotor(){
        this.motor.switchoff();
    }

}
