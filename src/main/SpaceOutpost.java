package main;

import main.Items.*;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class SpaceOutpost.
 */
public class SpaceOutpost {

    /**
     * View shop.
     *
     * @return the array list
     */
    public ArrayList<String> viewShop() {
        return new ArrayList<String>();

    }

    /**
     * Purchase an item
     *
     * @param itemName the item name
     * @return the item
     */
    public Item purchase(String itemName) {
        switch (itemName){
            case "Aids Cure": {
                return new AidsCure();
            }
            case "Bandages": {
                return new Bandages();
            }
            case "Cabin Bread": {
                return new CabinBread();
            }
            case "Caesar Salad": {
                return new CaesarSalad();
            }
            case "Pain Killers": {
                return new ConcretePill(); 
            }
            case "Doritos": {
                return new Doritos(); 
            }
            case "Mi Goreng": {
                return new MiGoreng(); 
            }
            case "Space Whopper": {
                return new SpaceWhopper();
            }
            case "Tuna Melt Sandwich": {
                return new TunaMelt();
            }
            
        }
        return null; 
    }

}
