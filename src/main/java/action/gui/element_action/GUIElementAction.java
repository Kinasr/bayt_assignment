package action.gui.element_action;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static action.gui.utility.GUIWait.*;

@Slf4j
public class GUIElementAction {
    private final WebDriver driver;
    private final By by;

    public GUIElementAction(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    public GUIElementAction click() {
        log.info("Clicking on <{}>", by);
        waitForElementToBeClickable(by)
                .click();
        return this;
    }

    public GUIElementAction type(String text) {
        log.info("Typing {} in <{}>", text, by);
        waitForElementToBeVisible(by)
                .sendKeys(text);
        return this;
    }

    public ElementTextAction text() {
        log.info("Getting text from <{}>", by);
        return new ElementTextAction(
                waitForElementPresence(by).getText()
        );
    }
}
