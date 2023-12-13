package se.omegapoint.academy.tdd.webshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingCartWithPricingServiceTest {

    final PricingService pricingService = mock(PricingService.class);
    final ShoppingCartWithPricingService shoppingCart = new ShoppingCartWithPricingService(pricingService);

    @Test
    void givenNoItemsShouldReturnZeroPrice() {
        Assertions.assertEquals(BigDecimal.ZERO, shoppingCart.getCombinedPrice());
    }

    @Test
    void givenItemsShouldReturnPrice() {
        shoppingCart.add(Items.KEXCHOKLAD);
        shoppingCart.add(Items.JOLT);

        given(pricingService.priceForItem(Items.KEXCHOKLAD.getItemId())).willReturn(Items.KEXCHOKLAD.getPrice());
        given(pricingService.priceForItem(Items.JOLT.getItemId())).willReturn(Items.JOLT.getPrice());
        BigDecimal expected = Items.KEXCHOKLAD.getPrice().add(Items.JOLT.getPrice());


        Assertions.assertEquals(expected, shoppingCart.getCombinedPrice());

        verify(pricingService).priceForItem(Items.KEXCHOKLAD.getItemId());
        verify(pricingService).priceForItem(Items.JOLT.getItemId());
    }

}
