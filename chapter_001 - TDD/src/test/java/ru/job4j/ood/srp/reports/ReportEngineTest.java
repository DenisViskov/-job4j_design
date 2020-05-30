package ru.job4j.ood.srp.reports;

import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.stream.Collectors;

import static org.hamcrest.core.StringContains.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ReportEngineTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

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
    public void whenWeCreateReportForProgrammersHTML() throws IOException {
        File file = folder.newFolder();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportForProgrammers(store, Paths.get(file.getAbsolutePath()));
        File out = (File) engine.generate(i -> true);
        assertThat(Files.readAllLines(Paths.get(out.getAbsolutePath()))
                .stream()
                .collect(Collectors.joining()), containsString("Name; Hired; Fired; Salary;"));
    }

    /*@Test
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
        assertThat(out.toString(), is(expected.toString()));
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
        assertThat(out.toString(), is(expected.toString()));
    }*/
}