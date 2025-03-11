package qa.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageAddUser {
    private WebDriver driver;
    private ZevTools zevtools;
    private By AddUserLayoutTitle_xpath = By.xpath("//h6[normalize-space()='Add User']");
    public PageAddUser(WebDriver driver) {
        this.driver = driver;
        this.zevtools = new ZevTools(driver); // Inicializa ZevTools después de asignar el driver
    }

    public boolean AddUserLayoutDisplayed() {
        return zevtools.isElementVisible(AddUserLayoutTitle_xpath, 15);
    }
}
