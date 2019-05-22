package main.Items;

public class SpaceWhopper extends Item{

    public static final String ITEM_NAME = "Space Whopper";
    private String itemType = "Food";
    private int itemStat = 6;
    private int itemValue = 6;
    private boolean isCure = false;
    
	public SpaceWhopper() {

        super("Space Whopper", "Food", 6, 6, "Reduces hunger by 6", false);
    }
}
