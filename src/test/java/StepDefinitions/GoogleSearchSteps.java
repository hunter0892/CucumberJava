package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
	    
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		System.out.println();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}

	@And("user on google search page")
	public void user_on_google_search_page() {
	  driver.navigate().to("https://www.google.com/");
	}

	@When("user enters text in search box")
	public void user_enters_text_in_search_box() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		Thread.sleep(2000);
		
	    
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	  
	}

	@Then("user navigated to search results")
	public void user_navigated_to_search_results() {
		
	    driver.getPageSource().contains("Online Courses");
	    driver.close();
	    driver.quit();
	}

}
