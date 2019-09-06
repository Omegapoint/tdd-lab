package se.omegapoint.academy.tdd.webshop;

public class ShoppingCart {

    int counter;

    public int getAllItems() {

        return counter;
    }

    public void addItem(Item brunBanan) {
        counter++;

    }
}
