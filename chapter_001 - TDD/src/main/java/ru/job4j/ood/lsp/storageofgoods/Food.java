package ru.job4j.ood.lsp.storageofgoods;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class is a abstract food
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public abstract class Food {
    /**
     * Name
     */
    private final String name;

    /**
     * Created date
     */
    private final LocalDateTime createDate;

    /**
     * Expired date
     */
    private final LocalDateTime expireDate;

    /**
     * Price
     */
    private final BigDecimal price;

    /**
     * Discount
     */
    private BigDecimal discount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expireDate, BigDecimal price, BigDecimal discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expireDate, food.expireDate)
                && Objects.equals(price, food.price)
                && Objects.equals(discount, food.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expireDate, price, discount);
    }
}
