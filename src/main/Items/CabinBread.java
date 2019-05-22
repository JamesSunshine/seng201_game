package main.Items;

public class CabinBread extends Item {

    public static final String ITEM_NAME = "Cabin Bread";
    private String itemType = "Food";
    private int itemStat = 1;
    private int itemValue = 1;
    private boolean isCure = false;
    
	public CabinBread() {

        super("Cabin Bread", "Food", 1, 1, "Reduces hunger by 1", false);
    }
}
