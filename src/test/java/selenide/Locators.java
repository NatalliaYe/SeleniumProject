package selenide;

import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = Locators.class.getResourceAsStream("/locators.properties")) {
            if (is == null) {
                throw new FileNotFoundException("locators.properties not found in resources/");
            }
            props.load(is);
            System.out.println("locators.properties successfully loaded.");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load locators.properties", e);
        }
    }

    public static By getLocator(String elementName) {
        String value = props.getProperty(elementName);

        if (value == null) {
            throw new IllegalArgumentException("Locator not found for key: " + elementName);
        }

        String[] locator = value.split("=", 2);
        if (locator.length != 2) {
            throw new IllegalArgumentException("Invalid locator format for: " + elementName + " → " + value);
        }

        String type = locator[0].trim();
        String selector = locator[1].trim();

        System.out.println("Using locator: " + elementName + " → type: " + type + ", selector: " + selector);

        return switch (type.toLowerCase()) {
            case "name" -> By.name(selector);
            case "css" -> By.cssSelector(selector);
            case "linktext" -> By.linkText(selector);
            case "tagname" -> By.tagName(selector);
            case "classname" -> By.className(selector);
            case "xpath" -> By.xpath(selector);
            case "id" -> By.id(selector);
            default -> throw new IllegalArgumentException("No such locator type: " + type);
        };
    }
}