package qa.orangehrm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/qa/orangehrm/features/loginWithValidCredentials.feature", glue = "qa.orangehrm.steps")
public class RuncCukesTest extends AbstractTestNGCucumberTests {



}
