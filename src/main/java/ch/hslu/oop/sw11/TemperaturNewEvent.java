package ch.hslu.oop.sw11;

import java.util.EventObject;

public class TemperaturNewEvent extends EventObject{
    private static final long serialVersionUID = 10001L;
    
    private NewValueType type;
    private Temperatur oldValue, newValue;

    public TemperaturNewEvent(Object source, NewValueType type, Temperatur oldValue, Temperatur newValue) {
        super(source);
        this.type = type;
        this.oldValue = oldValue;
        this.newValue = newValue;

    }

    public NewValueType getNewValueType(){
    return type;
    }

    /**
     * Gets the new value for the property, expressed as an Object.
     *
     * @return  The new value for the property, expressed as an Object.
     *          May be null if multiple properties have changed.
     */
    public Temperatur getNewValue() {
        return newValue;
    }

    /**
     * Gets the old value for the property, expressed as an Object.
     *
     * @return  The old value for the property, expressed as an Object.
     *          May be null if multiple properties have changed.
     */
    public Temperatur getOldValue() {
        return oldValue;
    }

    @Override
    public String toString() {
        return "TemperaturNewEvent [newValue=" + newValue + ", oldValue=" + oldValue + ", type=" + type + "]";
    }

    
    
}
