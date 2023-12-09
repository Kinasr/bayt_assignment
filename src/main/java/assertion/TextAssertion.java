package assertion;

import assertion.helper.AssertionRecord;

import static assertion.helper.AssertionHelper.defineExecutor;

public class TextAssertion extends ObjectAssertion<String> {

    public TextAssertion(String actual) {
        super(actual);
    }

    public TextAssertion(String actual, AssertionExecutor executor) {
        super(actual, executor);
    }

    public AssertionExecutor isContain(String expected) {
        return defineExecutor(executor, new AssertionRecord(
                actual, expected,
                () -> actual.contains(expected),
                "Contain"
        ));
    }

    public AssertionExecutor isNotContain(String expected) {
        return defineExecutor(executor, new AssertionRecord(
                actual, expected,
                () -> !actual.contains(expected),
                "Not Contain"
        ));
    }

    public AssertionExecutor isIn(String expected) {
        return defineExecutor(executor, new AssertionRecord(
                actual, expected,
                () -> expected.contains(actual),
                "In"
        ));
    }

    public AssertionExecutor isNotIn(String expected) {
        return defineExecutor(executor, new AssertionRecord(
                actual, expected,
                () -> !expected.contains(actual),
                "Not In"
        ));
    }
}
