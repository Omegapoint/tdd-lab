package se.omegapoint.academy.basket.receipt;

import se.omegapoint.academy.basket.Item;
import se.omegapoint.academy.basket.Logger;

public class ReceiptLogger implements Logger {

    public void add(final Item item) {
        executeSomeReallyExpensiveStuff();
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
