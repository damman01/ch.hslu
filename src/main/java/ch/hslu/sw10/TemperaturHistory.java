package ch.hslu.sw10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TemperaturHistory implements Comparable<TemperaturHistory>{
    public List<Temperatur> verlauf = new ArrayList<>();

    public void clear() {
        this.verlauf.clear();
    }

    public Temperatur get(final int i) {
        return (this.verlauf.get(i));
    }

    public void addTemp(final Temperatur temp) {
        this.verlauf.add(temp);

    }

    public float maxTemp() {
        if (verlauf.size() > 0) {
            return Collections.max(verlauf).getDegreeKelvin();
        } else {
            return -1;
        }
    }

    public float minTemp() {
        if (verlauf.size() > 0) {
            return Collections.min(verlauf).getDegreeKelvin();
        } else {
            return -1;
        }
    }

    public int getCount() {
        return verlauf.size();
    }

    public float averageTemp() {
        if (verlauf.size() > 0) {
            final Iterator<Temperatur> iterator = verlauf.iterator();
            float sum = 0;
            while (iterator.hasNext()) {
                final Temperatur temp = iterator.next();
                sum += temp.getDegreeKelvin();
            }
            return sum / verlauf.size();
        } else {
            return -1;
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
        return "TemperaturHistory \n"+ verlauf + " \n\n MaxTemp=[" + this.maxTemp() + "]\n AverageTemp=[" + this.averageTemp() + "]\n MinTemp=[" + this.minTemp() + "]\n";
    }
    
    
}
