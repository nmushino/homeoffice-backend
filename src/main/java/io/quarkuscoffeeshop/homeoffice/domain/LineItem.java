package io.quarkuscoffeeshop.homeoffice.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name="LineItems")
public class LineItem extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    private Item item;

    private BigDecimal price;

    private String preparedBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    Order order;

    public LineItem() {
    }

    public LineItem(Item item, BigDecimal price, String preparedBy) {
        this.item = item;
        this.price = price;
        this.preparedBy = preparedBy;
    }

    public LineItem(Item item, BigDecimal price, String preparedBy, Order order) {
        this.item = item;
        this.price = price;
        this.preparedBy = preparedBy;
        this.order = order;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LineItem.class.getSimpleName() + "[", "]")
                .add("item=" + item)
                .add("price=" + price)
                .add("preparedBy='" + preparedBy + "'")
                .add("id=" + id)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineItem lineItem = (LineItem) o;

        if (item != lineItem.item) return false;
        if (price != null ? !price.equals(lineItem.price) : lineItem.price != null) return false;
        if (preparedBy != null ? !preparedBy.equals(lineItem.preparedBy) : lineItem.preparedBy != null) return false;
        return order != null ? order.equals(lineItem.order) : lineItem.order == null;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (preparedBy != null ? preparedBy.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
