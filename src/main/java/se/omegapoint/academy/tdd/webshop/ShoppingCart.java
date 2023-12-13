package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> itemList;

    public ShoppingCart() {
        itemList = new ArrayList<>();
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public BigDecimal getCombinedPrice() {
        return itemList.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}