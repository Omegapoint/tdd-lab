package se.omegapoint.academy.tdd.webshop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingCartTest {

    @Test
    public void shoppingCartEmptyTest(){
        ShoppingCart shoppingCart = new ShoppingCart();

        assertThat(shoppingCart.getAllItems()).isEqualTo(0);
    }

}
