/*
 * Copyright (C) 2021 Hochschule Luzern - Informatik.
 *
 * This library is free software;
 */
package ch.hslu.sw08;

import java.util.Objects;

/**
 *
 * @author dominic
 */
public final class Person implements Comparable<Person>{
    
    private String nachname;
    private String vorname;
    private long pID ;
    
    
    public Person(final String nachname, final String vorname, final long pID) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.pID = pID;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public long getpID() {
        return pID;
    }

    public void setpID(long pID) {
        this.pID = pID;
    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(this.nachname, this.vorname, this.pID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Person)) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.nachname, other.nachname) && Objects.equals(this.vorname, other.vorname) && Objects.equals(this.pID, other.pID);
    }
    
    /**
     * Vergleich auf Basis der ID
     * @param other Person die verglichen wird
     * @return "kleiner als ist -1, gleich ist 0, grösser als ist +1"
     */
    @Override
    public int compareTo(Person other) {
        return Long.compare(this.pID, other.pID);
    }
    
    
    @Override 
    public String toString () {
        return "Person (Name=" + this.nachname + " ;Vorname=" + this.vorname + " ;ID=" + this.pID + "; hash=" + this.hashCode() + ")";
    }
    
    
    
    
}
