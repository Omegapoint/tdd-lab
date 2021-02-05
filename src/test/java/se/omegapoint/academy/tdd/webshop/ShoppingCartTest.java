package se.omegapoint.academy.tdd.webshop;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

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
    public void canGetEmptyCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        int numberOfItems = shoppingCart.getNumberOfItems();
        Assert.assertEquals(0, numberOfItems);
    }

    @Test
    public void canGetNonEmptyCart(){
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(Items.BILAR);
        int numberOfItems = shoppingCart.getNumberOfItems();
        Assert.assertEquals(1, numberOfItems);
    }

    //public void numberOfItemsIsCorrect

    @Test
    public void isPriceZero(){
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(Items.BILAR);

        BigDecimal totalPrice = shoppingCart.getTotalPrice();

        Assert.assertEquals(Items.BILAR.getPrice(), totalPrice);


    }
    @Test
    public void checkTotalPrice(){
        PricingService mockDatabase = Mockito.mock(PriceDatabase.class);
        Mockito.when(mockDatabase.priceForItem(Mockito.anyLong()))
                .thenReturn(Items.BILAR.getPrice());

        //Mockito.when(mockDatabase.priceForItem(Items.JOLT.getItemId()))
        //        .thenReturn(Items.JOLT.getPrice());


        ShoppingCart shoppingCart = new ShoppingCart(mockDatabase);

        shoppingCart.addItem(Items.BILAR);

        BigDecimal totalPrice = shoppingCart.getTotalPrice();

        Mockito.verify(mockDatabase).priceForItem(Items.BILAR.getItemId());

        Assert.assertEquals(Items.BILAR.getPrice(), totalPrice);


    }

}
