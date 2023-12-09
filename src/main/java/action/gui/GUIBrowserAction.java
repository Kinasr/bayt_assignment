package action.gui;

import helper.H;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.config.GUIConfig;

import java.util.Set;

import static action.gui.utility.GUIDriverManager.driver;

@Slf4j
public class GUIBrowserAction {
    private final WebDriver driver;

    public GUIBrowserAction(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Set<String> getCurrentTabs() {
        return driver.getWindowHandles();
    }

    public void focusOnNewTab(Set<String> oldTabs) {
        var newTabs = driver.getWindowHandles();

        newTabs.stream().filter(tab -> !oldTabs.contains(tab))
                .findFirst().ifPresentOrElse(
                        tab -> {
                            log.info("Switching to the new tab " + tab);
                            driver.switchTo().window(tab);
                        },
                        () -> {
                            log.warn("No new tab found");
                        }
                );
    }


    public void screenshot() {
        var screenshot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);

        if (GUIConfig.screenshotAutoSave()) {
            log.info("Saving screenshot to " + GUIConfig.screenshotSaveLocation());
            H.saveByteArray(screenshot, GUIConfig.screenshotSaveLocation(),
                    getTitle() + "_" + H.timestamp() + ".png");
        }
    }
}
