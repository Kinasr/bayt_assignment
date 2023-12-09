package assertion;

import action.gui.utility.GUIWait;
import assertion.helper.AssertionRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import static assertion.helper.AssertionHelper.defineExecutor;

public class GUIElementAssertion extends ObjectAssertion<By> {
    public GUIElementAssertion(By actual) {
        super(actual);
    }

    public GUIElementAssertion(By actual, AssertionExecutor executor) {
        super(actual, executor);
    }

    public AssertionExecutor isDisplayed() {
        return defineExecutor(executor, new AssertionRecord(
                actual, null,
                () -> GUIWait.waitForElementToBeVisible(actual)
                        .isDisplayed(),
                "Displayed"
        ));
    }

    public AssertionExecutor isPresence() {
        return defineExecutor(executor, new AssertionRecord(
                actual, null,
                () -> {
                    try {
                        GUIWait.waitForElementPresence(actual);
                        return true;
                    } catch (TimeoutException e) {
                        return false;
                    }
                },
                "Presence"
        ));
    }
}
