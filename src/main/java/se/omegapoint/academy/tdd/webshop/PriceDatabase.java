package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class PriceDatabase implements PricingService {

    @Override
    public BigDecimal priceForItem(long itemId) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // ignore - Don't do this at home
        }
        throw new RuntimeException("Database connection failure!");
    }
}
