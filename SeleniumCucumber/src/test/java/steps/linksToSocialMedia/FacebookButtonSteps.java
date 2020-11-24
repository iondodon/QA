package steps.linksToSocialMedia;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

import static org.junit.Assert.assertTrue;

public class FacebookButtonSteps {
    HomePage homePage;

    @When("The home page is opened")
    public void the_home_page_is_opened() {
        homePage = new HomePage();
    }

    @And("Facebook social media button is clicked")
    public void and_Facebook_social_media_button_is_clicked() {
        homePage.clickOnFacebookButton();
    }

    @Then("Validate that the Facebook age is opened")
    public void validate_that_the_Facebook_age_is_opened() {
        assertTrue("Could not open Facebook", homePage.isFacebook());
    }
}
