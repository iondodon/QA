package steps.searchBar;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

import static org.junit.Assert.assertFalse;

public class SearchBarSteps {
    HomePage homePage;

    @When("The home page is opened")
    public void home_page_is_opened() {
        homePage = new HomePage();
    }

    @And("^In search bar write an item \"(.*?)\"$")
    public void write_item_in_search_bar(String item) {
        homePage.writeInSearchBar(item);
    }

    @When("The search icon is clicked")
    public void click_on_search_icon() {
        homePage.clickOnSearchIcon();
    }

    @Then("Validate that the page with the item is returned")
    public void validate_that_the_page_with_the_item_is_returned() {
        assertFalse("Searched item not found", homePage.is404());
    }
}
