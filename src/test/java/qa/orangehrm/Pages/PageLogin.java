package qa.orangehrm.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageLogin {

    ZevTools zevtools = new ZevTools();
    private WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCredentials(String username, String password) {

        try {
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            zevtools.sleepSeconds(2);
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
        zevtools.sleepSeconds(10);
        enterCredentials("Admin", "admin123");
        clickLoginButton();
    }
}
