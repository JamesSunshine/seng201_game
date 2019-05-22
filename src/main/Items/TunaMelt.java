package main.Items;

public class TunaMelt extends Item {

    public static final String ITEM_NAME = "Tuna Melt Sandwich";
    private String itemType = "Food";
    private int itemStat = 4;
    private int itemValue = 4;
    private boolean isCure = false;
    
	public TunaMelt() {

        super("Tuna Melt Sandwich", "Food", 4, 4, "Reduces hunger by 4", false);
    }
}
