package ch.hslu.oop.sw09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TemperaturHistory implements Comparable<TemperaturHistory>{
    List<Temperatur> verlauf = new ArrayList<>();

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
        if (!verlauf.isEmpty()) {
            return Collections.max(verlauf).getDegreeKelvin();
        } else {
            return -1;
        }
    }

    public float minTemp() {
        if (!verlauf.isEmpty()) {
            return Collections.min(verlauf).getDegreeKelvin();
        } else {
            return -1;
        }
    }

    public int getCount() {
        return verlauf.size();
    }

    public float averageTemp() {
        if (!verlauf.isEmpty()) {
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
    public int compareTo(TemperaturHistory oHistory){
            return Integer.compare(this.verlauf.size(), oHistory.verlauf.size());
    }

    public Iterator<Temperatur> iterator() {
        return verlauf.iterator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(verlauf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemperaturHistory)) {
            return false;
        }
        TemperaturHistory other = (TemperaturHistory) obj;
        return Objects.equals(verlauf, other.verlauf);
    }
    
}
