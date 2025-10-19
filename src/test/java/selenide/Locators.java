package selenide;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private static Properties props;

    static {
        props = new Properties();

        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load locators.properties", e);
        }
    }

    public static By getLocator(String elementName) throws Exception {


        String[] locator = props.getProperty(elementName).split("=", 2);
        if (locator.length != 2)  {
            throw new IllegalArgumentException("Invalid locator format for: " + elementName);
        }

        return switch(locator[0]) {
            case "name" -> By.name(locator[1]);
            case "css" -> By.cssSelector(locator[1]);
            case "linkText" -> By.linkText(locator[1]);
            case "tagName" ->By.tagName(locator[1]);
            case "className" ->By.className(locator[1]);
            case "xpath" ->By.xpath(locator[1]);
            case "id" ->By.id(locator[1]);

            default -> throw new Exception("No such locator type" + locator[0]);
        };

    }
}
