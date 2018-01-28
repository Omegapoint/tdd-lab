package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class Item {

    private final long articleId;
    private final String name;
    private final BigDecimal price;

    public Item(long articleId, String name, BigDecimal price) {
        this.articleId = articleId;
        this.name = name;
        this.price = price;
    }

    public long getArticleId() {
        return articleId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
