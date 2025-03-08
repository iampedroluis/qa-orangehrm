package qa.orangehrm.ZevtTools;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ZevTools {

    private int idSc = 0;

    public void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void screenshot(WebDriver driver) {
        File myScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());

        formattedDate = formattedDate.replace(":", "-");
        try {
            FileUtils.copyFile(myScreenshot,
                    new File("reports/screenshots" + File.separator + "SCREENSHOT " + formattedDate + " " + idSc
                            + ".png"));
            idSc++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
