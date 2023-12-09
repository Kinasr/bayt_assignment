package action.gui.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.config.GUIConfig;
import utility.exception.ConfigurationException;

import java.time.Duration;
import java.util.List;

@Slf4j
public class GUIDriverManager {
    private static WebDriver driver;

    private final WebDriver wd;

    private GUIDriverManager() {
        wd = loadDriver();
    }

    public static WebDriver driver() {
        if (driver == null)
            driver = new GUIDriverManager().wd;

        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    private WebDriver loadDriver() {
        var browser = GUIConfig.browser().orElseThrow(() -> {
            throw new ConfigurationException("The browser should be provided at the config file");
        });

        WebDriver loadedDriver;

        switch (browser.toLowerCase()) {
            case "chrome" -> loadedDriver = loadChrome();
            case "firefox" -> loadedDriver = loadFirefox();
            case "edge" -> loadedDriver = loadEdge();
            default -> throw new ConfigurationException("Unsupported browser " + browser +
                    " Chrome is the only supported browser for now");
        }

        return loadedDriver;
    }

    private WebDriver loadChrome() {
        var size = GUIConfig.screenSize().orElse("maximized");

        var options = new ChromeOptions();
        options.setPageLoadStrategy(GUIConfig.pageLoadingStrategy().orElse(PageLoadStrategy.NORMAL))
                .setPageLoadTimeout(Duration.ofSeconds(GUIConfig.pageLoadTimeout().orElse(30L)))
                .addArguments(size.equalsIgnoreCase("maximized") ?
                        "--start-maximized" : "--windows-size=" + size)
                .addArguments(GUIConfig.arguments().orElse(List.of("")));

        GUIConfig.headless().ifPresent(isEnabled -> {
            if (Boolean.TRUE.equals(isEnabled))
                options.addArguments("--headless=new");
        });

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private WebDriver loadFirefox() {
        throw new UnsupportedOperationException("Firefox browser is not supported yet");
    }

    private WebDriver loadEdge() {
        throw new UnsupportedOperationException("Edge browser is not supported yet");
    }
}
