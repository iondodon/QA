package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class HomePage extends Base {
    private final By searchBarXPath = By.xpath("/html/body/div[2]/div[1]/div[1]/form/input[1]");
    private final By searchIconXPath = By.xpath("/html/body/div[2]/div[1]/div[1]/form/input[2]");
    private final By facebookButtonXPath = By.xpath("/html/body/div[14]/div/div[1]/ul/li[1]/a/div[1]");
    private final By signInButtonXpath = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By authenticationFormXPath = By.xpath("//*[@id='myModal']/div/div");
    private final By signInUsernameFieldXPth = By.xpath("//*[@id='myModal']//input[@name='Name']");
    private final By signInEmailFieldXPath = By.xpath("//*[@id='myModal']//input[@name='Email']");
    private final By logInBtnXPath = By.xpath("//*[@id='myModal']//input[@type='submit']");

    public HomePage() {
        driver.get("https://loving-hermann-e2094b.netlify.app/index.html");
    }

    public void writeInSearchBar(String item) {
        WebElement searchBar = driver.findElement(searchBarXPath);
        searchBar.sendKeys(item);
    }

    public void clickOnSearchIcon() {
        WebElement searchIcon = driver.findElement(searchIconXPath);
        searchIcon.click();
    }

    public void clickOnFacebookButton() {
        WebElement facebookButton = driver.findElement(facebookButtonXPath);
        facebookButton.click();
    }

    public boolean isFacebook() {
        return driver.getCurrentUrl().contains("facebook");
    }

    public void clickOnLogInBtn() {
        WebElement clickOnSignInBtn = driver.findElement(signInButtonXpath);
        clickOnSignInBtn.click();
    }

    public void authenticationForm() {
        WebElement findAuthenticationForm = driver.findElement(authenticationFormXPath);
        findAuthenticationForm.isDisplayed();
    }

    public void authenticationFillForm(Map<String, String> map) {
        String username = map.get("username");
        String email = map.get("email");

        WebElement fillSignInUsernameField = driver.findElement(signInUsernameFieldXPth);
        WebElement fillSignInEmailField = driver.findElement(signInEmailFieldXPath);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(fillSignInUsernameField));


        if (!"n/a".equals(username)) {
            fillSignInUsernameField.clear();
            fillSignInUsernameField.sendKeys(username);
        }
        if (!"n/a".equals(email)) {
            fillSignInEmailField.clear();
            fillSignInEmailField.sendKeys(email);
        }

    }

    public void submitLogInForm() {
        WebElement logInButton = driver.findElement(logInBtnXPath);
        logInButton.submit();
    }

    public boolean is404() {
        return driver.findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed();
    }
}
