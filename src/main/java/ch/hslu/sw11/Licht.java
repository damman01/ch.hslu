/**
 * Lichtklasse
 */
package ch.hslu.sw11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class Licht implements Switchable {
    
    private State state = State.OFF;

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
            this.state = State.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "state", State.OFF, State.ON);
            this.firePropertyChangeEvent(pcEvent);
        }
        
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
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOn() {
        return state == State.ON;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSwitchedOff() {
        return state == State.OFF;
    }

}
