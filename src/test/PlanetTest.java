package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Planet;

class PlanetTest {

	@Test
	void testPlanet() {
		Planet planet = new Planet();
		String name = planet.getplanetName();
		boolean searched = planet.checkSearched();
		
		assert(name.toString() == name);
	}

}
