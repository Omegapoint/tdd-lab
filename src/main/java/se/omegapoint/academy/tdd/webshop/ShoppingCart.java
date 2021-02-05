package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();


    public int returnNumberOfItems(){
        return items.size();
    }

    public void addItem(Item item){
        items.add(item);
    }
    public BigDecimal returnPrice(){
        BigDecimal total = BigDecimal.ZERO;
        for (Item i : items) {
            total = total.add(i.getPrice());
        }
        return total;
    }
}
