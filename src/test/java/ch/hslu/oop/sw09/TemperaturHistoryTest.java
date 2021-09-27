package ch.hslu.oop.sw09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TemperaturHistoryTest {
    @Test
    void testAddTemp() {
        TemperaturHistory tempVerlauf = new TemperaturHistory();
        tempVerlauf.addTemp(new Temperatur(10.0f));
        tempVerlauf.addTemp(new Temperatur(20.0f));

        assertEquals(20.0f, (tempVerlauf.get(1)).getDegreeKelvin());
    }

    @Test
    void testAverageTemp() {
        TemperaturHistory verlauf = new TemperaturHistory();
        verlauf.addTemp(new Temperatur(10.0f));
        verlauf.addTemp(new Temperatur(20.0f));
        verlauf.addTemp(new Temperatur(30.0f));
        verlauf.addTemp(new Temperatur(0.0f));
        verlauf.addTemp(new Temperatur(40.0f));

        assertThat(verlauf.averageTemp()).isEqualTo(20.0f);

    }

    @Test
    void testClear() {
        TemperaturHistory tempVerlauf = new TemperaturHistory();
        tempVerlauf.addTemp(new Temperatur());
        tempVerlauf.clear();
        assertThat(tempVerlauf.getCount()).isZero();
    }

    @Test
    void testCompareTo() {
        TemperaturHistory tempVerlauf = new TemperaturHistory();
        tempVerlauf.addTemp(new Temperatur(10f));

        TemperaturHistory newTempVerlauf = new TemperaturHistory();
        newTempVerlauf.addTemp(new Temperatur(20f));

        assertThat(tempVerlauf.compareTo(newTempVerlauf)).isZero();
    }

    @Test
    void testGet() {
        TemperaturHistory verlauf = new TemperaturHistory();
        verlauf.addTemp(new Temperatur(10.0f));
        verlauf.addTemp(new Temperatur(20.0f));
        verlauf.addTemp(new Temperatur(30.0f));

        assertThat(verlauf.get(1).getDegreeKelvin()).isEqualTo(20.0f);

    }

    @Test
    void testGetCount() {
        TemperaturHistory tempVerlauf = new TemperaturHistory();
        tempVerlauf.addTemp(new Temperatur());
        tempVerlauf.addTemp(new Temperatur());
        tempVerlauf.addTemp(new Temperatur());
        assertThat(tempVerlauf.getCount()).isEqualTo(3);

    }

    @Test
    void testMaxTemp() {
        TemperaturHistory verlauf = new TemperaturHistory();
        verlauf.addTemp(new Temperatur(10.0f));
        verlauf.addTemp(new Temperatur(20.0f));
        verlauf.addTemp(new Temperatur(30.0f));
        verlauf.addTemp(new Temperatur(5.0f));

        assertEquals(30.0f, (verlauf.maxTemp()));

    }

    @Test
    void testMinTemp() {
        TemperaturHistory verlauf = new TemperaturHistory();
        verlauf.addTemp(new Temperatur(22.2f));
        verlauf.addTemp(new Temperatur(33.3f));
        verlauf.addTemp(new Temperatur(66.6f));
        verlauf.addTemp(new Temperatur(9.0f));

        assertThat(verlauf.minTemp()).isEqualTo(9.0f);

    }
}
