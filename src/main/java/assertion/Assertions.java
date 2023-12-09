package assertion;

import org.openqa.selenium.By;

public class Assertions {
    private final AssertionExecutor executor;

    public Assertions(AssertionExecutor executor) {
        this.executor = executor;
    }

    public ObjectAssertion<Object> assertThat(Object actual) {
        return new ObjectAssertion<>(actual, executor);
    }

    public TextAssertion assertThat(String actual) {
        return new TextAssertion(actual, executor);
    }

    public GUIElementAssertion assertThat(By by) {
        return new GUIElementAssertion(by, executor);
    }
}
