package qa.orangehrm.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/qa/orangehrm/features",  // Ubicación de los archivos .feature
    glue = "qa.orangehrm.steps",              // Paquete de las definiciones de los pasos
    plugin = {"pretty", "json:test/reports/cucumber_report.json"},// Ruta correcta para el reporte JSON
    tags = "@AllTests"  // Ejecutar todos los test
  )
  
  public class TestRunner extends AbstractTestNGCucumberTests {  
}
