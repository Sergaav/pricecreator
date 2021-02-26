package model;

public class Item {
    private int itemId;
    private String nameRus;
    private String nameUkr;
    private double priceIn;
    private double priceStruck;
    private double priceOut;
    private double weight;
    private String ItemCatNumber;
    private String brand;

    public Item() {
    }

    public Item(int itemId, String nameRus, String nameUkr,
                double priceIn, double priceStruck, double priceOut,
                double weight, String itemCatNumber, String brand) {
        this.itemId = itemId;
        this.nameRus = nameRus;
        this.nameUkr = nameUkr;
        this.priceIn = priceIn;
        this.priceStruck = priceStruck;
        this.priceOut = priceOut;
        this.weight = weight;
        ItemCatNumber = itemCatNumber;
        this.brand = brand;
    }
}
