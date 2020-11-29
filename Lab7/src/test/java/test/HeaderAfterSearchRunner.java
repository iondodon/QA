package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Header.feature",
        glue = {"steps/header"},
        stepNotifications = true
)
public class HeaderAfterSearchRunner {
}
