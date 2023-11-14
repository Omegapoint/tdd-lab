package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toUnmodifiableList;

public class ShoppingCart {
    private final List<Item> items;

    public ShoppingCart() {
        this(List.of());
    }

    public ShoppingCart(final List<Item> items) {
        this.items = items;
    }

    public ShoppingCart addItem(final Item itemToAdd) {
        return Stream.concat(items.stream(), Stream.of(itemToAdd))
                .collect(collectingAndThen(toUnmodifiableList(), ShoppingCart::new));
    }

    public int numberOfItems() {
        return items.size();
    }

    public double priceOfCart() {
        return items.stream()
                .map(Item::getPrice)
                .mapToLong(BigDecimal::longValue)
                .sum();
    }

    public String receipt() {
        return IntStream.rangeClosed(1, items.size())
                .mapToObj(index -> {
                    final Item item = items.get(index - 1);
                    return "%d. %s, %s SEK".formatted(index, item.getName(), item.getPrice().toPlainString());
                }).collect(Collectors.joining("\n", "Receipt:\n", ""));
    }
}
