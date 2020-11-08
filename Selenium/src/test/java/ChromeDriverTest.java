import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ChromeDriverTest {

    private WebDriver driver;

    @Before
    public void prepare() {
        final String chromedriverPath = "/home/ion/Documents/UTM/QA (CS)/git/QA/Selenium/chromedriver";
        final String testUrl = "https://9gag.com/";
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);
    }

    @Test
    public void testTitle() throws IOException {
        WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/a[2]"));
        searchIcon.click();

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/div/form/div[1]/input"));
        searchInput.sendKeys("computer");
        searchInput.sendKeys(Keys.ENTER);

        boolean headerIsDisplayed = driver.findElement(By.xpath("//*[@id=\"top-nav\"]")).isDisplayed();

        assertTrue("Header is not displayed!", headerIsDisplayed);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
