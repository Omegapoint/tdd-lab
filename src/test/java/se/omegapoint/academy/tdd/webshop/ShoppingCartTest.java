package se.omegapoint.academy.tdd.webshop;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingCartTest {


    final PricingService pricingService = Mockito.mock(PricingService.class);

    @Before
    public void setUp(){
        Mockito.when(pricingService.priceForItem(Mockito.anyInt())).thenReturn(new BigDecimal(0));
    }

    @Test
    public void shopping_cart_is_empty_when_created(){

        //given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);

        //when
        int numberOfItems = shoppingCart.getAllItems();

        //then
        assertThat(numberOfItems).isEqualTo(0);
    }

    @Test
    public void shopping_cart_has_one_item_when_one_item_is_added(){

        //given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        shoppingCart.addItem(Items.BRUN_BANAN);

        //when
        int numberOfItems = shoppingCart.getAllItems();

        //then
        assertThat(numberOfItems).isEqualTo(1);
    }

    @Test
    public void sum_of_empty_shopping_cart(){

        //given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);

        //when
        BigDecimal sumOfItems = shoppingCart.getSum();

        //then
        assertThat(sumOfItems).isEqualTo(new BigDecimal(0));
    }

    @Test
    public void sum_of_shopping_cart(){

        //given
        Mockito.when(pricingService.priceForItem(Mockito.anyInt())).thenReturn(new BigDecimal(7));

        ShoppingCart shoppingCart = new ShoppingCart(pricingService);
        shoppingCart.addItem(Items.BRUN_BANAN);
        //when
        BigDecimal sumOfItems = shoppingCart.getSum();

        //then
        assertThat(sumOfItems).isEqualTo(new BigDecimal(7));
    }
    @Test
    public void shopping_cart_calls_pricing_service(){

        //given
        ShoppingCart shoppingCart = new ShoppingCart(pricingService);

        //when
        shoppingCart.addItem(Items.KEXCHOKLAD);

        //then
        Mockito.verify(pricingService).priceForItem(Items.KEXCHOKLAD.getItemId());
    }

}
