package ru.job4j.ood.tdd.template;

import org.junit.Ignore;
import ru.job4j.ood.tdd.template.Generate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
@Ignore
public class GeneratorTest {

    @Ignore
    public void produceTest() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, Object> keys = new HashMap<>();
        keys.put("name", "Alex");
        keys.put("subject", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String out = new Generate().produce(template, keys);
        assertThat(out, is(expected));
    }

    @Ignore
    public void whenWeHaveKeysWhoHasNotInTemplate() {
        String template = "I am a ${lastName}, Who are ${subject}? ";
        Map<String, Object> keys = new HashMap<>();
        keys.put("name", "Alex");
        keys.put("subject", "you");
        boolean result = false;
        try {
            String out = new Generate().produce(template, keys);
        } catch (Exception e) {
            result = true;
        } finally {
            assertThat(result, is(true));
        }
    }

    @Ignore
    public void whenWeHaveMoreKeys() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, Object> keys = new HashMap<>();
        keys.put("name", "Alex");
        keys.put("subject", "you");
        keys.put("lastName", "Petrov");
        boolean result = false;
        try {
            String out = new Generate().produce(template, keys);
        } catch (Exception e) {
            result = true;
        } finally {
            assertThat(result, is(true));
        }
    }
}