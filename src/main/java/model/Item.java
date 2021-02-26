package model;

import javax.persistence.Entity;

@Entity
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getNameUkr() {
        return nameUkr;
    }

    public void setNameUkr(String nameUkr) {
        this.nameUkr = nameUkr;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public double getPriceStruck() {
        return priceStruck;
    }

    public void setPriceStruck(double priceStruck) {
        this.priceStruck = priceStruck;
    }

    public double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(double priceOut) {
        this.priceOut = priceOut;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getItemCatNumber() {
        return ItemCatNumber;
    }

    public void setItemCatNumber(String itemCatNumber) {
        ItemCatNumber = itemCatNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

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
