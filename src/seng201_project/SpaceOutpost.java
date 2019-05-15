package seng201_project;

import seng201_project.Items.*;

import java.util.ArrayList;

public class SpaceOutpost extends Item {

    public ArrayList<String> viewShop() {
        return new ArrayList<String>();

    }

    public Item purchase(String itemName) throws Exception{
        switch (itemName){
            case AidsCure.ITEM_NAME:
                Inventory.add(new AidsCure());
            case Bandages.ITEM_NAME:
                Inventory.add(new Bandages());
            case CabinBread.ITEM_NAME:
                Inventory.add(new CabinBread());
            case CaesarSalad.ITEM_NAME:
                Inventory.add(new CaesarSalad());
            case ConcretePill.ITEM_NAME:
                Inventory.add(new ConcretePill());
            case Doritos.ITEM_NAME:
                Inventory.add(new Doritos());
            case MiGoreng.ITEM_NAME:
                Inventory.add(new MiGoreng());
            case SpaceWhopper.ITEM_NAME:
                Inventory.add(new SpaceWhopper());
            case TunaMelt.ITEM_NAME:
                Inventory.add(new TunaMelt());

            default: throw new Exception("Not an item");

        }
    }

}
