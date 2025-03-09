package qa.orangehrm.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.orangehrm.Pages.PageDashBoard;
import qa.orangehrm.Pages.PageLogin;
import qa.orangehrm.ZevtTools.ZevTools;

public class LoginSteps {

    private WebDriver driver;
    private PageLogin pageLogin;
    private PageDashBoard dashboard;
    private ZevTools zevTools;

    @Given("The user navigates to the login page")
    public void openLoginPage() {
        // Open the login page
        // Inicializa el driver correctamente
        zevTools = new ZevTools(driver);
        driver = zevTools.setupDriver();
        pageLogin = new PageLogin(driver);
        dashboard = new PageDashBoard(driver);
        pageLogin.loginUrl();
        zevTools.sleepSeconds(3);
        zevTools.zevLogs("levante la url", "INFO");
        zevTools.screenshot(driver);

    }

    @When("The user enters a valid username and password")
    public void enterCredentials(DataTable credentials) {
        // Enter username and password
        List<List<String>> data = credentials.asLists(String.class);
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);

        System.out.println("username: " + username + " password: " + password);
        pageLogin.enterCredentials(username, password);
    }

    @When("The user clicks on the login button")
    public void clickLoginButton() {
        // User clicks on the login button
        pageLogin.clickLoginButton();

    }

    @Then("The user should be redirected to the dashboard page")
    public void verifyRedirectToDashboard() {
        // Verify that the user is redirected to the dashboard page
        if (driver == null) {
            throw new IllegalStateException("Error: WebDriver no ha sido inicializado.");
        }
        zevTools.zevLogs("Verifico si estoy en la dashboard", "INFO");
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);
        zevTools.zevLogs("La prueba de login ha pasado correctamente", "INFO");
        zevTools.sleepSeconds(3);
        Assert.assertTrue("Dashboard Displayed", dashboard.isDashboardDisplayed());
        zevTools.closeDriver(driver);
    }
}
