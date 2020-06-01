package ru.job4j.ood.srp.reports;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Class is generate report to HR
 *
 * @author Денис Висков
 * @version 1.0
 * @since 01.06.2020
 */
public class ReportForHR implements Report<String> {
    /**
     * Store
     */
    private final Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    /**
     * Method return report to HR
     *
     * @param filter - filter
     * @return - report
     */
    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;" + System.lineSeparator());
        List<Employer> sorted = store.findBy(filter);
        Collections.sort(sorted, getComparator());
        for (Employer employer : sorted) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";" + System.lineSeparator());
        }
        return text.toString();
    }

    /**
     * Method return new Comparator by Employer
     *
     * @return - comparator
     */
    private Comparator<Employer> getComparator() {
        return new Comparator<Employer>() {
            @Override
            public int compare(Employer o1, Employer o2) {
                return o2.compareTo(o1);
            }
        };
    }
}
