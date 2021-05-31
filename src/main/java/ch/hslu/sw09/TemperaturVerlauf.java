/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dominic Ammann at HSLU
 */
public class TemperaturVerlauf implements Comparable<TemperaturVerlauf> {

    public List<Temperatur> verlauf = new ArrayList<>();
    public Temperatur maxTemp;

    public void clear() {
        this.verlauf.clear();
    }

    public Temperatur get(int i) {
        return (this.verlauf.get(i));
    }

    public void addTemp(final Temperatur temp) {
        this.verlauf.add(temp);

    }

    public float maxTemp()
    {
        if(verlauf.size() > 0) {
            return Collections.max(verlauf).getDegreeKelvin();
        }
        else {
            return -1;
        }
    }

    public int getCount() {
        return verlauf.size();
    }

    @Override
    public int compareTo(TemperaturVerlauf other) {
        return Integer.compare(this.verlauf.size(), other.verlauf.size());

    }

}
