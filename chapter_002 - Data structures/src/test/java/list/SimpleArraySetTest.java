package list;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleArraySetTest {

    @Test
    public void addTest() {
        SimpleArraySet<Integer> set = new SimpleArraySet<>();
        List<Integer> out = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(2);
        for (Integer element : set) {
            if (element != null) {
                out.add(element);
            }
        }
        Assert.assertThat(List.of(1, 2), Is.is(out));
    }
}