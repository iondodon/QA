package steps.contactForm;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import page.ContactPage;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ContactSteps {
    ContactPage contactPage;

    @Given("Contact web page is opened")
    public void contact_web_page_is_opened() {
        contactPage = new ContactPage();
    }

    @Then("The Contact form is displayed")
    public void the_contact_form_is_displayed() {
        assertTrue(contactPage.contactFormIsDisplayed());
    }

    @When("User fills in the contact form:")
    public void user_fill_the_contact_form(DataTable dataTable) {
        List<Map<String, String>> ListOfMaps = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);
        contactPage.fillContactForm(data);
    }

    @And("The SEND button is pressed")
    public void the_send_button_is_pressed() throws Throwable {
        contactPage.sendButtonIsPressed();
    }

    @Then("Validate that contact form is send successfully")
    public void the_page_with_successful_send_contact_form_appears() {
        Assert.assertFalse(contactPage.driver().findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed());
    }
}