/**
 * Motorenklasse 
 */
package ch.hslu.sw11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Motor implements Switchable {

    private int rpm = 0;
    private Status state = Status.OFF;
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
            this.state = Status.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "Status", Status.OFF, Status.ON);
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
            this.state = Status.OFF;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "Status", Status.ON, Status.OFF);
            this.firePropertyChangeEvent(pcEvent);
        }
        this.rpm = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOn() {
        return state == Status.ON && rpm > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOff() {
        return state == Status.OFF;
    }

    /**
     * Registriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
        this.changeListeners.add(listener);
        } else {
            throw new NullPointerException("PropertyChangeListener darf nicht null sein!");
        }
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
