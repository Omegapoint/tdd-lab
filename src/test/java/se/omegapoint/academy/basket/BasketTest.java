package se.omegapoint.academy.basket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import se.omegapoint.academy.basket.items.Candy;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BasketTest {

    private Basket basket;
    @Mock
    private Logger logger;

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
        givenEmptyBasket();
        Candy candy = new Candy("Kexchoklad");

        whenAddingCandy(candy);

        thenBasketSizeIs(1);
    }

    private void whenAddingCandy(Candy candy) {
        basket.addCandy(candy);
    }

    @Test
    public void basket_contains_correct_candy() {
        givenEmptyBasket();
        Candy candy = new Candy("Marabou 200g!");

        whenAddingCandy(candy);

        assertThat(basket.contains(candy)).isTrue();
    }


    @Test
    public void basket_does_not_contains_unadded_candy() {
        givenEmptyBasket();
        Candy candy = new Candy("Testchoklad");

        assertThat(basket.contains(candy)).isFalse();
    }
    @Test
    public void candy_has_been_logged() {
        givenEmptyBasket();
        Candy candy = new Candy("Japp");

        whenAddingCandy(candy);

        Mockito.verify(logger).add(candy);
    }




    private void givenEmptyBasket() {
        basket = new Basket(logger);
    }




}