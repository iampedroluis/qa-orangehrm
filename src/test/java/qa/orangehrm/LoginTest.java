package qa.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.orangehrm.ZevtTools.ZevTools;

public class LoginTest {

    private WebDriver driver;
    private ZevTools zevTools = new ZevTools();

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver_V134/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        zevTools.sleepSeconds(8);

    }

    @Test
    public void pruebauno() {
        zevTools.screenshot(driver);
        System.out.println("Soy una pruueba");
        zevTools.sleepSeconds(3);
        driver.quit();

    }
}
