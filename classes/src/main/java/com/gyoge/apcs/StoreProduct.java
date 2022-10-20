// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public class StoreProduct {

    private final String label;
    private final int price;
    private final String category;
    private final boolean hasExpiration;
    private int stock;

    public StoreProduct(String label, int price, String category, boolean hasExpiration) {
        this.label = label;
        this.price = price;
        this.category = category;
        this.hasExpiration = hasExpiration;
        this.stock = 0;
    }

    public StoreProduct(String label, int price) {
        this.label = label;
        this.price = price;
        this.category = "misc";
        this.hasExpiration = false;
        this.stock = 0;
    }

    public StoreProduct(String label, int price, int stock) {
        this.label = label;
        this.price = price;
        this.category = "misc";
        this.hasExpiration = false;
        this.stock = stock;
    }

    // spotless:off
    public StoreProduct(
        String label,
        int price,
        String category,
        boolean hasExpiration,
        int stock
    ) {
        this.label = label;
        this.price = price;
        this.category = category;
        this.hasExpiration = hasExpiration;
        this.stock = stock;
    }
    // spotless:on

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean getExpiration() {
        return hasExpiration;
    }

    public int getStock() {
        return stock;
    }

    public void expired(boolean hasExpired) {
        if (hasExpiration && hasExpired) {
            stock = 0;
        }
    }

    public boolean sale(int quantity) {
        if (stock < quantity) return false;
        stock -= quantity;
        return true;
    }

    public double getDiscountedPrice(double discount) {
        return price * (1 - discount);
    }
}
