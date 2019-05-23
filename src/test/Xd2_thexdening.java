package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Types.Engineer;

class Xd2_thexdening {

	@Test
	void test() {
		Engineer bobby = new Engineer("Bobby");
		String name =bobby.getName();
		String type = bobby.getType();
		int initialHunger = bobby.getHunger();
		bobby.getHungry();
		int finalHunger = bobby.getHunger();
		int hungerDiff = finalHunger - initialHunger;
		int initialTiredness = bobby.getTiredness();
		bobby.getTired();
		int finalTiredness = bobby.getTiredness();
		int tiredDiff = finalTiredness - initialTiredness;
		
		assert(name == "Bobby");
		assert(type == "Engineer");
		assert(hungerDiff == 15);
		assert(tiredDiff == 15);
		
	}

}
