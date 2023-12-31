package action.gui.utility;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Predicate;

import static action.gui.utility.GUIWaitManager.fluentWait;

@Slf4j
public class GUIWait {

    private GUIWait() {
    }

    public static WebElement waitForElementPresence(By by) {
        log.debug("Waiting for <{}> to be presence", by);
        return fluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElementToBeClickable(By by) {
        var e = waitForElementPresence(by);

        log.debug("Waiting for <{}> to be clickable", by);
        return fluentWait().until(ExpectedConditions.elementToBeClickable(e));
    }

    public static WebElement waitForElementToBeVisible(By by) {
        var e = waitForElementPresence(by);

        log.debug("Waiting for <{}> to be visible", by);
        return fluentWait().until(ExpectedConditions.visibilityOf(e));
    }

    public static WebElement waitForElementToBeVisible(WebElement element) {
        log.debug("Waiting for <{}> to be visible", element);
        return fluentWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitFor(Predicate<WebDriver> condition) {
        log.debug("Waiting for custom condition");
        fluentWait().until(condition::test);
    }
}
