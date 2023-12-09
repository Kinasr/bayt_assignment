package assertion.helper;

import assertion.AssertionExecutor;

public class AssertionHelper {

    private AssertionHelper() {}

    public static AssertionExecutor defineExecutor(AssertionExecutor executor, AssertionRecord assertion) {
        return executor != null ? executor.addAssertion(assertion) : new AssertionExecutor(assertion);
    }
}
