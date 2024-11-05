package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions
(features = "src/test/java/features" , glue = {"steps"} ,
plugin = {"pretty", "html:target/cucumber-html-report"})

@Test
public class TestRunner extends TestBase{

}
