package ch.hslu.ad.sw02.stack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackArrayTest {
    @Test
    public void newEmptyStackTest() {
        StackArray result = new StackArray(1);

        assertThat(result.isEmpty()).isTrue();
    }
        

    @Test
    public void addOneElementToStack() {
        StackArray testStack  = new StackArray(1);

        testStack.push("Ein Element");

        assertThat(testStack.isEmpty()).isFalse();
    }

    @Test
    public void pushTillFullTest() {
        StackArray testStack = new StackArray(1);

        testStack.push("first");

        assertThat(testStack.size()).isOne();
        assertThat(testStack.isFull()).isTrue();
    }

    @Test
    public void overflowStackTest() {
        StackArray testStack = new StackArray(0);

        Exception result = assertThrows(IllegalArgumentException.class, () -> testStack.push("element"));

        assertThat(result.getMessage()).isEqualTo("Stack ist voll");
    }

    @Test
    public void popEmptyStack() {

        StackArray result = new StackArray(1);

        assertThatIllegalArgumentException().isThrownBy(() -> result.pop());
    }
        
}
