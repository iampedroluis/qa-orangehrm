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
    private ZevTools zevtools = new ZevTools();
    private By dashboardTitle = By.xpath("//h6[text()='Dashboard']");


    public PageDashBoard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isDashboardDisplayed(){
        return isElementVisible(dashboardTitle,15);
    }
    private boolean isElementVisible(By locator, int timeOut ) {  
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            zevtools.zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
            return false;
        }    
        
    }
}
