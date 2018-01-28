package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public interface PricingService {

    BigDecimal priceForItem(long itemId);
}
