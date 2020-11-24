package steps.login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginSteps {
    HomePage homePage;

    @Given("The website is open")
    public void the_website_is_open() throws Throwable {
        homePage = new HomePage();
    }

    @When("Is pressed the sign in button")
    public void is_pressed_the_sign_in_button() throws Throwable {
        homePage.clickOnLogInBtn();
    }


    @Then("Should appear the authentication form")
    public void should_appear_the_authentication_form() {
        homePage.authenticationForm();
    }


    @And("User user inserts his credentials:")
    public void user_inserts_his_credentials(DataTable dataTable) {
        List<Map<String, String>> ListOfMaps = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  send registration info to form
        homePage.authenticationFillForm(data);
    }


    @Then("Sign In button is pressed")
    public void sign_In_button_is_pressed() {
        homePage.submitLogInForm();
    }


    @Then("Appears the page with the user authenticated")
    public void appears_the_page_with_the_user_authenticated() throws Throwable {
        assertFalse(homePage.is404());
    }

}

