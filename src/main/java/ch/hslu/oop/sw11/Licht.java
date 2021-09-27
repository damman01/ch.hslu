/**
 * Lichtklasse
 */
package ch.hslu.oop.sw11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Licht implements Switchable {
    
    private Status state = Status.OFF;

    private final List<PropertyChangeListener> changeListeners = new ArrayList<PropertyChangeListener>();

    /**
     * Registriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(
            final PropertyChangeListener listener) {
        this.changeListeners.add(listener);
    }
    
    /**
     * Deregistriert einen PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removePropertyChangeListener(
            final PropertyChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    /**
     * Informiert alle PropertyChangeListener über PropertyChangeEvent
     * @param pcEvent PropertyChangeEvent
     */
    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchon() {
        if (isSwitchedOff()) {
            this.state = Status.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "state", Status.OFF, Status.ON);
            this.firePropertyChangeEvent(pcEvent);
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchoff() {
        if (isSwitchedOn()) {
            this.state = Status.OFF;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "state", Status.ON, Status.OFF);
            this.firePropertyChangeEvent(pcEvent);
        }
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOn() {
        return state == Status.ON;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOff() {
        return state == Status.OFF;
    }

}
