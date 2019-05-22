package main.Items;

public class ConcretePill extends Item {

    public static final String ITEM_NAME =  "Pain Killers";
    private String itemType = "Medicine";
    private int itemStat = 2;
    private int itemValue = 10;
    private boolean isCure = false;
    
	public ConcretePill() {

        super("Pain Killers", "Medicine", 2, 1, "Restores 1 health", false);
    }
}
