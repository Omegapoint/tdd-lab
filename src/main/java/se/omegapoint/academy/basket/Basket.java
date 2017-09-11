package se.omegapoint.academy.basket;

import se.omegapoint.academy.basket.items.Candy;
import se.omegapoint.academy.basket.items.Magazine;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Item> items = new ArrayList<>();
    private int numberOfItems = 0;
    private Logger logger;

    Basket(Logger logger) {
        this.logger = logger;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
    public void addCandy(Candy candy) {
        numberOfItems++;
        items.add(candy);
        logger.add(candy);
    }

    public void addMagazine(Magazine mag) {
        numberOfItems++;
        items.add(mag);
        logger.add(mag);
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }


}
