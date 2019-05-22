package main.Items;

public class Bandages extends Item {

    public static final String ITEM_NAME = "Bandages";
    private String itemType = "Medicine";
    private int itemStat = 4;
    private int itemValue = 2;
    private boolean isCure = false;
    
	public Bandages() {

        super("Bandages", "Medicine", 4, 2, "Restores 2 health", false);
    }
}
