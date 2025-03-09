package qa.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageAdmin {
 private WebDriver driver;
    private ZevTools zevtools;
    private By adminlayoutTitle = By.xpath("//h6[normalize-space()='User Management']");
    // Constructor que recibe el WebDriver
    public PageAdmin(WebDriver driver) {
        this.driver = driver;
        this.zevtools = new ZevTools(driver); // Inicializa ZevTools después de asignar el driver
    }
    
    public boolean isDashboardDisplayed() {
        return zevtools.isElementVisible(adminlayoutTitle, 15);
    }
    
}
