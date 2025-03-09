package qa.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageAdmin {
    private WebDriver driver;
    private WebDriverWait wait;
    private ZevTools zevtools = new ZevTools();
    private By layoutTitle = By.xpath("//h6[normalize-space()='User Management']");
    
}
