package action.gui.element_action;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.function.Consumer;

import static action.gui.utility.GUIWait.*;

@SuppressWarnings("UnusedReturnValue")
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

    public GUIElementAction upload(String filePath) {
        log.info("Uploading {} in <{}>", filePath, by);
        waitForElementPresence(by)
                .sendKeys(Paths.get("").toAbsolutePath() + "/" + filePath);
        return this;
    }

    public GUIElementAction selectByVisibleText(String text) {
        log.info("Selecting {} in <{}>", text, by);
        new Select(waitForElementPresence(by))
                .selectByVisibleText(text);

        return this;
    }

    public GUIElementAction scrollTo() {
        log.info("Scrolling to <{}>", by);

        var element = waitForElementToBeVisible(by);
        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].setAttribute('isScrolling', 'false');" +
//                "window.onscroll = () => arguments[0].setAttribute('isScrolling', 'true');" +
//                "window.onscrollend = () => arguments[0].setAttribute('isScrolling', 'false');" +
                "arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'nearest' });", element);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        GUIWait.waitFor(driver -> {
//            var att = element.getAttribute("isScrolling");
//            return att == null || att.equals("false");
//        });

        return this;
    }

    public GUIElementAction wait(Consumer<By> waitFor) {
        waitFor.accept(by);
        return this;
    }

    public ElementTextAction text() {
        log.info("Getting text from <{}>", by);
        return new ElementTextAction(
                waitForElementPresence(by).getText()
        );
    }
}
