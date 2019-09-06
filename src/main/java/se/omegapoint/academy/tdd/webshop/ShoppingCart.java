package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class ShoppingCart {

    final PricingService pricingService;
    int counter;
    BigDecimal sum = new BigDecimal(0);

    public ShoppingCart(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public int getAllItems() {

        return counter;
    }

    public void addItem(Item item) {
        counter++;
        sum = sum.add(pricingService.priceForItem(item.getItemId()));

    }

    public BigDecimal getSum() {
        return sum;
    }
}
