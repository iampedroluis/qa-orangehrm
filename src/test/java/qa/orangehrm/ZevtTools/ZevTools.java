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
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ZevTools {

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
            zevLogs("ScreenShot: " + folderPath + "/"+ "SCREENSHOT " + formattedDate + " " + ".png", " OK");
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
        WebDriver driver = null;
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
        } catch (Exception e) {
            // TODO: handle exception
            zevLogs("Error en setupDriver: " + e.getMessage(), "ERROR");
            e.printStackTrace();
        }
        return driver;

    }
    
   
    public void closeDriver(WebDriver driver) 
    {
        driver.quit();
    }
}
