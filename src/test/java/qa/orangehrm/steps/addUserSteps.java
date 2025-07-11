package qa.orangehrm.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.orangehrm.Pages.PageDashBoard;
import qa.orangehrm.Pages.PageLogin;
import qa.orangehrm.Pages.PageAddUser;
import qa.orangehrm.Pages.PageAdmin;
import qa.orangehrm.ZevtTools.ZevTools;

public class addUserSteps {

    private WebDriver driver;
    private PageLogin pageLogin;
    private PageDashBoard pagedashboard;
    private PageAdmin pageAdmin;
    private PageAddUser pageAddUser;
    private ZevTools zevTools;

    @Given("The user is logged in as an Admin and on the Dashboard page")
    public void the_user_is_logged_in_as_admin() {
        zevTools = new ZevTools(driver);
        driver = zevTools.setupDriver();
        pageLogin = new PageLogin(driver);
        pagedashboard = new PageDashBoard(driver);
        pageLogin.loginLikeAdmin();
        zevTools.sleepSeconds(3);
        zevTools.zevLogs("levante la url", "INFO");
        zevTools.screenshot(driver);

    }

    @When("The user clicks on the Admin option in the search panel")
    public void the_user_clicks_on_the_admin_option_in_the_search_panel() {
        pagedashboard.clickItemMenuAdmin();
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

    }

    @When("The user clicks on the Add button")
    public void the_user_clicks_on_the_add_button() {
        // Click on Add button
        zevTools.zevLogs("clickea en agregar", "INFO");
        zevTools.screenshot(driver);
        Assert.assertTrue("Click Button", pageAdmin.isButtonVisible());
        zevTools.sleepSeconds(1);
        pageAdmin.clickAddButton();
    }

    @Then("The user should be redirected to the Add User layout")
    public void verifyRedirectToAddUser() {
        // Verify that the user is redirected to the add user layout
        pageAddUser = new PageAddUser(driver);
        zevTools.zevLogs("Verifico si estoy en la vista de agregar usuario", "INFO");
        zevTools.sleepSeconds(1);
        Assert.assertTrue("Add User Layout Displayed", pageAddUser.AddUserLayoutDisplayed("Add User"));
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);

    }

    @When("The user selects {string} from the User Role dropdown")
    public void the_user_selects_ess_from_the_user_role_dropdown(String userRole) {
        pageAddUser.selectUserRole(userRole);
        zevTools.zevLogs("Seleccionando rol de usuario: " + userRole, "INFO");
        zevTools.sleepSeconds(1);

    }

    @And("The user selects {string} from the Employee Name dropdown")
    public void the_user_selects_john_doe_from_the_employee_name_dropdown(String employeeName) {
        // Select employee name from dropdown
        zevTools.zevLogs("Seleccionando nombre de empleado: " + employeeName, "INFO");
        zevTools.sleepSeconds(1);
        pageAddUser.selectEmployeeName(employeeName);
        zevTools.screenshot(driver);

    }

    @And("The user selects {string} from the Status dropdown")
    public void the_user_selects_from_the_status_dropdown(String status) {
        zevTools.zevLogs(("Selecciona User status"), "INFO");
        zevTools.sleepSeconds(1);
        pageAddUser.selectStatus(status);
        zevTools.screenshot(driver);
        zevTools.zevLogs("Cerrando Driver", "INFO");
        zevTools.sleepSeconds(3);

    }

    @And("The user enters {string} as the Username")
    public void the_user_enters_in_the_username_input_field(String userName) {
        // Enter username in input field
        zevTools.zevLogs("Ingresando nombre de usuario: " + userName, "INFO");
        pageAddUser.enterUserName(userName);
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);

    }

    @And("The user enters {string} as the Password")
    public void the_user_enters_in_the_password_input_field(String password) {
        // Enter password in input field
        zevTools.zevLogs("Ingresando contraseña: " + password, "INFO");
        pageAddUser.enterPassword(password);
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);

    }

    @And("The user enters {string} as the Confirm Password")
    public void the_user_enters_in_the_confirm_password_input_field(String confirmPassword) {
        // Enter confirm password in input field
        zevTools.zevLogs("Ingresando confirmación de contraseña: " + confirmPassword, "INFO");
        pageAddUser.enterConfirmPassword(confirmPassword);
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);

    }

    @And("The user clicks on the Save button")
    public void the_user_clicks_on_the_save_button() {
        // Click on Save button
        zevTools.zevLogs("Clickea en guardar", "INFO");
        pageAddUser.clickSaveButton();
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);
    }

    @Then("The new user {string} should be successfully added to the system")
    public void verifyUserAddedSuccessfully(String userName) {
        // Verify that the new user is successfully added
        zevTools.zevLogs("Verificando si el usuario fue agregado correctamente", "INFO");
        Assert.assertTrue("User Added Successfully", pageAddUser.isUserAdded(userName));
        zevTools.sleepSeconds(1);
        zevTools.screenshot(driver);
        driver.quit();
    }
}