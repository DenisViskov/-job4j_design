package demonstrationgs;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

/**
 * Class has realizes example work GC
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.06.2020
 */
public class User {
    /**
     * Name
     */
    private final String name;

    /**
     * Age
     */
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        int mb = 1024 * 1024;
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory() / mb);
        System.out.println("Empty user size: " + sizeOf(new User(null, 0)));
        System.out.println("Free Memory: " + Runtime.getRuntime().freeMemory());
        for (int i = 0; i < 5000; i++) {
            sizeOf(new User("name", i));
        }
    }
}
