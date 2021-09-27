package ch.hslu.oop.sw11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class FahrzeugTest {

	
    private static Logger LOG = LogManager.getLogger(FahrzeugTest.class);
	@Test
	void testFahrzeugState() {
		Fahrzeug seatIbiza = new Fahrzeug("Seat Ibiza ST ");
		LOG.debug(seatIbiza.model + "STATE :" + seatIbiza.state);
		assertTrue(seatIbiza.isSwitchedOff());

		seatIbiza.switchon();
		assertThat(seatIbiza.isSwitchedOn()).isTrue();
		LOG.debug(seatIbiza.model + "STATE :" +  seatIbiza.state);
	}
}
