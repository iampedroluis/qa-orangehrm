
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
  features = "src/test/resources/features",  // Ubicación de los archivos .feature
  glue = "qa.orangehrm.steps",              // Paquete de las definiciones de los pasos
  plugin = {"pretty", "html:target/cucumber-reports.html"} // Reportes
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
