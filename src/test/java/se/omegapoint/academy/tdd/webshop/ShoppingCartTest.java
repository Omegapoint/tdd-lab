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
    public void canCreateShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertNotNull(shoppingCart);
    }

    @Test
    public void canShowNumberOfItems(){
        ShoppingCart shoppingCart = new ShoppingCart();
        int numberOfItems = shoppingCart.getNumberOfItems();
        Assert.assertEquals(0, numberOfItems);


    }



    //public void numberOfItemsIsCorrect
}
