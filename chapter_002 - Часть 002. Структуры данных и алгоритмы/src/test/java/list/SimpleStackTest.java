package list;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SimpleStackTest {

    @Test
    public void pollTest() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        Assert.assertThat(simpleStack.poll(), is(3));
        Assert.assertThat(simpleStack.poll(), is(2));
        Assert.assertThat(simpleStack.poll(), is(1));
    }

    @Test
    public void pushTest() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        Assert.assertThat(simpleStack.poll(), is(3));
    }
}