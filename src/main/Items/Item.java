package main.Items;

public abstract class Item {

    private String itemName;
    private String itemType;
    private int itemStat;
    private int itemValue;
    private String itemEffect;
    private boolean isCure = false;
    
    public Item(String name, String type, int stat, int value, String effect) {
        itemName = name;
        itemType = type;
        itemStat = stat;
        itemValue = value;
        itemEffect = effect;
    }
    
    public String getName() {
    	return itemName;
    }
    
    public int getStat() {
    	return itemStat;
    }
    
    public String getType() {
    	return itemType;
    }
    
    public String getEffect() {
    	return itemEffect;
    }


}
