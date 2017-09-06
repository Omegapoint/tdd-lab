package se.omegapoint.academy.basket.items;

import se.omegapoint.academy.basket.Item;

public class Candy implements Item {
    private final String name;

    public Candy(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        return name != null ? name.equals(candy.name) : candy.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                '}';
    }
}
