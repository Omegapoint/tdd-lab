package se.omegapoint.academy.tdd.webshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * ShoppingCartTest - tests for ShoppingCart
 * Created: 2021-02-03
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class ShoppingCartTest {

    @Test
    void givenNoAddedItemsBasketShouldReturnZero() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Assertions.assertEquals(0, shoppingCart.getNumberOfItems());
    }

    @Test
    void givenAddedItemsBasketShouldReturnNumberOfItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        // added
        shoppingCart.add(Items.KEXCHOKLAD);
        Assertions.assertEquals(1, shoppingCart.getNumberOfItems());
    }

    @Test
    void givenAddedItemsBasketShouldReturnCombinedPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        // added
        shoppingCart.add(Items.KEXCHOKLAD);
        shoppingCart.add(Items.BILAR);
        BigDecimal expectedPrice = Items.KEXCHOKLAD.getPrice().add(Items.BILAR.getPrice());
        Assertions.assertEquals(expectedPrice, shoppingCart.getCombinedPrice());
    }

    @Test
    void givenNoAddedItemsBasketShouldReturnZeroCombinedPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        BigDecimal expectedPrice = BigDecimal.ZERO;
        Assertions.assertEquals(expectedPrice, shoppingCart.getCombinedPrice());
    }


}