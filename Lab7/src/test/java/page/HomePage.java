package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class HomePage extends Base {
    private final By searchIconXPath = By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/a[2]");
    private final By searchInputXPath = By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/div/form/div[1]/input");
    private final By headerXPath = By.xpath("//*[@id=\"top-nav\"]");

    WebElement searchInput;

    public HomePage() {
        driver.get("https://9gag.com/");
        acceptCookies();
    }

    private void acceptCookies() {
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//*[text()='I ACCEPT']"));
        acceptCookiesButton.click();
    }

    public void writeInSearchBar(String text) {
        searchInput = driver.findElement(searchInputXPath);
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void pressEnter() {
        searchInput.sendKeys(Keys.ENTER);
    }

    public void clickSearchIcon() {
        WebElement searchIcon = driver.findElement(searchIconXPath);
        searchIcon.click();
    }

    public boolean headerIsDisplayed() {
        return driver.findElement(headerXPath).isDisplayed();
    }

    public boolean is404() {
        return driver.findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed();
    }
}
