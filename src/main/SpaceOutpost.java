package main;

import main.Items.*;

import java.util.ArrayList;

public class SpaceOutpost {

    public ArrayList<String> viewShop() {
        return new ArrayList<String>();

    }

    public Item purchase(String itemName) {
        switch (itemName){
            case AidsCure.ITEM_NAME: {
                return new AidsCure();
            }
            case Bandages.ITEM_NAME: {
                return new Bandages();
            }
            case CabinBread.ITEM_NAME: {
                return new CabinBread();
            }
            case CaesarSalad.ITEM_NAME: {
                return new CaesarSalad();
            }
            case ConcretePill.ITEM_NAME: {
                return new ConcretePill(); 
            }
            case Doritos.ITEM_NAME: {
                return new Doritos(); 
            }
            case MiGoreng.ITEM_NAME: {
                return new MiGoreng(); 
            }
            case SpaceWhopper.ITEM_NAME: {
                return new SpaceWhopper();
            }
            case TunaMelt.ITEM_NAME: {
                return new TunaMelt();
            }
            
        }
        return null; 
    }

}
