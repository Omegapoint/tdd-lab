package se.omegapoint.academy.tdd.webshop;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {
    PricingService mockPricingService;
    ShoppingCart shoppingCart;

    @Before
    public void setup () {
        mockPricingService = Mockito.mock(PricingService.class);
        shoppingCart = new ShoppingCart(mockPricingService);
        Mockito.when(mockPricingService.priceForItem(Items.KEXCHOKLAD.getItemId())).thenReturn(Items.KEXCHOKLAD.getPrice());
    }
    @Test
    public void numberOfItemsInCart ()
    {
        //Given

        //When
        shoppingCart.addToCart(Items.KEXCHOKLAD);


        //Then
        assertThat(shoppingCart.getNumberOfItems()).isEqualTo(1);
        Mockito.verify(mockPricingService).priceForItem(Items.KEXCHOKLAD.getItemId());

    }

    @Test
    public void totalPrice ()
    {
        //Given

        //When
        shoppingCart.addToCart(Items.KEXCHOKLAD);
        //Then
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(Items.KEXCHOKLAD.getPrice());
    }

    @Test
    public void fullList ()
    {
        //Given
        Collection<Item> expectedItemsInCart = new ArrayList<>();
        expectedItemsInCart.add(Items.KEXCHOKLAD);

        //When
        shoppingCart.addToCart(Items.KEXCHOKLAD);

        //Then
        assertThat(shoppingCart.getItems().equals(expectedItemsInCart)).isTrue();

    }
}
