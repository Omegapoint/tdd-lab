package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public ShoppingCart(){}

    public int getNumberOfItems() {
        return items.size();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for(Item item : items) {
            sum = sum.add(item.getPrice());
        }
        return sum;
    }
}
