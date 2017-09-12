package se.omegapoint.academy.basket;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import se.omegapoint.academy.basket.items.Candy;
import se.omegapoint.academy.basket.items.Magazine;
import se.omegapoint.academy.basket.receipt.ReceiptLogger;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    ReceiptLogger receiptLogger;
    Basket basket;



    @Before
    public void createMocks(){
        receiptLogger = Mockito.mock(ReceiptLogger.class);
        basket = new Basket(receiptLogger);
    }

    @Test
    public void newBasketEmptyOnCreation(){
        assertThat(basket.isEmpty()).isTrue();

    }

    @Test
    public void basketWithCandyNotEmpty(){
        basket.addCandy("");
        assertThat(basket.isEmpty()).isFalse();
    }

    @Test
    public void addAndCheckIfName(){
        String dumleString = "Dumle";
        basket.addCandy(dumleString);
        assertThat(basket.getItems()).contains(new Candy(dumleString));
    }

    @Test
    public void addAndCheckIfNotName(){
        String dumleString = "Dumle";
        basket.addCandy(dumleString);
        assertThat(basket.getItems()).doesNotContain(new Candy("Twix"));
    }

    @Ignore
    public void wombat(){
        basket.addMagazine("Expressen");
        assertThat(basket.getItems()).contains(new Magazine("Expressen"));
        assertThat(basket.getItems()).doesNotContain(new Magazine("Twix"));
    }

    @Test
    public void addCorrectItemToLogger() {
        basket.addCandy("Choklad");
        basket.addCandy("Choklad");
        Mockito.verify(receiptLogger,Mockito.times(2)).add(new Candy("Choklad"));
    }






}