package main;

import main.Items.*;

import java.util.ArrayList;

public class SpaceOutpost {

    public ArrayList<String> viewShop() {
        return new ArrayList<String>();

    }

    public Item purchase(String itemName) throws Exception{
        switch (itemName){
            case AidsCure.ITEM_NAME:
                Ship.addInventory(new AidsCure());
            case Bandages.ITEM_NAME:
                Ship.addInventory(new Bandages());
            case CabinBread.ITEM_NAME:
                Ship.addInventory(new CabinBread());
            case CaesarSalad.ITEM_NAME:
                Ship.addInventory(new CaesarSalad());
            case ConcretePill.ITEM_NAME:
                Ship.addInventory(new ConcretePill());
            case Doritos.ITEM_NAME:
                Ship.addInventory(new Doritos());
            case MiGoreng.ITEM_NAME:
                Ship.addInventory(new MiGoreng());
            case SpaceWhopper.ITEM_NAME:
                Ship.addInventory(new SpaceWhopper());
            case TunaMelt.ITEM_NAME:
                Ship.addInventory(new TunaMelt());

            default: throw new Exception("Not an item");

        }
    }

}
