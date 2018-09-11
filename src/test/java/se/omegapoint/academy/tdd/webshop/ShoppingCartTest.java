package se.omegapoint.academy.tdd.webshop;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    private void givenEmptyShoppingCart() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void empty_shoppingCart_should_have_zero_items() {
        givenEmptyShoppingCart();

        //Then
        assertEquals(0,shoppingCart.getNumberOfItems());
    }

    @Test
    public void when_adding_one_item_shoppingcart_should_have_one_item(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //When
        shoppingCart.add(Items.BILAR);
        //Then
        assertEquals(1, shoppingCart.getNumberOfItems());
    }
    @Test
    public void empty_shoppingcart_should_have_price_zero(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //then
        assertEquals(BigDecimal.valueOf(0),shoppingCart.getBalance());

    }

    @Test
    public void when_adding_one_item_shoppingcart_should_have_nonzero_balance(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //When
        shoppingCart.add(Items.BILAR);
        //Then
        assertEquals(Items.BILAR.getPrice(), shoppingCart.getBalance());
    }

    @Test
    public void empty_shoppingcart_should_return_empty_collection() {
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //Then
        Assertions.assertThat(shoppingCart.getItems()).isEmpty();
    }

    @Test
    public void when_adding_two_items_shoppingcart_should_have_nonzero_nr_items() {
        givenEmptyShoppingCart();
        //when
        shoppingCart.add(Items.BRUN_BANAN);
        shoppingCart.add(Items.JOLT);
        //then
        Assertions.assertThat(shoppingCart.getItems()).containsExactlyInAnyOrder(Items.BRUN_BANAN, Items.JOLT);

    }

}