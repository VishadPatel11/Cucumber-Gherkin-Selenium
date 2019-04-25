package cucumberTest;
 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature"          //to map to the script
 ,glue="stepDefinition"      //to map to the methods 
 //,dryRun= true			   // to just make sure steps have methods
 //,monochrome = false			 	//displays details of time elapsed in tests
 //,format = { "html:Desktop"}		//display results in html,json,xml		
//,format = {"json:Desktop/cucumber.json"}
//,format = { "junit:Desktop/cucumber.xml"}
 //,strict = true 					//fail the execution if there is any undefined steps or pending steps
		)
 
public class TestRunner {
 
}
