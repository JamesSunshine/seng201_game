package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.CrewFactory;
import main.Types.CrewMember;

class CrewFactoryTest {

	@Test
	void testRecruit() {
		CrewFactory crewFactory = new CrewFactory();
		CrewMember gazza = crewFactory.recruit("engineer", "Gazza");
		String name = gazza.getName();
		String type = gazza.getType();
		int initialHunger = gazza.getHunger();
		gazza.getHungry();
		int finalHunger = gazza.getHunger();
		int hungerDiff = finalHunger - initialHunger;
		int initialTiredness = gazza.getTiredness();
		gazza.getTired();
		int finalTiredness = gazza.getTiredness();
		int tiredDiff = finalTiredness - initialTiredness;
		int initialHealth = gazza.getHealth();
		gazza.takeDamage(10);
		int finalHealth = gazza.getHealth();
		int healthDiff = initialHealth - finalHealth;
		
		assert(name == "Gazza");
		assert(type == "Engineer");
		assert(hungerDiff == 15);
		assert(tiredDiff == 15);
		assert(healthDiff == 10);
	}

}
