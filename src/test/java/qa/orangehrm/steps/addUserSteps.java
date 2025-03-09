package qa.orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.orangehrm.Pages.PageDashBoard;
import qa.orangehrm.Pages.PageLogin;
import qa.orangehrm.Pages.PageAdmin;
import qa.orangehrm.ZevtTools.ZevTools;

public class addUserSteps {

    private WebDriver driver;
    private PageLogin pageLogin;
    private PageDashBoard dashboard;
    private PageAdmin pageAdmin;
    private ZevTools zevTools;

    @Given("The user is logged in as an Admin and on the Dashboard page")
    public void the_user_is_logged_in_as_admin() {
        zevTools = new ZevTools(driver);
        driver = zevTools.setupDriver();
        pageLogin = new PageLogin(driver);
        dashboard = new PageDashBoard(driver);
        pageLogin.loginLikeAdmin();
        zevTools.sleepSeconds(3);
        zevTools.zevLogs("levante la url", "INFO");
        zevTools.screenshot(driver);

    }

    @When("The user clicks on the Admin option in the search panel")
    public void the_user_clicks_on_the_admin_option_in_the_search_panel() {
        dashboard.clickItemMenuAdmin();
        zevTools.sleepSeconds(1);
        zevTools.zevLogs("clickea en admin", "INFO");
        zevTools.screenshot(driver);

    }

    // SEGUIR DISEÑANDO QUEDE POR AQUI
    @Then("The user should be redirected to the User Management layout")
    public void verifyRedirectToUserManagement() {
        pageAdmin = new PageAdmin(driver);
        // Verify that the user is redirected to the user management layout
        zevTools.zevLogs("Verifico si estoy en la gestion de usuarios", "INFO");
        zevTools.sleepSeconds(1);
        Assert.assertTrue("Dashboard Displayed", pageAdmin.isDashboardDisplayed());
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);
        zevTools.closeDriver(driver);
    }
}
