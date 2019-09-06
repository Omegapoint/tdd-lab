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

    @Test
    public void shopping_cart_has_one_item_when_one_item_is_added(){

        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(Items.BRUN_BANAN);

        //when
        int numberOfItems = shoppingCart.getAllItems();

        //then
        assertThat(numberOfItems).isEqualTo(1);
    }


}
