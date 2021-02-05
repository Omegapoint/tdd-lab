package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class ShoppingCart {

    private int numberOfItems;
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    public void addItem(Item bilar) {
        this.numberOfItems++;
        totalPrice = this.totalPrice.add(bilar.getPrice());
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
}
