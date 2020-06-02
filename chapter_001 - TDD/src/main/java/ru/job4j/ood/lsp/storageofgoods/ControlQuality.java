package ru.job4j.ood.lsp.storageofgoods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class ControlQuality implements Control<Food, Storage> {

    @Override
    public Storage executeDistribution(Food good) {
        sendToWareHouse(good.getCreateDate(), good.getExpireDate());
        return null;
    }

    private Storage checkExpire(Food good) {
        return null;
    }

    private boolean sendToWareHouse(LocalDateTime created, LocalDateTime expired) {
        boolean result = false;
        int hundredPercent = Period
                .between(expired.toLocalDate(),
                        created.toLocalDate())
                .getDays();
        int daysOFPassed = Period
                .between(LocalDate.now(),
                        created.toLocalDate())
                .getDays();
        int maxCountDays = (hundredPercent / 100) * 25;
        if (daysOFPassed < maxCountDays) {
            result = true;
        }
        return result;
    }

}
