package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartWithPricingService {
    private List<Item> itemList;
    private PricingService pricingService;

    public ShoppingCartWithPricingService(PricingService pricingService) {
        itemList = new ArrayList<>();
        this.pricingService = pricingService;
    }

    public int getNumberOfItems() {
        return itemList.size();
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public BigDecimal getCombinedPrice() {
        return itemList.stream()
                .map(item -> pricingService.priceForItem(item.getItemId()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
