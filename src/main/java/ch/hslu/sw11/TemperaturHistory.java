package ch.hslu.sw11;

import org.apache.logging.log4j.*;

import java.util.*;

public class TemperaturHistory implements Comparable<TemperaturHistory> {
    public List<Temperatur> verlauf = new ArrayList<>();
    private static Logger LOG = LogManager.getLogger(TemperaturHistory.class);
    private final List<TemperaturChangeListener> changeListeners = new ArrayList<TemperaturChangeListener>();

    public void clear() {
        this.verlauf.clear();
    }

    public Temperatur get(final int i) {
        return (this.verlauf.get(i));
    }

    public void addTemp(final Temperatur temp) {
        if (verlauf.size() > 0) {
            if (temp.getDegreeKelvin() > this.maxTemp().getDegreeKelvin()) {
                final TemperaturNewEvent tcEvent = new TemperaturNewEvent(this, NewValueType.MAXTEMP, this.maxTemp(), temp);
                this.fireTemperaturChangeEvent(tcEvent);
                LOG.debug("New" + tcEvent.getNewValueType());
            } else if (temp.getDegreeKelvin() < this.minTemp().getDegreeKelvin()) {
                final TemperaturNewEvent tcEvent = new TemperaturNewEvent(this, NewValueType.MINTEMP, this.minTemp(), temp);
                this.fireTemperaturChangeEvent(tcEvent);
                LOG.debug("New" + tcEvent.getNewValueType());
            }
        }
        else {
            final TemperaturNewEvent tcEvent = new TemperaturNewEvent(this, NewValueType.MAXTEMP, this.maxTemp(), temp);
            this.fireTemperaturChangeEvent(tcEvent);
            final TemperaturNewEvent tcEventMin = new TemperaturNewEvent(this, NewValueType.MINTEMP, this.minTemp(), temp);
            this.fireTemperaturChangeEvent(tcEventMin);
        }

        this.verlauf.add(temp);

    }

    public Temperatur maxTemp() {
        if (verlauf.size() > 0) {
            return Collections.max(verlauf);
        } else {
            return null;
        }
    }

    public Temperatur minTemp() {
        if (verlauf.size() > 0) {
            return Collections.min(verlauf);
        } else {
            return null;
        }
    }

    public int getCount() {
        return verlauf.size();
    }

    public Temperatur averageTemp() {
        if (verlauf.size() > 0) {
            final Iterator<Temperatur> iterator = verlauf.iterator();
            float sum = 0;
            while (iterator.hasNext()) {
                final Temperatur temp = iterator.next();
                sum += temp.getDegreeKelvin();
            }
            sum /= verlauf.size();
            Temperatur averageTemp =  Temperatur.createFromKelvin(sum);
            return averageTemp;
            
        } else {
            return null;
        }
    }

    @Override
    public int compareTo(final TemperaturHistory other) {
        return Integer.compare(this.verlauf.size(), other.verlauf.size());
    }

    public Iterator<Temperatur> iterator() {
        return verlauf.iterator();
    }

    @Override
    public String toString() {
        return "TemperaturHistory \n" + verlauf + "\n\n Anzahl Punkte=[" + this.getCount() + "]\n MaxTemp=["
                + this.maxTemp().getDegreeKelvin() + "]\n AverageTemp=[" + this.averageTemp().getDegreeKelvin() + "]\n MinTemp=[" + this.minTemp().getDegreeKelvin() + "]\n";
    }

    /**
     * Registriert einen TemperaturChangeListener.
     *
     * @param listener TemperaturChangeListener.
     */
    public void addTemperaturhangeListener(final TemperaturChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        } else {
            throw new NullPointerException("TemperaturChangeListener darf nicht null sein!");
        }
    }

    /**
     * Deregistriert einen TemperaturChangeListener.
     *
     * @param listener TemperaturChangeListener.
     */
    public void removeTemperaturChangeListener(final TemperaturChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    /**
     * Informiert alle TemperaturChangeListener über TemperaturNewEvent
     * 
     * @param tcEvent TemperaturNewEvent
     */
    private void fireTemperaturChangeEvent(final TemperaturNewEvent tcEvent) {
        for (final TemperaturChangeListener listener : this.changeListeners) {
            listener.TemperaturChange(tcEvent);
        }
    }

}
