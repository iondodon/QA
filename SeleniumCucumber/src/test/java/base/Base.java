package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    protected WebDriver driver;

    public Base() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver driver() {
        return driver;
    }

    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
        System.out.println("Working Driver was closed.");
    }
}
