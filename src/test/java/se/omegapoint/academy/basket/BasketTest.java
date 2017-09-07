package se.omegapoint.academy.basket;

import org.junit.Test;
import se.omegapoint.academy.basket.items.Candy;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    @Test
    public void basket_is_empty_when_new() {
        Basket basket = new Basket();

        assertThat(basket.getNumberOfItems()).isEqualTo(0);
    }


    @Test
    public void basket_has_candy() {
        // Given
        Basket basket = new Basket();
        Candy candy = new Candy("Kexchoklad");

        // When
        basket.addCandy(candy);


        // Then
        assertThat(basket.getNumberOfItems()).isEqualTo(1);
    }

}