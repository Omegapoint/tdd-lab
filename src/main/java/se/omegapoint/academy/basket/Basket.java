package se.omegapoint.academy.basket;

import se.omegapoint.academy.basket.items.Candy;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Item> items = new ArrayList<>();
    private int numberOfItems = 0;

    public int getNumberOfItems() {
        return numberOfItems;
    }
    public void addCandy(Candy candy) {
        numberOfItems++;
    }
}
