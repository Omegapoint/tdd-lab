package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;
import se.omegapoint.academy.tdd.webshop.Items;
import se.omegapoint.academy.tdd.webshop.ShoppingCart;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    @Before
    public void setUpCart() {

    }

    @Test
    public void checkCartEmpty() {
        assertThat(getEmptyCart()).isNotNull();
    }

    @Test
    public void cartShouldBeEmpty() {
        ShoppingCart cart = getEmptyCart();
        assertThat(cart.getNumberOfItems()).isEqualTo(0);
    }

    private ShoppingCart getEmptyCart() {
        return new ShoppingCart();
    }

    @Test
    public void addItemToCart() {
        ShoppingCart cart  = getEmptyCart();
        cart.addItem(Items.BILAR);
        assertThat(cart.getNumberOfItems()).isEqualTo(1);
    }

    @Test
    public void priceOfItemsIsZeroInEmptyCart() {
        ShoppingCart cart = getEmptyCart();
        assertThat(cart.getTotalPrice()).isZero();
    }

    @Test
    public void priceIsRightOfItem(){
        //Given
        ShoppingCart cart  = getEmptyCart();

        //When
        cart.addItem(Items.BILAR);

        //Then
        assertThat(cart.getTotalPrice()).isEqualTo(Items.BILAR.getPrice());
    }
}
