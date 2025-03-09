package qa.orangehrm.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//importa libreria Zevtools 
import qa.orangehrm.ZevtTools.ZevTools;

public class PageDashBoard {

    private WebDriver driver;
    private WebDriverWait wait;
    private ZevTools zevtools;
    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private By adminItemNav_xpath = By.xpath("//span[normalize-space()='Admin']");

    public PageDashBoard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.zevtools = new ZevTools(driver);
    }

    public boolean isDashboardDisplayed() {
        return zevtools.isElementVisible(dashboardTitle, 15);
    }



    public void clickItemMenuAdmin() {
        try {
            zevtools.waitForElement(adminItemNav_xpath, 10);
            driver.findElement(adminItemNav_xpath).click();
            zevtools.sleepSeconds(1);
            zevtools.zevLogs("Admin item clicked", "INFO");
            zevtools.screenshot(driver);
        } catch (Exception e) {
            // TODO: handle exception
            zevtools.zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }
}
