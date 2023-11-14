package se.omegapoint.academy.tdd.webshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ShoppingCartTest - tests for ShoppingCart
 * Created: 2023-11-14
 * Author: Mark Annala, mark.annala@omegapoint.se
 */
public class ShoppingCartTest {
    @Test
    void should_add_item() {
        final ShoppingCart newCart = new ShoppingCart().addItem(Items.JOLT);
        assertEquals(1, newCart.numberOfItems());
    }

    @Test
    void should_calculate_price() {
        final ShoppingCart cart = new ShoppingCart();
        assertEquals(0d, cart.priceOfCart());
        final ShoppingCart newCart = cart
                .addItem(Items.BILAR)
                .addItem(Items.LORANGA);
        assertEquals(36, newCart.priceOfCart());
    }

    @Test
    void should_create_receipt() {
        final String receipt = new ShoppingCart()
                .addItem(Items.BRUN_BANAN)
                .addItem(Items.LORANGA)
                .receipt();
        assertEquals("""
                Receipt:
                1. Banan, 7 SEK
                2. Loranga, 13 SEK""", receipt);
    }
}
