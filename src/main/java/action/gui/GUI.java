package action.gui;

import action.gui.element_action.GUIElementAction;
import action.gui.utility.GUIDriverManager;
import action.gui.utility.GUIWaitManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import utility.exception.ConfigurationException;

import static action.gui.utility.GUIDriverManager.driver;
import static utility.config.GUIConfig.baseURL;

@Slf4j
public class GUI {
    private GUI() {
    }

    public static void open() {
        open(baseURL().orElseThrow(() -> {
            throw new ConfigurationException("Please provide a base URL at the configuration file " +
                    "or use the open(String) method");
        }));
    }

    public static void open(String url) {
        log.info("Navigating to " + url);
        driver().get(url);
    }

    public static GUIElementAction element(By by) {
        return new GUIElementAction(driver(), by);
    }

    public static void quit() {
        GUIDriverManager.quit();
        GUIWaitManager.clearWait();
    }
}
