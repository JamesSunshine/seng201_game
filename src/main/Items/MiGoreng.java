package main.Items;

public class MiGoreng extends Item{

    public static final String ITEM_NAME = "Mi Goreng";
    private String itemType = "Food";
    private int itemStat = 2;
    private int itemValue = 2;
    private boolean isCure = false;
    
	public MiGoreng() {

        super("Mi Goreng", "Food", 2, 2, "Reduces hunger by 2", false);
    }
}
