package testRunner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class) //if we will uncomment this and asked to run this then it will run as a Junit
@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="stepDefinations")
public class TestRunner  extends AbstractTestNGCucumberTests  { //currently we are running this as a testng so we are extending this class which we take from net

}



