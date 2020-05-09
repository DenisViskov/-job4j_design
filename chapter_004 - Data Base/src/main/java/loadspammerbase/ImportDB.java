package loadspammerbase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class has realizes import to DB spammers from file
 *
 * @author Денис Висков
 * @version 1.0
 * @since 09.05.2020
 */
public class ImportDB {
    /**
     * Config properties
     */
    private Properties cfg;

    /**
     * File path
     */
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Method has realizes import spammers from file
     *
     * @return - List of spammers
     * @throws IOException
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            while (rd.ready()) {
                String[] split = rd.readLine().split(";");
                users.add(new User(split[0], split[1]));
            }
        }
        return users;
    }

    /**
     * Method has realizes save imported spammers to Data base
     *
     * @param users - List of spammers
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name,email) values (?,?) ")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    /**
     * Inner class User is data class about users
     */
    private static class User {
        /**
         * Name
         */
        String name;
        /**
         * Email
         */
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./chapter_004 - Data Base/src/main/resources/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./chapter_004 - Data Base/src/main/resources/dump.txt");
        db.save(db.load());
    }
}
