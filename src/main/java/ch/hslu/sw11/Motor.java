/**
 * Motorenklasse 
 */
package ch.hslu.sw11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Motor implements Switchable {

    private int rpm = 0;
    private State state = State.OFF;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<PropertyChangeListener>();

    /**
     * @param acceleration Beschleunigung in RPM
     * @return aktuelle Umdrehungsgeschw. des Motors
     */
    public int accelerate(int acceleration) {
        this.rpm += acceleration;
        return this.rpm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchon() {
        if (isSwitchedOff()) {
            this.state = State.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "state", State.OFF, State.ON);
            this.firePropertyChangeEvent(pcEvent);
        }
        this.rpm = 1000;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchoff() {
        if (isSwitchedOn()) {
            this.state = State.OFF;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "state", State.ON, State.OFF);
            this.firePropertyChangeEvent(pcEvent);
        }
        this.rpm = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOn() {
        return state == State.ON && rpm > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOff() {
        return state == State.OFF;
    }

    /**
     * Registriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        this.changeListeners.add(listener);
    }

    /**
     * Deregistriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    /**
     * Informiert alle PropertyChangeListener über PropertyChangeEvent
     * 
     * @param pcEvent PropertyChangeEvent
     */
    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }
}
