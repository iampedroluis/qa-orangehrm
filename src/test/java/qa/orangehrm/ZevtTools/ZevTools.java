/**
 * 
 * ZevTools es una librería de utilidades para facilitar la automatización de pruebas en Selenium WebDriver.
 * Proporciona métodos para capturas de pantalla, generación de logs y configuración del WebDriver.
 * 
 */

package qa.orangehrm.ZevtTools;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZevTools {

    private WebDriverWait wait;
    private WebDriver driver;

    public ZevTools(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Asegura que esto no sea null
    }

    public void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            // TODO: handle exception
            zevLogs("Error en SleepSeconds: " + e.getMessage(), "ERROR");
            e.printStackTrace();

        }

    }

    public void screenshot(WebDriver driver) {
        try {
            File myScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
            String formattedDate = dateFormat.format(new Date());
            String folderPath = "reports/screenshots";
            Files.createDirectories(Paths.get(folderPath));
            formattedDate = formattedDate.replace(":", "");
            formattedDate = formattedDate.replace(".", "_");
            FileUtils.copyFile(myScreenshot,
                    new File(folderPath + File.separator + "SCREENSHOT " + formattedDate + " " + ".png"));
            zevLogs("ScreenShot: " + folderPath + "/" + "SCREENSHOT " + formattedDate + " " + ".png", " OK");
        } catch (Exception e) {
            zevLogs("Error en tomar captura: " + e.getMessage(), "ERROR");
            e.printStackTrace();

        }
    }

    public void zevLogs(String message, String level) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String timestamp = dateFormat.format(new Date());

        System.out.println("[" + timestamp + "]" + "[" + level + "] " + "-->" + message);

    }

    public WebDriver setupDriver() {
        if(this.driver == null){
            try {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver_V134/chromedriver.exe");
                // Obtener el valor de la variable de sistema -Dheadless (true o false)
                String headlessProperty = System.getProperty("headless", "false").trim().toLowerCase();
                boolean headless = headlessProperty.equals("true");
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless"); // Activa el modo headless
                    options.addArguments("--window-size=1920,1080"); // Define tamaño de ventana en headless
                    options.addArguments("--disable-gpu"); // Desactiva la aceleración por hardware
                    zevLogs("Ejecutando en modo HEADLESS", "INFO");
                } else {
                    options.addArguments("--start-maximized"); // Maximiza la ventana
                    zevLogs("Ejecutando con ventana maximizada", "INFO");
                }
    
                driver = new ChromeDriver(options);
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Se inicializa el wait
    
            } catch (Exception e) {
                // TODO: handle exception
                zevLogs("Error en setupDriver: " + e.getMessage(), "ERROR");
                e.printStackTrace();
            }
        }
        
        return this.driver;

    }

    public void closeDriver(WebDriver driver) {
        driver.quit();
    }

    public boolean isElementVisible(By locator, int timeOut) {
        try {
            WebElement element = waitForElement(locator, timeOut);
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
            return false;
        }
    }

    public WebElement waitForElement(By locator, int timeOut) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            return customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            // TODO: handle exception
            zevLogs("Error: " + e.getMessage(), "ERROR");
            e.printStackTrace();
            return null;
        }

    }

}
