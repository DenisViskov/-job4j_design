package io.readfileconfig;

import io.readfileconfig.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() throws IOException {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithComment() throws IOException {
        String path = "./data/pairs_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }
}