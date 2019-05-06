package seng201_project;

public class Item {

    private String itemName;
    private String itemType;
    private int itemStat;
    private int itemValue;
    private boolean isCure = false;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemStat() {
        return itemStat;
    }

    public void setItemStat(int itemStat) {
        this.itemStat = itemStat;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public boolean getIsCure() {
        return isCure;
    }

    public void setIsCure(boolean isCure) {
        this.isCure = isCure;
    }
}
