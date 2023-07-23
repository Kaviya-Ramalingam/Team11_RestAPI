package testrunner;

//import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class testRunner {
	
	
	@CucumberOptions(
			plugin = {"pretty"}, //reporting purpose
			
			monochrome=false,  
			features = {"src/test/java/features"}, //location of feature files
			glue={"stepdefinition"}) //location of step definition file

	public class TestRunner extends AbstractTestNGCucumberTests{
		
		
		}
}	
