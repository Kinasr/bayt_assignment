package assertion.helper;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.function.BooleanSupplier;

@Data
@Accessors(chain = true, fluent = true)
public class AssertionRecord {
    private Object actual;
    private Object expected;
    private BooleanSupplier operation;
    private AssertionMSG massage;
    private String userMassage;

    public AssertionRecord(Object actual, Object expected, BooleanSupplier operation, String operationStr) {
        this.actual = actual;
        this.expected = expected;
        this.operation = operation;
        this.massage = new AssertionMSG(actual, expected, operationStr);
    }

    public Boolean test() {
        return operation.getAsBoolean();
    }
}
