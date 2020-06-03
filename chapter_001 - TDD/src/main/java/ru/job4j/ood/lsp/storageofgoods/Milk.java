package ru.job4j.ood.lsp.storageofgoods;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Class is a milk
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class Milk extends Food {

    public Milk(String name, LocalDateTime createDate, LocalDateTime expireDate, BigDecimal price, BigDecimal discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
