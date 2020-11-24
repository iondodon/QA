package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ContactPage extends Base {

    private final By contactForm = By.xpath("//div[@class='col-md-6 contact-form']");
    private final By nameContactField = By.xpath("//div[@class='col-md-6 contact-form']//input[@name = 'Name']");
    private final By emailContactField = By.xpath("//div[@class='col-md-6 contact-form']//input[@name = 'Email']");
    private final By subjectContactField = By.xpath("//div[@class='col-md-6 contact-form']//input[@name = 'Subject']");
    private final By messageContactField = By.xpath("//div[@class='col-md-6 contact-form']//textarea[@name='Message']");
    private final By sendButton = By.xpath("//div[@class='col-md-6 contact-form']//input[@type='submit']");

    public ContactPage() {
        driver.get("https://loving-hermann-e2094b.netlify.app/contact.html");
    }

    public boolean contactFormIsDisplayed() {
        WebElement contactFormDisplayed = driver.findElement(contactForm);
        return contactFormDisplayed.isDisplayed();
    }

    public void fillContactForm(Map<String, String> map) {
        String name = map.get("username");
        String email = map.get("email");
        String subject = map.get("subject");
        String message = map.get("message");

        WebElement fillNameField = driver.findElement(nameContactField);
        WebElement fillEmailField = driver.findElement(emailContactField);
        WebElement fillSubjectField = driver.findElement(subjectContactField);
        WebElement fillMessageField = driver.findElement(messageContactField);


        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(fillNameField));


        if (!"n/a".equals(name)) {
            fillNameField.clear();
            fillNameField.sendKeys(name);
        }
        if (!"n/a".equals(email)) {
            fillEmailField.clear();
            fillEmailField.sendKeys(email);
        }
        if (!"n/a".equals(subject)) {
            fillSubjectField.clear();
            fillSubjectField.sendKeys(subject);
        }
        if (!"n/a".equals(message)) {
            fillMessageField.clear();
            fillMessageField.sendKeys(message);
        }
    }

    public void sendButtonIsPressed() {
        WebElement sendBtn = driver.findElement(sendButton);
        sendBtn.click();
    }
}
