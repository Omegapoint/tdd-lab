package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import se.omegapoint.academy.tdd.webshop.Items;
import se.omegapoint.academy.tdd.webshop.PriceDatabase;
import se.omegapoint.academy.tdd.webshop.ShoppingCart;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {

    @Mock
    private PriceDatabase database;

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
        return new ShoppingCart(database);
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
        Mockito.when(database.priceForItem(Items.BILAR.getItemId())).thenReturn(Items.BILAR.getPrice());

        //When
        cart.addItem(Items.BILAR);

        //Then
        assertThat(cart.getTotalPrice()).isEqualTo(Items.BILAR.getPrice());
    }

    @Test
    public void priceIsRightForTwoItems(){
        //Given
        ShoppingCart cart = getEmptyCart();
        Mockito.when(database.priceForItem(Items.BILAR.getItemId())).thenReturn(Items.BILAR.getPrice());
        Mockito.when(database.priceForItem(Items.BRUN_BANAN.getItemId())).thenReturn(Items.BRUN_BANAN.getPrice());


        //When
        cart.addItem(Items.BILAR);
        cart.addItem(Items.BRUN_BANAN);
        //Then
        assertThat(cart.getTotalPrice()).isEqualTo(Items.BILAR.getPrice().add(Items.BRUN_BANAN.getPrice()));

    }

    @Test
    public void correctCallToDBService() {

        //Given
        ShoppingCart cart = getEmptyCart();
        cart.addItem(Items.BRUN_BANAN);
        //When
        Mockito.when(database.priceForItem(Items.BRUN_BANAN.getItemId())).thenReturn(Items.BRUN_BANAN.getPrice());
        cart.getTotalPrice();
        //Then
        Mockito.verify(database).priceForItem(Items.BRUN_BANAN.getItemId());
    }


}
