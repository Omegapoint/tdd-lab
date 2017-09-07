package se.omegapoint.academy.basket;

import org.junit.Test;
import se.omegapoint.academy.basket.items.Candy;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    private Basket basket;

    @Test
    public void basket_is_empty_when_new() {
        givenEmptyBasket();

        thenBasketSizeIs(0);
    }

    private void thenBasketSizeIs(int expected) {
        assertThat(basket.getNumberOfItems()).isEqualTo(expected);
    }


    @Test
    public void basket_has_candy() {
        // Given
        givenEmptyBasket();
        Candy candy = new Candy("Kexchoklad");

        // When
        whenAddingCandy(candy);

        // Then
        thenBasketSizeIs(1);
    }

    private void whenAddingCandy(Candy candy) {
        basket.addCandy(candy);
    }

    @Test
    public void basket_contains_correct_candy() {
        // Given
        givenEmptyBasket();
        Candy candy = new Candy("Marabou 200g!");

        // When
        whenAddingCandy(candy);

        // Then
        assertThat(basket.contains(candy)).isTrue();
    }


    @Test
    public void basket_does_not_contains_unadded_candy() {
        // Given
        givenEmptyBasket();
        Candy candy = new Candy("Testchoklad");

        // When

        // Then
        assertThat(basket.contains(candy)).isFalse();
    }

    private void givenEmptyBasket() {
        basket = new Basket();
    }




}