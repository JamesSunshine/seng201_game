package seng201_project;

import seng201_project.Items.AidsCure;
import seng201_project.Items.Item;

import java.util.ArrayList;

public class SpaceOutpost extends Item {

    public ArrayList<String> viewShop() {
        return new ArrayList();

    }

    public Item purchase(String itemName) {
        switch (itemName){
            case AidsCure.ITEM_NAME:
                return new AidsCure();
            case Bandages.ITEM_NAME:
                return
        }
    }

}
