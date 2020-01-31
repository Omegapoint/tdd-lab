package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ShoppingCart {
    private final PricingService pricingService;
    private BigDecimal totalPrice = new BigDecimal(0);
    private Collection<Item> itemList = new ArrayList<>();

    public ShoppingCart (PricingService pricingService){
        this.pricingService = pricingService;
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public void addToCart(Item item) {
        totalPrice = totalPrice.add(pricingService.priceForItem(item.getItemId()));
        itemList.add(item);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Collection<Item> getItems() {
        return itemList;
    }
}
