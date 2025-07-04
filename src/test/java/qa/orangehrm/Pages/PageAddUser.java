package qa.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageAddUser {
    private WebDriver driver;
    private ZevTools zevtools;

    // XPATHS 

    private By AddUserLayoutTitle_xpath = By.xpath("//h6[normalize-space()='Add User']");
    private By userRoleDropdown_xpath = By.xpath(
            "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
    private By inputEmployeeName_xpath = By.xpath("//input[@placeholder='Type for hints...']");
    private By statusDropdowns_xpath = By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
    private By userNameInput_xpath = By.xpath("//label[text()='Username']/following::input[1]");
    private By passwordInput_xpath = By.xpath("//label[text()='Password']/following::input[1]");
    private By confirmPasswordInput_xpath = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    

    public PageAddUser(WebDriver driver) {
        this.driver = driver;
        this.zevtools = new ZevTools(driver); 
        // Inicializa ZevTools después de asignar el driver
    }

    public boolean AddUserLayoutDisplayed(String text) {
        zevtools.zevAssertion(text, AddUserLayoutTitle_xpath);
        return zevtools.isElementVisible(AddUserLayoutTitle_xpath, 15);
    }

    public void selectUserRole(String userRole){
        
        WebElement dropdown = zevtools.waitForElement(userRoleDropdown_xpath, 15);
        dropdown.click();
        
        // Esperar un momento para que aparezcan las opciones
        zevtools.sleepSeconds(2);
        // Escribir en el chromedirver
        zevtools.driverSendKeys(userRole);
        Actions actions = new Actions(driver);
        // Simula Arrow Down para navegar por las opciones
        actions.sendKeys(Keys.ARROW_DOWN).build().perform(); 
        // Tomar screenshot después de seleccionar
        zevtools.sleepSeconds(1);
        zevtools.screenshot(driver);
        WebElement selectedElement = zevtools.waitForElement(By.xpath("//div[@class='oxd-select-text-input' and text()='"+ userRole + "']"), 10);
        String actualText = selectedElement.getText().trim();
        Assert.assertEquals(actualText, userRole );

    }
    public void selectEmployeeName(String employeeName){
        WebElement inputEmployeeName = zevtools.waitForElement(inputEmployeeName_xpath, 15);
        inputEmployeeName.click();
        zevtools.sleepSeconds(1);
        inputEmployeeName.sendKeys(employeeName);
        zevtools.sleepSeconds(3);
        Actions actions = new Actions(driver);
        // Simula Arrow Down para navegar por las opciones
        actions.sendKeys(Keys.ARROW_DOWN).build().perform(); 
        // Simula Enter para seleccionar la opción
        actions.sendKeys(Keys.ENTER).build().perform();
        zevtools.sleepSeconds(1);
       
    }
    public void selectStatus(String status){
        WebElement dropdown = zevtools.waitForElement(statusDropdowns_xpath, 15);
        dropdown.click();
        // Esperar un momento para que aparezcan las opciones
        zevtools.sleepSeconds(2);
        // Escribir en el chromedirver
        if(status.equals("Enabled")){
            zevtools.driverSendKeys("En");
        }
        else if(status.equals("Disabled")){
            zevtools.driverSendKeys("Dis");
        }
        
        // Tomar screenshot después de seleccionar
        zevtools.sleepSeconds(1);
        zevtools.screenshot(driver);
        WebElement selectedElement = zevtools.waitForElement(By.xpath("//div[@class='oxd-select-text-input' and contains(text(), '" + status + "')]"), 10);
        String actualText = selectedElement.getText().trim();
        Assert.assertEquals(actualText, status );
        
    }

    public void enterUserName(String userName) {
        WebElement userNameInput = zevtools.waitForElement(userNameInput_xpath, 15);
        userNameInput.click();
        zevtools.sleepSeconds(1);
        userNameInput.sendKeys(userName);
        zevtools.sleepSeconds(1);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = zevtools.waitForElement(passwordInput_xpath, 15);
        passwordInput.click();
        zevtools.sleepSeconds(1);
        passwordInput.sendKeys(password);
        zevtools.sleepSeconds(1);
    }
    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordInput = zevtools.waitForElement(confirmPasswordInput_xpath, 15);
        confirmPasswordInput.click();
        zevtools.sleepSeconds(1);
        confirmPasswordInput.sendKeys(confirmPassword);
        zevtools.sleepSeconds(1);
    }
}
