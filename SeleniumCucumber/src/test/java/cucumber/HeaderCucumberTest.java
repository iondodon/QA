package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class HeaderCucumberTest {
    WebDriver driver = null;

    @Given("^I have open the browser$")
    public void openBrowser() {
        final String chromedriverPath = "chromedriver";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        driver = new ChromeDriver();
    }

    @When("^I open 9gag website$")
    public void goTo9Gag() {
        driver.navigate().to("https://www.9gag.com/");
    }

    @When("^I search for Computer$")
    public void searchForComputer() {
        WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/a[2]"));
        searchIcon.click();

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/div/form/div[1]/input"));
        searchInput.sendKeys("computer");
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("^Header should exits$")
    public void loginButton() {
        boolean headerIsDisplayed = driver.findElement(By.xpath("//*[@id=\"top-nav\"]")).isDisplayed();
        assertTrue("Header is not displayed!", headerIsDisplayed);
        driver.close();
    }
}