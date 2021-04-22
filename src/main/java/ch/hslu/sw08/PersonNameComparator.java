/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw08;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author domin
 */
public final class PersonNameComparator implements Comparator<Person> {
    
    @Override
    public int compare(Person p1, Person p2) {
        int nameCompare = p1.getNachname().compareTo(p2.getNachname());
        if (nameCompare == 0){
            nameCompare = p1.getVorname().compareTo(p2.getVorname());
        }
        return nameCompare;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof PersonNameComparator)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }
}
