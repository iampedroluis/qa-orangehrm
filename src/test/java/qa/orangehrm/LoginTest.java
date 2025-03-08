package qa.orangehrm;

import qa.orangehrm.Pages.PageLogin;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//importo la libreria de ZevTools
import qa.orangehrm.ZevtTools.ZevTools;

public class LoginTest {

    private WebDriver driver;
    private ZevTools zevTools = new ZevTools();
    

  

    @BeforeMethod
    public void setUp() {
        driver = zevTools.setupDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        zevTools.sleepSeconds(3);
    }

    @Test
    public void PruebaLoginOrangeERM() {
        try {
            PageLogin login = new PageLogin(driver);
            login.loginUser("Admin", "admin123");
            zevTools.screenshot(driver);
        } catch (Exception e) {
            // TODO: handle exception
            zevTools.zevLogs(e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }

    @AfterMethod 
    public void tearDown() {
        driver.quit();
    }
}

