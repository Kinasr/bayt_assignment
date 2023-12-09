package utility.config;

import org.openqa.selenium.PageLoadStrategy;

import java.util.List;
import java.util.Optional;

import static utility.config.ConfigFileLoader.configReader;
import static utility.config.ConfigHelper.fetchData;

public class GUIConfig {
    private static final ConfigRecord<String> browser = new ConfigRecord<>("gui.browser");
    private static final ConfigRecord<String> baseURL = new ConfigRecord<>("gui.base-url");
    private static final ConfigRecord<Boolean> opHeadless = new ConfigRecord<>("gui.options.headless");
    private static final ConfigRecord<String> opScreenSize =
            new ConfigRecord<>("gui.options.screen-size");
    private static final ConfigRecord<PageLoadStrategy> opPageLoadingStrategy =
            new ConfigRecord<>("gui.options.page-Loading-strategy");
    private static final ConfigRecord<List<String>> opArguments =
            new ConfigRecord<>("gui.options.arguments");
    private static final ConfigRecord<Long> tPageLoadTimeout =
            new ConfigRecord<>("gui.timeouts.page-load-timeout");
    private static final ConfigRecord<Long> tElementWait =
            new ConfigRecord<>("gui.timeouts.element-wait");
    private static final ConfigRecord<Long> tPollingEvery =
            new ConfigRecord<>("gui.timeouts.polling-every");

    private GUIConfig() {
    }

    public static Optional<String> browser() {
        return fetchData(browser, key -> configReader().get(key).asString());
    }

    public static Optional<String> baseURL() {
        return fetchData(baseURL, key -> configReader().get(key).asString());
    }

    public static Optional<Boolean> headless() {
        return fetchData(opHeadless, key -> configReader().get(key).asBoolean());
    }

    public static Optional<String> screenSize() {
        return fetchData(opScreenSize, key -> configReader().get(key).asString());
    }

    public static Optional<PageLoadStrategy> pageLoadingStrategy() {
        return fetchData(opPageLoadingStrategy, key -> configReader().get(key).as(PageLoadStrategy.class));
    }

    public static Optional<List<String>> arguments() {
        return fetchData(opArguments, key -> configReader().get(key).asList(String.class));
    }

    public static Optional<Long> pageLoadTimeout() {
        return fetchData(tPageLoadTimeout, key -> configReader().get(key).asLong());
    }

    public static Optional<Long> elementWait() {
        return fetchData(tElementWait, key -> configReader().get(key).asLong());
    }

    public static Optional<Long> pollingEvery() {
        return fetchData(tPollingEvery, key -> configReader().get(key).asLong());
    }
}
