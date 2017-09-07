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

    @Test
    public void basket_contains_correct_candy() {
        Basket basket = new Basket();
        Candy candy = new Candy("Marabou 200g!");

        basket.addCandy(candy);

        assertThat(basket.contains(candy)).isTrue();
    }

}