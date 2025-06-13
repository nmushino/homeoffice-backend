package io.quarkuscoffeeshop.homeoffice.domain;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Item {
    // Beverages
    CAPPUCCINO(3.50), COFFEE_BLACK(3.00), COFFEE_WITH_ROOM(3.00),
    ESPRESSO(3.75), ESPRESSO_DOUBLE(4.75), LATTE(3.75),

    // Food
    CAKEPOP(2.50), CROISSANT(3.25), MUFFIN(3.00), CROISSANT_CHOCOLATE(3.50);

    private final BigDecimal price;

    Item(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    @JsonCreator
    public static Item fromString(String key) {
        return key == null ? null : Item.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}