package ru.job4j.ood.srp.reports;

import java.util.function.Predicate;

/**
 * Class is generate report to accountant
 *
 * @author Денис Висков
 * @version 1.0
 * @since 01.06.2020
 */
public class ReportForAccountant implements Report<String> {
    /**
     * Store
     */
    private final Store store;

    public ReportForAccountant(Store store) {
        this.store = store;
    }

    /**
     * Method generate report to accountant with rounded salary
     *
     * @param filter - filter
     * @return - report
     */
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;" + System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(Math.round(employer.getSalary())).append(";" + System.lineSeparator());
        }
        return text.toString();
    }
}
