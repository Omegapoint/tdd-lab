package se.omegapoint.academy.tdd.webshop;

import org.junit.Assert;
import org.junit.Test;

/**
 * ShoppingCartTest - tests for ShoppingCart
 * Created: 2021-02-03
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class ShoppingCartTest {
    @Test
    public void testCreate(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertNotNull(shoppingCart);

    }

    @Test
    public void giveBackZero(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();

        //When

        //Then
        Assert.assertEquals(shoppingCart.returnNumberOfItems(),0);
    }
}
