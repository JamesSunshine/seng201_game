package main.Items;

public class Doritos extends Item {

    public static final String ITEM_NAME = "Doritos";
    private String itemType = "Food";
    private int itemStat = 3;
    private int itemValue = 3;
    private boolean isCure = false;
    
	public Doritos() {

        super("Doritos", "Food", 3, 3, "Reduces hunger by 3", false);
    }
}
