package se.omegapoint.academy.tdd.webshop;

public class ShoppingCart {

    private int numberOfItems = 0;

    public int count() {
        return numberOfItems;
    }

    public void addItem(Item item) {
        numberOfItems++;
    }
}
