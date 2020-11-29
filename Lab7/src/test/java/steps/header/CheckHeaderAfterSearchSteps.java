package steps.header;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

import static org.junit.Assert.assertTrue;

public class CheckHeaderAfterSearchSteps {
    HomePage homePage;

    @Given("Home page of 9gag.com is opened")
    public void homePageOfGagComIsOpened() {
        homePage = new HomePage();
    }

    @When("Search button is clicked")
    public void searchButtonIsClicked() {
        homePage.clickSearchIcon();
    }

    @Then("User writes {string} in the search")
    public void userWritesSomethingInTheSearch(String item) {
        homePage.writeInSearchBar(item);
    }

    @And("Enter is pressed")
    public void enterIsPressed() {
        homePage.pressEnter();
    }

    @Then("Header is displayed")
    public void headerIsDisplayed() {
        boolean headerIsDisplayed = homePage.headerIsDisplayed();
        assertTrue("Header is not displayed!", headerIsDisplayed);
    }
}
