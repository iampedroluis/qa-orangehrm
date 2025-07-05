package qa.orangehrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qa.orangehrm.ZevtTools.ZevTools;

public class PageAdmin {
    private WebDriver driver;
    private ZevTools zevtools;
    private By adminlayoutTitle = By.xpath("//h6[normalize-space()='User Management']");
    private By addButon_xpath = By.xpath("//button[normalize-space()='Add']");
    private By searchUserNameInput_xpath = By.xpath("//label[text()='Username']/following::input[1]");
    private By searchButton_xpath = By.xpath("//button[@type='submit']");
    private String userAdded_xpath = "//div[@role='table']//div[contains(text(), '%s')]";
    private By deleteUserButton_xpath = By.xpath("//i[@class='oxd-icon bi-trash']");
    private By deleteUserModal_xpath =  By.xpath("//div[@role='document']");
    private By deleteUserButtonConfirm_xpath = By.xpath("//div[@role='document']//button[@type='button']//i[@class='oxd-icon bi-trash oxd-button-icon']");





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

    public void clickSearchButton(){
        try {
            if(zevtools.isElementVisible(searchButton_xpath, 15)){
                driver.findElement(searchButton_xpath).click();
                zevtools.zevLogs("Search button clicked", "INFO");
            }
        } catch (Exception e) {
            zevtools.zevLogs("Error Msg: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }

    public void searchUserName(String userName) {
        try {
            if(zevtools.isElementVisible(searchUserNameInput_xpath, 15)){
                driver.findElement(searchUserNameInput_xpath).sendKeys(userName);
                zevtools.zevLogs("Searching for user: " + userName, "INFO");
                clickSearchButton();
            }
        } catch (Exception e) {
            zevtools.zevLogs("Error Msg: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }
    
    public boolean isUserAdded(String userName) {
        String userXpath = String.format(userAdded_xpath, userName);
        return zevtools.isElementVisible(By.xpath(userXpath), 15);
    }

    public void clickDeleteUserButton() {
        try {
            if(zevtools.isElementVisible(deleteUserButton_xpath, 15)){
                driver.findElement(deleteUserButton_xpath).click();
                zevtools.zevLogs("Delete user button clicked", "INFO");
            }
        } catch (Exception e) {
            zevtools.zevLogs("Error Msg: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }

    public boolean isDeleteUserModalVisible() {
        return zevtools.isElementVisible(deleteUserModal_xpath, 15);
    }
    public void clickDeleteUserConfirmButton() {
        try {
            if(isDeleteUserModalVisible()){
                driver.findElement(deleteUserButtonConfirm_xpath).click();
                zevtools.zevLogs("Delete user confirm button clicked", "INFO");
            }
        } catch (Exception e) {
            zevtools.zevLogs("Error Msg: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
    }   
}
