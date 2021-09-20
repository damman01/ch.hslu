package ch.hslu.sw11;

import java.beans.PropertyChangeEvent;


public class TemperaturChangeEvent extends PropertyChangeEvent{
    private static final long serialVersionUID = 10000L;
    private NewValueType type;

    public TemperaturChangeEvent(Object source, String propertyName, Object oldValue, Object newValue, NewValueType type) {
        super(source, propertyName, oldValue, newValue);
        this.type = type;
    }
    
    public NewValueType getType() {
        return type;
    }
}
