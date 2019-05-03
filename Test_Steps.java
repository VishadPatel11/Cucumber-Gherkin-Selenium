package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.cucumber.datatable.*;


public class Test_Steps {
	public static WebDriver driver;
	@Given("^User is on NXI generic Login page$")
	public void User_is_on_NXI_generic_Login_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Project\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://xat-netxinvestor.bnymellon.com/web/netxinvestor/login");
		
	}

	@Given("^Continue button is displayed$")
	public void Continue_button_is_displayed() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		String actualText = driver.findElement(By.id("dijit_form_Button_0_label")).getText();
		Assert.assertEquals("Continue", actualText);
		
	}

	@When("user enters Credentials")
	public void user_enters_Credentials(DataTable usercredentials) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    List<List<String>> data = usercredentials.cells();
		
		// For automatic transformation, change DataTable to one of
	    driver.findElement(By.id("dijit_form_ValidationTextBox_0")).sendKeys(data.get(0).get(0));
	    driver.findElement(By.id("dijit_form_ValidationTextBox_1")).sendKeys(data.get(0).get(1));
	    driver.findElement(By.id("dijit_form_ValidationTextBox_2")).sendKeys(data.get(0).get(2));
	   
	    
	}
	
	
/*	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_ibd_and_username_and_password(String IBD, String username, String password) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		
		driver.findElement(By.id("dijit_form_ValidationTextBox_0")).sendKeys(IBD);
		driver.findElement(By.id("dijit_form_ValidationTextBox_1")).sendKeys(username);
		driver.findElement(By.id("dijit_form_ValidationTextBox_2")).sendKeys(password);
		
		
	}
*/

	@When("^user clicks Continue button$")
	public void user_clicks_Continue_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
		
	}

	@When("^Security Question message is displayed$")
	public void Security_Question_message_is_displayed() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		String actualText = driver.findElement(By.xpath("//*[contains(text(),'Security Question')]")).getText();
		Assert.assertEquals("Security Question", actualText);
		
	}

	@When("^user enters last word of the question$")
	public void user_enters_last_word_of_the_question() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		String text = driver.findElement(By.className("secQuestion")).getText();
		String  lastWord= text.substring(text.lastIndexOf(" ")+1).replaceAll("[^a-zA-Z]","");
		WebElement elem = driver.findElement(By.xpath("//div[@class='dijitReset dijitInputField dijitInputContainer']/span"));
				Actions actions = new Actions(driver);
				actions.moveToElement(elem);
				actions.click();
				actions.sendKeys(lastWord);
				actions.perform();
		
	}

	@When("^user selects No as the response$")
	public void user_selects_No_as_the_response() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.id("dijit_form_RadioButton_1")).click();
		
	}

	@Then("^Logout link is displayed$")
	public void Logout_link_is_displayed() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.findElement(By.xpath(".//*[@class='btn btn-small logout']")).click();
		
	}
	
}
