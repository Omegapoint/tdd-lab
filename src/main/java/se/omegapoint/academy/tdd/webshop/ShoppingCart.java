package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

public class ShoppingCart {

    private int numberOfItems = 0;
    private BigDecimal balance = BigDecimal.valueOf(0);

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void add(Item item) {
        numberOfItems++;
        balance = balance.add(item.getPrice());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Collection<Item> getItems() {
        return Collections.EMPTY_LIST;
    }
}
