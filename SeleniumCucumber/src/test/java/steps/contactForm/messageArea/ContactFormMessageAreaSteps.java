package steps.contactForm.messageArea;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ContactPage;

import static org.junit.Assert.assertEquals;

public class ContactFormMessageAreaSteps {
    ContactPage contactPage;

    int oldWidth;

    @Given("The website is open on the Contact page")
    public void theWebsiteIsOpenOnTheContactPage() {
        contactPage = new ContactPage();
    }


    @When("I Click on the corner of the message area from the Contact Form")
    public void iClickOnTheCornerOfTheMessageAreaFromTheContactForm() {
        contactPage.clickCornerOfMessageArea();
        oldWidth = contactPage.getMessageAreaWidth();
    }

    @And("Drag the corner of the message area left to right")
    public void dragTheCornerOfTheMessageAreaLeftToRight() {
        contactPage.clickAndDrag();
    }

    @Then("The width of the message area should not change")
    public void theWidthOfTheMessageAreaShouldNotChange() {
        assertEquals("Message area expanded horizontally", oldWidth, (int) contactPage.getMessageAreaWidth());
    }
}
