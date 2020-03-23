package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenWeCreateReportForProgrammers() {

    }

    @Test
    public void whenWeCreateReportForAccountant() {

    }

    @Test
    public void whenWeCreateReportForHR() {

    }
}