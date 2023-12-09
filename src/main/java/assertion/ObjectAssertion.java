package assertion;

import assertion.helper.AssertionMSG;
import assertion.helper.AssertionRecord;

import java.util.Objects;

import static assertion.helper.AssertionHelper.defineExecutor;

public class ObjectAssertion<T> {
    protected final T actual;
    protected final AssertionExecutor executor;

    public ObjectAssertion(T actual) {
        this.actual = actual;
        this.executor = null;
    }

    public ObjectAssertion(T actual, AssertionExecutor executor) {
        this.actual = actual;
        this.executor = executor;
    }

    public AssertionExecutor isNull() {
        return defineExecutor(executor, new AssertionRecord(
                actual, null,
                () -> Objects.isNull(actual),
                "Null"
        ));
    }

    public AssertionExecutor isNotNull() {
        return defineExecutor(executor, new AssertionRecord(
                actual, null,
                () -> !Objects.isNull(actual),
                "Not Null"
        ));
    }

    public AssertionExecutor isEqualTo(T expected) {
        return defineExecutor(executor, new AssertionRecord(
                actual, expected,
                () -> Objects.equals(actual, expected),
                "Equal To"
        ));
    }

    public AssertionExecutor isNotEqualTo(T expected) {
        return defineExecutor(executor, new AssertionRecord(
                actual, expected,
                () -> !Objects.equals(actual, expected),
                "Not Equal To"
        ));
    }
}
