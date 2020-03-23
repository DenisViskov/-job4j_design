package ru.job4j.ood.srp;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class has realizes structure of data Employer
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.03.2020
 */
public class Employer {

    /**
     * Name
     */
    private String name;
    /**
     * Hired
     */
    private Calendar hired;
    /**
     * Fired
     */
    private Calendar fired;
    /**
     * Salary
     */
    private double salary;

    public Employer(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(name, employer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
