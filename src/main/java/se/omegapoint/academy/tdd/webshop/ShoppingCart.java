package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

public class ShoppingCart {

    private int numberOfItems = 0;
    private BigDecimal balance = BigDecimal.valueOf(0);
    private final PricingService pricingService;

    public ShoppingCart(PricingService pricingService) {
        this.pricingService = pricingService;
    }


    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void add(Item item) {
        numberOfItems++;
        balance = balance.add(pricingService.priceForItem(item.getItemId()));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Collection<Item> getItems() {
        return Collections.EMPTY_LIST;
    }
}
