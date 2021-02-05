package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class ShoppingCart {

    private int numberOfItems;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private PricingService pricingService;

    public ShoppingCart(){
        this.pricingService = new PriceDatabase();

    }
    public ShoppingCart(PricingService pricingService){
        this.pricingService = pricingService;

    }

    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    public void addItem(Item item) {
        this.numberOfItems++;
        totalPrice = this.totalPrice.add(pricingService.priceForItem(item.getItemId()));
        //totalPrice = this.totalPrice.add(bilar.getPrice());
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
}
