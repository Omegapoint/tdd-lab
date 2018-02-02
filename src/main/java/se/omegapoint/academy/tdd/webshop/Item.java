package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class Item {

    private final long itemId;
    private final String name;
    private final BigDecimal price;

    public Item(long itemId, String name, BigDecimal price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
