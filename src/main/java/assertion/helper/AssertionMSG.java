package assertion.helper;

public record AssertionMSG(Object actual, Object expected, String operation) {

    public String getSuccessAssertionMsg() {
        return "Asserting that: <" + actual + "> is " + operation + (expected != null ? " <" + expected + ">" : "");
    }

    public String getErrorAssertionMsg() {
        return "Actual: <" + actual + "> " + (expected != null ?
                "Expected: " + operation + " <" + expected + ">" :
                "is " + operation);
    }
}
