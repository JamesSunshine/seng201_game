package main.Items;

public class CaesarSalad extends Item {

    public static final String ITEM_NAME = "Caesar Salad";
    private String itemType = "Food";
    private int itemStat = 5;
    private int itemValue = 5;
    private boolean isCure = false;
    
	public CaesarSalad() {

        super("Caesar Salad", "Food", 5, 5, "Reduces hunger by 5", false);
    }
}
