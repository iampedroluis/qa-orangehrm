package qa.orangehrm.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageLogin {
    private WebDriver driver;
    private By inputUsername_xpaString = By.xpath("//input[@name='username']");
    private By inputPassword_xpaString = By.xpath("//input[@name='password']");
    ZevTools zevtools;
    

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        this.zevtools = new ZevTools(driver);
    }

    public void enterCredentials(String username, String password) {

        try {

            zevtools.waitForElement( inputUsername_xpaString, 10);
            zevtools.waitForElement(inputPassword_xpaString, 10);
            driver.findElement(inputUsername_xpaString).sendKeys(username);
            driver.findElement(inputPassword_xpaString).sendKeys(password);
            zevtools.sleepSeconds(1);
            zevtools.screenshot(driver);
        } catch (Exception e) {
            // TODO: handle exception
            zevtools.zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }

    public void clickLoginButton() {
        try {
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            zevtools.sleepSeconds(2);
        } catch (Exception e) {
            // TODO: handle exception
            zevtools.zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }

    public void loginLikeAdmin() {
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        zevtools.zevLogs("Levantando: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", "INFO");
        zevtools.sleepSeconds(1);
        enterCredentials("Admin", "admin123");
        clickLoginButton();
    }



public void loginUrl() {
        
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    zevtools.zevLogs("Levantando: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", "INFO");
    zevtools.sleepSeconds(1);
}
}

