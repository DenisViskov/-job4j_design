package ru.job4j.ood.lsp.storageofgoods;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.*;

/**
 * Class is a control quality of goods
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.06.2020
 */
public class ControlQuality implements Control<Food, Storage> {

    /**
     * Method execute distribution good to necessary storage
     *
     * @param good - good
     * @return - storage
     */
    @Override
    public Storage executeDistribution(Food good) {
        Storage storage = checkExpire(good);
        storage.add(good);
        return storage;
    }

    /**
     * Method execute resort goods from store to new store
     *
     * @param storage
     * @return list
     */
    @Override
    public List<Storage> resort(List<Storage> storage) {
        return (List<Storage>) storage.stream()
                .flatMap(store -> store.getAll().stream())
                .map(good -> executeDistribution((Food) good))
                .collect(Collectors.toList());
    }

    /**
     * Method checking expire date by good and return necessary storage
     *
     * @param good - good
     * @return - necessary storage
     */
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

    /**
     * Method checking good by given dates on conformity
     *
     * @param created - created
     * @param expired - expired
     * @return - boolean answer
     */
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

    /**
     * Method checking good by given dates on necessary set discount
     *
     * @param created - created
     * @param expired - expired
     * @return - boolean answer
     */
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

    /**
     * Method returns new price by given percent of discount
     *
     * @param percent - percent
     * @param price   - price
     * @return - New BigDecimal price
     */
    private BigDecimal getDiscountPrice(int percent, BigDecimal price) {
        return price
                .subtract(price
                        .multiply(BigDecimal
                                .valueOf((double) percent / 100)));
    }

    /**
     * Method checking good on trash
     *
     * @param expired - expire date
     * @return - boolean answer
     */
    private boolean isTrash(LocalDateTime expired) {
        return DAYS.between(LocalDateTime.now(), expired) < 0 ? true : false;
    }
}
