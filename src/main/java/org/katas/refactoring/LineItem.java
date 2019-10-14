package org.katas.refactoring;

public class LineItem {
    private String itemDescription;
    private double price;
    private int qty;

    public LineItem(String itemDescription, double price, int qty) {
        super();
        this.itemDescription = itemDescription;
        this.price = price;
        this.qty = qty;
    }

    public String getDescription() {
        return itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return price * qty;
    }
}