package se.omegapoint.academy.tdd.webshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Test
    public void empty_cart_counts_zero() {
        // given
        shoppingCart = new ShoppingCart();

        // when - then
        assertThat(shoppingCart.count()).isEqualTo(0);

    }

    @Test
    public void cart_has_one_item() {
        // given
        shoppingCart = new ShoppingCart();

        // when
        shoppingCart.addItem(Items.BRUN_BANAN);

        // then
        assertThat(shoppingCart.count()).isEqualTo(1);

    }

    @Test
    public void cart_has_several_items() {
        // given
        shoppingCart = new ShoppingCart();

        // when
        shoppingCart.addItem(Items.BRUN_BANAN);
        shoppingCart.addItem(Items.JOLT);
        shoppingCart.addItem(Items.KEXCHOKLAD);

        // then
        assertThat(shoppingCart.count()).isEqualTo(3);

    }
}
