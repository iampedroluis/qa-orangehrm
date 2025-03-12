package qa.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageAdmin {
    private WebDriver driver;
    private ZevTools zevtools;
    private By adminlayoutTitle = By.xpath("//h6[normalize-space()='User Management']");
    private By addButon_xpath = By.xpath("//button[normalize-space()='Add']");

    // Constructor que recibe el WebDriver
    public PageAdmin(WebDriver driver) {
        this.driver = driver;
        this.zevtools = new ZevTools(driver); // Inicializa ZevTools después de asignar el driver
    }

    public boolean isDashboardDisplayed() {
        
        return zevtools.isElementVisible(adminlayoutTitle, 15);
    }

    public boolean isButtonVisible() {
        return zevtools.isElementVisible(addButon_xpath, 15);

    }

    public void clickAddButton() {
        try {
            if(isButtonVisible()){
                driver.findElement(addButon_xpath).click();
                zevtools.zevLogs("Add button clicked", "INFO");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            zevtools.zevLogs("Error Msg: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
      
    }


}
