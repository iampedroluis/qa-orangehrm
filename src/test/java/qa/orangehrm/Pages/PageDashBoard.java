package qa.orangehrm.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//importa libreria Zevtools 
import qa.orangehrm.ZevtTools.ZevTools;

public class PageDashBoard {

    private WebDriver driver;
    ZevTools zevtools = new ZevTools();

    public PageDashBoard(WebDriver driver) {
        this.driver = driver;
    }
    public String dashboardNavbarTitle() {      
        String textDashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        zevtools.sleepSeconds(2);
        return textDashboard;
    }
}
