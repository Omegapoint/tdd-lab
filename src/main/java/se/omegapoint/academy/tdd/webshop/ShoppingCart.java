package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.Collection;

public class ShoppingCart {
    private PricingService pricingService;
    private BigDecimal totalCost = new BigDecimal(0);
    int numberOfItems = 0;

    public ShoppingCart(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public ShoppingCart() {

    }

    public int numberOfItems() {
        return numberOfItems;
    }

    public void addItem(Item item) {
        numberOfItems++;
        if (null!= pricingService) {
            totalCost = totalCost.add(pricingService.priceForItem(item.getItemId()));
        }
        else {
            totalCost = totalCost.add(item.getPrice());
        }
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Collection<Item> getItems() {
        return null;
    }
}
