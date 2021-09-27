package ch.hslu.oop.sw11;

import java.beans.PropertyChangeEvent;

@FunctionalInterface
public interface MotorStatusListener {
    public void listen(String motor, PropertyChangeEvent event);
    
}
