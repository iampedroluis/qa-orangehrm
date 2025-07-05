package qa.orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import qa.orangehrm.Pages.PageAdmin;
import qa.orangehrm.Pages.PageDashBoard;
import qa.orangehrm.Pages.PageLogin;
import qa.orangehrm.ZevtTools.ZevTools;

public class deleteUserSteps {
    
    private WebDriver driver;
    private PageLogin pageLogin;
    private PageDashBoard pagedashboard;
    private PageAdmin pageAdmin;
    private ZevTools zevTools;

    @Given("The user logs in as an administrator")
    public void the_user_logs_in_as_an_administrator() {
        zevTools = new ZevTools(driver);
        driver = zevTools.setupDriver();
        pageLogin = new PageLogin(driver);
        pagedashboard = new PageDashBoard(driver);
        pageLogin.loginLikeAdmin();
        zevTools.sleepSeconds(3);
        zevTools.zevLogs("levante la url", "INFO");
        zevTools.screenshot(driver);

    }
    @When("The user clicks on the Admin panel option in the navigation menu")
    public void the_user_clicks_on_the_Admin_panel_option_in_the_navigation_menu() {
        driver = zevTools.setupDriver();
        pagedashboard = new PageDashBoard(driver);
        pagedashboard.clickItemMenuAdmin();
        zevTools.sleepSeconds(3);
        zevTools.zevLogs("levante la url", "INFO");
        zevTools.screenshot(driver);
    }
    @Then("The user should be redirected to the User Management")
    public void the_user_should_be_redirected_to_the_user_management_layout() {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        Assert.assertTrue(pageAdmin.isDashboardDisplayed());
        zevTools.sleepSeconds(3);
        zevTools.zevLogs("levante la url", "INFO");
        zevTools.screenshot(driver);
    }
    @When("The user searches for {string} in the System user input field")
    public void the_user_searches_for_in_the_system_user_input_field(String username) {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        pageAdmin.searchUserName(username);
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
    }
    @And("The user clicks on the Search button")
    public void the_user_clicks_on_the_search_button() {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        pageAdmin.clickSearchButton();
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
    }
    @Then("The user should see the {string} in the search results")
    public void the_user_should_see_the_in_the_search_results(String username) {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        Assert.assertTrue(pageAdmin.isUserAdded(username));
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
    }

    @When("The user clicks on the Delete button for the {string} user")
    public void the_user_clicks_on_the_delete_button_for_the_user(String username) {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        pageAdmin.clickDeleteUserButton();
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
    }
    
    @Then("A delete confirmation message is displayed")
    public void a_delete_confirmation_message_is_displayed() {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        Assert.assertTrue(pageAdmin.isDeleteUserModalVisible());
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
    
    }

    @When("The user clicks on the Yes button in the confirmation message")
    public void the_user_clicks_on_the_yes_button_in_the_confirmation_message() {
        driver = zevTools.setupDriver();
        pageAdmin = new PageAdmin(driver);
        pageAdmin.clickDeleteUserConfirmButton();
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
    }

    @Then("The user should see a success message indicating the user has been deleted")
    public void the_user_should_see_a_success_message_indicating_the_user_has_been_deleted() {
        driver = zevTools.setupDriver();
        zevTools.sleepSeconds(3);
        zevTools.screenshot(driver);
        zevTools.closeDriver(driver);
    }

}
