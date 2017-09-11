package se.omegapoint.academy.basket.items;

import se.omegapoint.academy.basket.Item;

public class Magazine implements Item {
    private String magazineName;
    public Magazine(final String name) {
        magazineName = name;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "magazineName='" + magazineName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Magazine magazine = (Magazine) o;

        return magazineName != null ? magazineName.equals(magazine.magazineName) : magazine.magazineName == null;
    }

    @Override
    public int hashCode() {
        return magazineName != null ? magazineName.hashCode() : 0;
    }
}
