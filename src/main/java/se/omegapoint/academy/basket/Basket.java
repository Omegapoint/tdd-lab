package se.omegapoint.academy.basket;

import se.omegapoint.academy.basket.items.Candy;
import se.omegapoint.academy.basket.items.Magazine;
import se.omegapoint.academy.basket.receipt.ReceiptLogger;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Item> items = new ArrayList<>();
    public ReceiptLogger logger;
    public Basket(ReceiptLogger receiptLogger)
    {
        logger = receiptLogger;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addCandy(String name) {

        final Candy tempCandy = new Candy(name);
        items.add(tempCandy);
        logger.add(tempCandy);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addMagazine(String name){
        items.add(new Magazine(name));
    }
}
