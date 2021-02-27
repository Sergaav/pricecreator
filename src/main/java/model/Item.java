package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    private int cart;
    private String nameRus;
    private String nameUkr;
    private double priceIn;
    private double priceStruck;
    private double priceOut;
    private double weight;
    private String ItemCatNumber;
    private String brand;

    public Item(int cart, String itemCatNumber, String nameRus, String nameUkr, String brand, double priceIn, double weight) {
        this.cart = cart;
        this.nameRus = nameRus;
        this.nameUkr = nameUkr;
        this.priceIn = priceIn;
        this.weight = weight;
        this.ItemCatNumber = itemCatNumber;
        this.brand = brand;
    }

    @Id
    public int getCart() {
        return cart;
    }

    public void setCart(int itemId) {
        this.cart = itemId;
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
        double temp=0;
        if (priceIn < 100.00) {
            temp = priceIn * 2;
        } else if (priceIn < 500.00 && priceIn >= 100.00) {
            temp = priceIn * 1.90;
        }else if (priceIn < 1000.00 && priceIn >= 500.00) {
            temp = priceIn * 1.80;
        }else if (priceIn < 3000.00 && priceIn >= 1000.00) {
            temp = priceIn * 1.70;
        }else if (priceIn >= 3000.00) {
            temp = priceIn * 1.60;
        }

        return temp;
    }

    public void setPriceStruck(double priceStruck) {
        this.priceStruck = priceStruck;
    }

    public double getPriceOut() {
        double temp=0;
        if (priceIn < 100.00) {
            temp = priceIn * 1.80;
        } else if (priceIn < 500.00 && priceIn >= 100.00) {
            temp = priceIn * 1.70;
        }else if (priceIn < 1000.00 && priceIn >= 500.00) {
            temp = priceIn * 1.70;
        }else if (priceIn < 3000.00 && priceIn >= 1000.00) {
            temp = priceIn * 1.60;
        }else if (priceIn >= 3000.00) {
            temp = priceIn * 1.50;
        }

        return temp;
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

    public Item(int cart, String nameRus, String nameUkr,
                double priceIn, double priceStruck, double priceOut,
                double weight, String itemCatNumber, String brand) {
        this.cart = cart;
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
