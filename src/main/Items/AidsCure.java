package main.Items;

public class AidsCure extends Item {

    public static final String ITEM_NAME = "Aids Cure";
    private String itemType = "Medicine";
    private int itemStat = 0;
    private int itemValue = 4;
    private boolean isCure = true;
    
	public AidsCure() {

        super("Aids Cure", "Medicine", 0, 4, "Cures Space Aids", true);
    }
}
