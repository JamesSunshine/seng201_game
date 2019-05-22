package main.Items;

public abstract class Item {

    private String itemName;
    private String itemType;
    private int itemStat;
    private int itemValue;
    private String itemEffect;
    private boolean isCure = false;
    
    public Item(String name, String type, int stat, int value, String effect, boolean cure) {
        itemName = name;
        itemType = type;
        itemStat = stat;
        itemValue = value;
        itemEffect = effect;
        isCure = cure;
    }
    
    public String getName() {
    	return itemName;
    }
    
    public int getValue() {
    	return itemValue;
    }
    
    public String getEffect() {
    	return itemEffect;
    }


}
