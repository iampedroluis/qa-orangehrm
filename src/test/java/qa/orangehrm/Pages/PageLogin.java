package qa.orangehrm.Pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageLogin {


    private WebDriver driver;
    ZevTools zevtools = new ZevTools();
    private PageDashBoard  dashBoard;

    public PageLogin(WebDriver driver){
        this.driver = driver;
        this.dashBoard = new PageDashBoard(driver);
    }

    public void loginUser ( String username, String password){
        try {
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            zevtools.sleepSeconds(2);
            zevtools.screenshot(driver);
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            zevtools.sleepSeconds(2);
            Assert.assertEquals(dashBoard.dashboardNavbarTitle(), "Dashboard");
        } catch (Exception e) {
            // TODO: handle exception
            zevtools.zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }
}
