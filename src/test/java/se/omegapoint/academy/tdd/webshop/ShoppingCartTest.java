package se.omegapoint.academy.tdd.webshop;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private final PricingService pricingService = mock(PricingService.class);

    private void givenEmptyShoppingCart() {
        shoppingCart = new ShoppingCart(pricingService);
    }
    @Before
    public void setUp() {
        when(pricingService.priceForItem(anyLong())).thenReturn(BigDecimal.valueOf(0));
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
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //When

        shoppingCart.add(Items.BILAR);
        //Then
        assertEquals(1, shoppingCart.getNumberOfItems());
    }
    @Test
    public void empty_shoppingcart_should_have_price_zero(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //then
        assertEquals(BigDecimal.valueOf(0),shoppingCart.getBalance());

    }

    @Test
    public void when_adding_one_item_shoppingcart_should_have_nonzero_balance(){
        //Given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        when(pricingService.priceForItem(anyLong())).thenReturn(BigDecimal.valueOf(1000));
        //When
        shoppingCart.add(Items.BILAR);
        //Then
        assertEquals(BigDecimal.valueOf(1000), shoppingCart.getBalance());
    }

    @Test
    public void prices_should_be_looked_up_in_database() {
        givenEmptyShoppingCart();
        //When
        shoppingCart.add(Items.BILAR);

        //Then
        Mockito.verify(pricingService).priceForItem(Items.BILAR.getItemId());
        Mockito.verify(pricingService,never()).priceForItem(Items.BRUN_BANAN.getItemId());
        Mockito.verifyNoMoreInteractions(pricingService);
    }

    @Test
    public void empty_shoppingcart_should_return_empty_collection() {
        //Given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        //Then
        Assertions.assertThat(shoppingCart.getItems()).isEmpty();
    }

    @Test
    @Ignore
    public void when_adding_two_items_shoppingcart_should_have_nonzero_nr_items() {
        givenEmptyShoppingCart();
        //when
        shoppingCart.add(Items.BRUN_BANAN);
        shoppingCart.add(Items.JOLT);
        //then
        Assertions.assertThat(shoppingCart.getItems()).containsExactlyInAnyOrder(Items.BRUN_BANAN, Items.JOLT);

    }

}