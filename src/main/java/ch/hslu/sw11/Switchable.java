package ch.hslu.sw11;

public interface Switchable {
    /**
     * Stellt den Schalter auf ON
     */
    public void switchon();

    /**
     * Stellt den Schalter auf OFF
     */
    public void switchoff();

    /**
     * Prüft ob der Schalter auf ON ist
     * 
     * @return TRUE wenn Schalter = ON
     */
    public boolean isSwitchedOn();

    /**
     * Prüft ob der Schalter auf OFF ist
     * 
     * @return TRUE wenn Schalter = OFF
     */
    public boolean isSwitchedOff();
}
