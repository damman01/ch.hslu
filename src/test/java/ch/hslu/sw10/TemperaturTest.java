package ch.hslu.sw10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TemperaturTest {

	/**
	 * Test für Equals Contract
	 */
	@Test
	void testEqualsContract() {
		EqualsVerifier.forClass(Temperatur.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void shouldCreateFromKelvin() {
		final float kelvin = 100.001f;

		final Temperatur actualValue = Temperatur.createFromKelvin(kelvin);
		assertThat(actualValue.getDegreeKelvin()).isEqualTo(100.001f);
	}

	@Test
	public void shouldCreateFromCelsius() {
		final float celsius = 200.001f;

		final Temperatur actualValue = Temperatur.createFromCelsius(celsius);
		assertThat(actualValue.getDegreeCelsius()).isEqualTo(200.001f);
	}

	@Test
	public void shouldGetDegreeCelsius() {
		assertThat(Temperatur.createFromKelvin(300.003f).getDegreeCelsius()).isCloseTo(26.853f, offset(0.001f));
	}

	@Test
	public void shouldGetDegreeKelvin() {
		assertThat(Temperatur.createFromKelvin(3.15f).getDegreeKelvin()).isEqualTo(3.15f, offset(0.0001f));
	}

	@Test
	public void shouldGetDegreeFahrenheit() {
		assertThat(Temperatur.createFromKelvin(273.15f).getDegreeFahrenheit()).isEqualTo(32f, offset(0.0001f));
	}

	@Test
	public void shouldIncreaseTemperatur() {
		final Temperatur testTemp = Temperatur.createFromCelsius(20.0f);
		testTemp.increaseTemperatur(25f);
		assertThat(testTemp.getDegreeCelsius()).isEqualTo(45f);
	}

	@Test
	public void shouldDecreaseTemperatur() {
		final Temperatur testTemp = Temperatur.createFromCelsius(20.0f);
		testTemp.decreaseTemperatur(654.321f);
		assertThat(testTemp.getDegreeCelsius()).isEqualTo(-634.321f);
	}

	@Test
	public void shouldToString() {
		assertThat(Temperatur.createFromCelsius(20.0000f).toString()).startsWith("\n Temperatur{").contains("293")
				.endsWith("293.15}");
	}

	@Test
	public void shouldHashCode() {
		final Temperatur temp1 = Temperatur.createFromKelvin(100.001f);
		final Temperatur temp2 = Temperatur.createFromKelvin(100.001f);

		assertThat(temp1.hashCode()).isEqualTo(temp2.hashCode());
	}

	@Test
	public void shouldThrowIllegalArgument(){
		assertThatThrownBy(() -> {Temperatur.createFromKelvin(-1);}).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Eingegebene Temperatur unter Absolutem Nullpunkt!");
	}

}
