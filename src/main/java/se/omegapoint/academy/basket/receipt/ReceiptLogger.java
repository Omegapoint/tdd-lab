package se.omegapoint.academy.basket.receipt;

import se.omegapoint.academy.basket.Item;
import se.omegapoint.academy.basket.Logger;

import java.util.ArrayList;
import java.util.List;

public class ReceiptLogger implements Logger {
    public List<Item> addedItems = new ArrayList<>();
    InnerClass innerClass  = new InnerClass();

    public class InnerClass {
        public InnerClass(){
            System.out.println("InnerClassConstructor");
        }
    }
    public ReceiptLogger(){
        System.out.println("Receiptloggerkonstruktor");
        InnerClass innerClass  = new InnerClass();
    }
    public void add(final Item item) {
        executeSomeReallyExpensiveStuff();
        addedItems.add(item);
    }

    @Override
    public void remove(final Item item) {
        executeSomeReallyExpensiveStuff();
    }

    private void executeSomeReallyExpensiveStuff() {
        try {
            Thread.sleep(5000); // Simulates a really poor and slow implementation
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
