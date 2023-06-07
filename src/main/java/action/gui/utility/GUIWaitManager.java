package action.gui.utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static utility.config.GUIConfig.elementWait;
import static utility.config.GUIConfig.pollingEvery;

public class GUIWaitManager {
    private static FluentWait<WebDriver> wait;

    private final FluentWait<WebDriver> fluentWait;

    private GUIWaitManager() {
        this.fluentWait = new FluentWait<>(GUIDriverManager.driver())
                .withTimeout(Duration.ofSeconds(elementWait().orElse(30L)))
                .pollingEvery(Duration.ofMillis(pollingEvery().orElse(500L)))
                .ignoring(NoSuchElementException.class);
    }

    public static FluentWait<WebDriver> fluentWait() {
        if (wait == null)
            wait = new GUIWaitManager().fluentWait;

        return wait;
    }

    public static void clearWait() {
        wait = null;
    }
}
