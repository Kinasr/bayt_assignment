package assertion;

import assertion.helper.AssertionRecord;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AssertionExecutor {
    private final List<AssertionRecord> assertionList;

    public AssertionExecutor(AssertionRecord assertion) {
        this.assertionList = new ArrayList<>();
        this.assertionList.add(assertion);
    }

    public AssertionExecutor addAssertion(AssertionRecord assertion) {
        assertionList.add(assertion);
        return this;
    }

    public Assertions and() {
        return new Assertions(this);
    }

    public AssertionExecutor withMessage(String message) {
        assertionList.get(assertionList.size() - 1).userMassage(message);
        return this;
    }

    public void perform() {
        assertionList.forEach(assertion -> {
            if (Boolean.TRUE.equals(assertion.test()))
                log.info(assertion.userMassage() != null ?
                        assertion.userMassage() :
                        assertion.massage().getSuccessAssertionMsg());
            else {
                if (assertion.userMassage() != null)
                    log.error(assertion.userMassage());

                throw new AssertionError(assertion.massage().getErrorAssertionMsg());
            }
        });
    }
}
