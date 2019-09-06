package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class ShoppingCart {

    int counter;
    BigDecimal sum = new BigDecimal(0);

    public int getAllItems() {

        return counter;
    }

    public void addItem(Item brunBanan) {
        counter++;
        sum = sum.add(brunBanan.getPrice());

    }

    public BigDecimal getSum() {
        return sum;
    }
}
