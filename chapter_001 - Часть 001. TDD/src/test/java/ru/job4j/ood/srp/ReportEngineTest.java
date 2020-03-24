package ru.job4j.ood.srp;

import org.junit.Test;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
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
    public void whenWeCreateReportForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportForProgrammers engine = new ReportForProgrammers(store);
        HTMLDocument expected = new HTMLDocument(Path);
        HTMLDocument out = engine.generate(i -> true);
        assertThat(out.toString(),is(expected.toString()));
    }

    @Test
    public void whenWeCreateReportForAccountant() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngineForAccountant engine = new ReportEngine(store);
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
        ReportEngineForHR engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }*/
}