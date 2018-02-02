package se.omegapoint.academy.tdd.webshop;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Test
    public void empty_cart_counts_zero() {

        givenEmptyShoppingCart();

        thenCartHasItemCount(0);

    }

    @Test
    public void cart_has_one_item() {
        givenEmptyShoppingCart();

        whenAddingItems(Items.BRUN_BANAN);

        thenCartHasItemCount(1);

    }

    @Test
    public void cart_has_several_items() {
        givenEmptyShoppingCart();

        whenAddingItems(Items.BRUN_BANAN, Items.JOLT, Items.KEXCHOKLAD);

        thenCartHasItemCount(3);

    }

    @Test
    public void total_price_of_items_is_zero() {
      //given
      givenEmptyShoppingCart();

      //when -- then
      assertThat(shoppingCart.getTotalPrice()).isEqualTo(BigDecimal.ZERO);

    }

    @Test
    public void total_price_of_items_is_not_zero(){
        //given
        givenEmptyShoppingCart();

        //when
        whenAddingItems(Items.BRUN_BANAN,Items.JOLT,Items.KEXCHOKLAD);

        //then
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(new BigDecimal("35.50"));

    }

    private void whenAddingItems(Item... items) {
        Stream.of(items).forEach(item -> shoppingCart.addItem(item));
    }

    private void thenCartHasItemCount(int expected) {
        assertThat(shoppingCart.count()).isEqualTo(expected);
    }

    private void givenEmptyShoppingCart() {
        shoppingCart = new ShoppingCart();
    }
}
