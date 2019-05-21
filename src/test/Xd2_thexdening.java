package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Types.Engineer;

class Xd2_thexdening {

	@Test
	void test() {
		Engineer bobby = new Engineer("Gaz");
		int beforeHunger = bobby.getHunger();
		bobby.getHungry();
		int afterHunger = bobby.getHunger();
		int hungerDiff = beforeHunger - afterHunger;
		System.out.println(beforeHunger + " " + afterHunger);
		assert(hungerDiff == 2);
		
	}

}
