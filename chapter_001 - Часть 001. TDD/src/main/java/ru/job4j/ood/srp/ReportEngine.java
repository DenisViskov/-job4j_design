package ru.job4j.ood.srp;

import java.util.function.Predicate;

/**
 * Class has realizes report by Employers
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.03.2020
 */
public class ReportEngine {
    /**
     * Store
     */
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    /**
     * Method has realizes generate of report by given predicate in parameters
     *
     * @param filter - filter
     * @return - report
     */
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;" + System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";" + System.lineSeparator());
        }
        return text.toString();
    }
}
