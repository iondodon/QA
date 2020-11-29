package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
    public static final String USERNAME = "iondodon1";
    public static final String AUTOMATE_KEY = "tLt3ydzPGizLzfcCdR7a";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    DesiredCapabilities caps = new DesiredCapabilities();

    protected WebDriver driver;

    public Base() {
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "iondodon1's First Test");

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
    }

    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
        System.out.println("Working Driver was closed.");
    }
}
