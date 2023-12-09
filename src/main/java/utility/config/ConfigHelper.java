package utility.config;

import kinasr.nsr_yaml.exception.InvalidKeyException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class ConfigHelper {

    private ConfigHelper() {
    }

    protected static <T> Optional<T> fetchData(@NotNull ConfigRecord<T> config,
                                               @NotNull Function<String, T> reader) {

        if (Boolean.FALSE.equals(config.isFetched())) {
            try {
                config.value(reader.apply(config.key()));
                config.isExist(true);
            } catch (InvalidKeyException e) {
                log.info("The {} key is not configured in the configuration file", config.key());
            } finally {
                config.isFetched(true);
            }
        }

        return Optional.ofNullable(config.value());
    }
}
