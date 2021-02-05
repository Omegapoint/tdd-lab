package se.omegapoint.academy.tdd.webshop;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
        Assert.assertEquals(0, shoppingCart.returnNumberOfItems());
    }

    @Test
    public void checkThatReturnNumberOfItemsIsOneAfterAddingOne(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //When
        shoppingCart.addItem(Items.KEXCHOKLAD);
        //Then
        Assert.assertEquals(1, shoppingCart.returnNumberOfItems());
    }

    @Test
    public void checkShoppingCartPriceIsZeroWhenNoItems(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //When

        //Then
        Assert.assertEquals(BigDecimal.ZERO, shoppingCart.returnPrice());
    }

    @Test
    public void checkShoppingCartPriceIsCorrect(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart();
        //When
        shoppingCart.addItem(Items.KEXCHOKLAD);
        //Then
        Assert.assertEquals(BigDecimal.valueOf(14), shoppingCart.returnPrice());
    }
}
