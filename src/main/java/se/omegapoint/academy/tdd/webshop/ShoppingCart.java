package se.omegapoint.academy.tdd.webshop;

public class ShoppingCart {

    private int numberOfItems;


    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    public void addItem(Item bilar) {
        this.numberOfItems++;
    }
}
