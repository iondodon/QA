package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Search.feature",
        glue = {"steps/searchBar"},
        stepNotifications = true
)
public class SearchBarRunner {

}