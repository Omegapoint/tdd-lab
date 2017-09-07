package se.omegapoint.academy.basket;

public class ConsoleLogger implements Logger {

    @Override
    public void add(Item item) {
        System.out.println("Added: " + item.toString());
    }

    @Override
    public void remove(Item item) {
        System.out.println("Removed: " + item.toString());
    }
}
