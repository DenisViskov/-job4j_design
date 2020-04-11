package ru.job4j.ood.srp.reports;

import org.junit.Test;
import ru.job4j.ood.srp.reports.Employer;
import ru.job4j.ood.srp.reports.MemStore;
import ru.job4j.ood.srp.reports.ReportEngine;

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

    /*@Test
    public void whenWeCreateReportForProgrammersHTML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportForProgrammers(store);
        Report expected = new HTMLDocument(Path);
        Report out = engine.generate(i -> true);
        assertThat(out.toString(),is(expected.toString()));
    }

    @Test
    public void whenWeCreateReportForAccountant() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngineForAccountant(store);
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
    public void whenWeCreateReportForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngineForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenWeCreateReportByXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportForProgrammers(store);
        Report expected = new XMLReporter(Path);
        Report out = engine.generate(i -> true);
        assertThat(out.toString(),is(expected.toString()));
    }

    @Test
    public void whenWeCreateReportByJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportForProgrammers(store);
        Report expected = new JsonParser(Path);
        Report out = engine.generate(i -> true);
        assertThat(out.toString(),is(expected.toString()));
    }*/
}