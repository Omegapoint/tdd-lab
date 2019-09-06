package se.omegapoint.academy.tdd.webshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingCartTest {

    @Test
    public void shopping_cart_is_empty_when_created(){

        //given
        ShoppingCart shoppingCart = new ShoppingCart();

        //when
        int numberOfItems = shoppingCart.getAllItems();

        //then
        assertThat(numberOfItems).isEqualTo(0);
    }

}
