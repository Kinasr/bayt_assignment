package utility;

import org.openqa.selenium.By;

@FunctionalInterface
public interface ToByFunction {

    By toBy(String locator);
}
