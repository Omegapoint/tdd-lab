package se.omegapoint.academy.tdd.webshop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class ShoppingCartWithPricingServiceTest {
    private final PricingService pricingService = mock(PricingService.class);
    private ShoppingCartWithPricingService cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCartWithPricingService(pricingService);
    }

    @AfterEach
    void no_more_interactions() {
        verifyNoMoreInteractions(pricingService);
    }

    @Test
    void should_use_pricing_service() {
        given(pricingService.priceForItem(Items.BILAR.getItemId())).willReturn(new BigDecimal(10));
        final double price = cart.addItem(Items.BILAR)
                .priceOfCart();
        assertEquals(10, price);
        verify(pricingService).priceForItem(Items.BILAR.getItemId());
    }
}
