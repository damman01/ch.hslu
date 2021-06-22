package ch.hslu.sw11;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FahrzeugTest {

	@Test
	void testFahrzeugState() {
		Fahrzeug seatIbiza = new Fahrzeug("Seat Ibiza ST");
		assertThat(seatIbiza.isSwitchedOff()).isTrue();
	}

}
