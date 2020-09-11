package se.omegapoint.academy.tdd.webshop;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * ShoppingCartTest - [description goes here]
 * Created: 2020-09-11
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class ShoppingCartTest {

    @Test
    public void shopping_cart_is_not_null(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertNotNull(shoppingCart);
    }

    @Test
    public void new_shopping_cart_is_empty(){
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        // when
        int numberOfItems = shoppingCart.numberOfItems();
        // then
        Assert.assertEquals(0, numberOfItems);
    }

    @Test
    public void test_number_of_items_in_cart(){
      // given

        ShoppingCart shoppingCart = new ShoppingCart();
        Item firstItem = Items.KEXCHOKLAD;

      // when

        shoppingCart.addItem(firstItem);
        int numberOfItems = shoppingCart.numberOfItems();

      // then

        Assert.assertEquals(1, numberOfItems);
    }

    @Test
    public void test_initial_cost() {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();

        // when
        BigDecimal totalCost = shoppingCart.getTotalCost();

        // then
        Assert.assertEquals(new BigDecimal(0),totalCost);
    }

    @Test
    public void test_total_cost() {
        // given
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item = Items.BILAR;

        // when
        shoppingCart.addItem(item);
        BigDecimal cost = shoppingCart.getTotalCost();

        // then
        Assert.assertEquals(item.getPrice(), cost);
    }

    @Test
    public void test_pricing_service_is_used() {
        // given
        PricingService pricingService = Mockito.mock(PricingService.class);
        Item item = Items.JOLT;
        Mockito.when(pricingService.priceForItem(item.getItemId())).thenReturn(item.getPrice());
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);


        // when
        shoppingCart.addItem(item);
        shoppingCart.getTotalCost();

        // then
        Mockito.verify(pricingService).priceForItem(item.getItemId());
    }

    @Ignore
    @Test
    public void test_empty_shopping_cart_content(){

        // given
        ShoppingCart shoppingCart = new ShoppingCart();

        // when
        Collection<Item> items = shoppingCart.getItems();

        // then
        Assert.assertNotNull(items);
        Assert.assertTrue(items.isEmpty());
    }
}