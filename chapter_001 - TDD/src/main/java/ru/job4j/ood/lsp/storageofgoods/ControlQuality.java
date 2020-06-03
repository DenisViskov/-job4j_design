package ru.job4j.ood.lsp.storageofgoods;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.*;

/**
 * Class is a control quality of goods
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class ControlQuality implements Control<Food, Storage> {

    @Override
    public Storage executeDistribution(Food good) {
        Storage storage = checkExpire(good);
        storage.add(good);
        return storage;
    }

    private Storage checkExpire(Food good) {
        if (isTrash(good.getExpireDate())) {
            return new Trash();
        }
        if (sendToWareHouse(good.getCreateDate(), good.getExpireDate())) {
            return new Warehouse();
        }
        if (shouldBeDiscount(good.getCreateDate(), good.getExpireDate())) {
            good.setDiscount(getDiscountPrice(25, good.getPrice()));
        }
        return new Shop();
    }

    private boolean sendToWareHouse(LocalDateTime created, LocalDateTime expired) {
        boolean result = false;
        double hundredPercent = (int) DAYS.between(created, expired);
        double daysOFPassed = (int) DAYS.between(created, LocalDateTime.now());
        double maxCountDays = (hundredPercent / 100) * 25;
        if (Math.round(daysOFPassed) < Math.round(maxCountDays)) {
            result = true;
        }
        return result;
    }

    private boolean shouldBeDiscount(LocalDateTime created, LocalDateTime expired) {
        boolean result = false;
        double hundredPercent = (int) DAYS.between(created, expired);
        double daysOFPassed = (int) DAYS.between(created, LocalDateTime.now());
        double maxCountDays = (hundredPercent / 100) * 75;
        if (Math.round(daysOFPassed) > Math.round(maxCountDays)) {
            result = true;
        }
        return result;
    }

    private BigDecimal getDiscountPrice(int percent, BigDecimal price) {
        return price.subtract(price.multiply(BigDecimal.valueOf((double) percent / 100)));
    }

    private boolean isTrash(LocalDateTime expired) {
        return DAYS.between(LocalDateTime.now(), expired) < 0 ? true : false;
    }

}
