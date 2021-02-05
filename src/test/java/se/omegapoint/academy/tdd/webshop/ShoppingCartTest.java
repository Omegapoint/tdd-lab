package se.omegapoint.academy.tdd.webshop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * ShoppingCartTest - tests for ShoppingCart
 * Created: 2021-02-03
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class ShoppingCartTest {

    private PricingService pricingService;

    @Before
    public void Before(){
        pricingService = new PriceDatabase();
    }

    @Test
    public void testCreate(){
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        Assert.assertNotNull(shoppingCart);

    }

    @Test
    public void giveBackZero(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);

        //When

        //Then
        Assert.assertEquals(0, shoppingCart.returnNumberOfItems());
    }

    @Test
    public void checkThatReturnNumberOfItemsIsOneAfterAddingOne(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //When
        shoppingCart.addItem(Items.KEXCHOKLAD);
        //Then
        Assert.assertEquals(1, shoppingCart.returnNumberOfItems());
    }

    @Test
    public void checkShoppingCartPriceIsZeroWhenNoItems(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //When

        //Then
        Assert.assertEquals(BigDecimal.ZERO, shoppingCart.returnPrice());
    }


    @Test
    public void checkShoppingCartPriceIsCorrect(){
        //Given
        PricingService pricingService = Mockito.mock(PricingService.class);
        Mockito.when(pricingService.priceForItem(Items.KEXCHOKLAD.getItemId())).thenReturn(BigDecimal.valueOf(14));
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //When
        shoppingCart.addItem(Items.KEXCHOKLAD);
        //Then
        Assert.assertEquals(BigDecimal.valueOf(14), shoppingCart.returnPrice());
    }

    @Test
    public void checkShoppingCartPriceIsCorrectWithTwoItems(){
        //Given
        PricingService pricingService = Mockito.mock(PricingService.class);
        Mockito.when(pricingService.priceForItem(Items.KEXCHOKLAD.getItemId())).thenReturn(BigDecimal.valueOf(14));
        Mockito.when(pricingService.priceForItem(Items.JOLT.getItemId())).thenReturn(BigDecimal.valueOf(10));
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //When
        shoppingCart.addItem(Items.KEXCHOKLAD);
        shoppingCart.addItem(Items.JOLT);
        //Then
        Assert.assertEquals(BigDecimal.valueOf(24), shoppingCart.returnPrice());
        Mockito.verify(pricingService).priceForItem(Items.KEXCHOKLAD.getItemId());

    }
}
