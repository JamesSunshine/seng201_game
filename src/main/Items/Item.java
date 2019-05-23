package main.Items;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public abstract class Item {

    /** The item name. */
    private String itemName;
    
    /** The item type. */
    private String itemType;
    
    /** The item stat. */
    private int itemStat;
    
    /** The item value. */
    private int itemValue;
    
    /** The item effect. */
    private String itemEffect;
    
    /** The is cure. */
    private boolean isCure = false;
    
    /**
     * Instantiates a new item.
     *
     * @param name the name
     * @param type the type
     * @param stat the stat
     * @param value the value
     * @param effect the effect
     */
    public Item(String name, String type, int stat, int value, String effect) {
        itemName = name;
        itemType = type;
        itemStat = stat;
        itemValue = value;
        itemEffect = effect;
    }
    
    /**
     * Gets the item name.
     *
     * @return the name
     */
    public String getName() {
    	return itemName;
    }
    
    /**
     * Gets the item stats.
     *
     * @return the stat
     */
    public int getStat() {
    	return itemStat;
    }
    
    /**
     * Gets the item type.
     *
     * @return the type
     */
    public String getType() {
    	return itemType;
    }
    
    /**
     * Gets the item effect.
     *
     * @return the effect
     */
    public String getEffect() {
    	return itemEffect;
    }


}
