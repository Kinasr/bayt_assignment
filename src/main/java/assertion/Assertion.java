package assertion;

import org.openqa.selenium.By;

public class Assertion {

    private Assertion() {
    }

    public static ObjectAssertion<Object> assertThat(Object actual) {
        return new ObjectAssertion<>(actual);
    }

    public static TextAssertion assertThat(String actual) {
        return new TextAssertion(actual);
    }

    public static GUIElementAssertion assertThat(By by) {
        return new GUIElementAssertion(by);
    }
}
