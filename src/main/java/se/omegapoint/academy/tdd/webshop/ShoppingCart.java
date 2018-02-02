package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private int numberOfItems = 0;
    private List<Item> items = new ArrayList<>();

    public int count() {
        return numberOfItems;
    }

    public void addItem(Item item) {
        numberOfItems++;
        items.add(item);
    }

    public BigDecimal getTotalPrice() {

        return items.stream()
                .map(i -> i.getPrice())
                .reduce(BigDecimal.ZERO, (first, second) -> first.add(second));

        // return BigDecimal.ZERO;

    }
}
