package test;

import org.junit.jupiter.api.Test;

import main.SpaceOutpost;
import main.Items.Item;

class SpaceOutpostTest {

	@Test
	void testPurchase() {
		SpaceOutpost spaceOutpost = new SpaceOutpost();
		Item spaceWhopper = spaceOutpost.purchase("Space Whopper");
		String name = spaceWhopper.getName();
		String type = spaceWhopper.getType();
		String effect = spaceWhopper.getEffect();
		int stat = spaceWhopper.getStat();
		
		assert(name == "Space Whopper");
		assert(type == "Food");
		assert(effect == "Reduces hunger by 6");
		assert(stat == 60);
		
	}

}
