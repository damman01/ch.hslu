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
    public State state;
    private Motor motor;
    private Licht lichtVoll;
    private Licht lichtAbblend;

    public Fahrzeug(final String model) {
        this.state = State.OFF;
        // Komponenten erzeugen
        this.motor = new Motor();
        this.lichtVoll = new Licht();
        this.lichtAbblend = new Licht();

        // Als Listener registrieren
        this.motor.addPropertyChangeListener(new PropertyChangeListener(){
            
            @Override
            public void propertyChange(final PropertyChangeEvent event) {
                handleMotorEvent("eventVomMotor", event);
            }
        });


        this.lichtVoll.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                handleLightEvent("eventVolllicht", event);
            }
            
        });


        this.lichtAbblend.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                handleLightEvent("eventAbblendlicht", event);
            }
            
        });
    }

    
    /** 
     * @param eventVomMotor Vom Motor geworfener Event
     * @param event Event
     */
    private void handleMotorEvent(String eventVomMotor, PropertyChangeEvent event) {
        System.out.println("MotorTest");
    }

    
    /** 
     * @param eventVomLicht Vom Licht geworfener Event
     * @param event Event
     */
    private void handleLightEvent(String eventVomLicht, PropertyChangeEvent event) {
        System.out.println("LichtTest");
    }


    @Override
    public void switchon() {
        this.state = State.ON;
        this.motor.switchon();
        this.lichtAbblend.switchon();       
    }


    @Override
    public void switchoff() {
        this.state = State.OFF;
        this.motor.switchoff();
        this.lichtAbblend.switchoff();        
    }


    @Override
    public boolean isSwitchedOn() {
        return this.state.compareTo(State.ON) == 0;
    }


    @Override
    public boolean isSwitchedOff() {
        return this.state.compareTo(State.OFF) == 0;
    }

    /**
     * Schaltet den Motor aus
     */
    public void switchOffMotor(){
        this.motor.switchoff();
    }

}
