package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface of Store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.03.2020
 */
public interface Store {
    
    /**
     * Method should realizes looking for Employer by given predicate
     *
     * @param filter - filter
     * @return - employer
     */
    List<Employer> findBy(Predicate<Employer> filter);
}
