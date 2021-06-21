/**
 * Dieses Interface implementiert einen Schalter
 * 
 * @autor Dominic Ammann
 */
package ch.hslu.sw11;

public interface Switchable {

    /**
     * Stellt den Schalter auf ON
     */
    void switchon();

    /**
     * Stellt den Schalter auf OFF
     */
    void switchoff();

    /**
     * Prüft ob der Schalter auf ON ist
     * 
     * @return TRUE wenn Schalter = ON
     */
    boolean isSwitchedOn();

    /**
     * Prüft ob der Schalter auf OFF ist
     * 
     * @return TRUE wenn Schalter = OFF
     */
    boolean isSwitchedOff();
}