package com.CucumberSteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.pageobject.Spicejet;

import io.cucumber.java.en.*;


public class SpiceStepDefinition {
	protected static WebDriver driver;
	String appURL = "https://spicejet.com";
	String noofPAX;
	String currencySelect;
	String originAirportSelect;
	String validateFlightDetails;
	
	@Given("The user has opened the Spicejet Browser on a Web Browser")
	public void the_user_has_opened_the_spicejet_browser_on_a_web_browser() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String browser = "CHROME";
		switch (browser.toUpperCase()) {
		case "CHROME": {
			System.setProperty("Webdriver.chrome.driver",
					"C:\\Development\\Target2024\\Drivers\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case "EDGE": {
			driver = new EdgeDriver();
			break;
		}
		case "FIREFOX": {
			driver = new FirefoxDriver();
			break;
		}
		default: {
			System.out.println("OPPS, No Driver Selected, You need To select atleast one Broswer!");
		}
		}
		System.out.println(browser + " Browser Launched for Test");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String aplogValidate = driver.findElement(Spicejet.labelWelcome).getText();
		System.out.println(aplogValidate);
		Assert.assertEquals(aplogValidate, "Welcome aboard");
		Thread.sleep(2000);
		driver.findElement(Spicejet.rdOneWay).click();
	  //  throw new io.cucumber.java.PendingException();
	}

	@When("User Selects the Destinations")
	public void user_selects_the_destinations() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Airport Selection Begins");
		Thread.sleep(2000);
		driver.findElement(Spicejet.drpdnFromDestination).click();
		originAirportSelect = "CCU";
		Thread.sleep(2000);
		switch (originAirportSelect) {

		case "CCU": {

			driver.findElement(By.xpath("//div[text()='Kolkata']")).click();
			System.out.println("Airport Selected:" + originAirportSelect);
			break;
		}
		case "AGR": {

			driver.findElement(By.xpath("//div[text()='Agra']")).click();
			System.out.println("Airport Selected:" + originAirportSelect);
			break;
		}
		case "DEL": {

			driver.findElement(By.xpath("//div[text()='Delhi']")).click();
			System.out.println("Airport Selected:" + originAirportSelect);
			break;
		}
		default: {

			System.out.println("Please select Origin Airport!");
		}
		}

		System.out.println("origin Airport Selected");
		Thread.sleep(2000); //
		// driver.findElement(Spicejet.drpdnToDestination).click();
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='DEL']/parent::div[1]")).click();
		System.out.println("Desination Airport Selected");
		System.out.println("Airport Selection Completed");
		Thread.sleep(2000);
		

	    //throw new io.cucumber.java.PendingException();
	}

	@When("Select the Travel dates")
	public void select_the_travel_dates() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(Spicejet.currentDate).click();
		System.out.println("The start date has been clicked");
		Thread.sleep(2000);
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Select the number of Passengers")
	public void select_the_number_of_passengers() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(Spicejet.drpdnPassenger).click();
		int i = 1;
		int j = 5;
		while (i < j) {
			driver.findElement(Spicejet.incrementPassenger).click();
			i++;
		}
		System.out.println("Passengers Incremented");
		Thread.sleep(5000);
		noofPAX = driver.findElement(Spicejet.drpdnNoOfPAX).getText();
		System.out.println("Passengers Incremented To:" + noofPAX);
		int x = 5;
		int y = 1;
		while (x > y) {
			driver.findElement(Spicejet.decrementPassenger).click();
			x--;
		}
		System.out.println("Passengers Decremented");
		Thread.sleep(5000);
		noofPAX = driver.findElement(Spicejet.drpdnNoOfPAX).getText();
		System.out.println("Passengers Decremented To:" + noofPAX);
		for (i = 1; i < j; i++) {
			driver.findElement(Spicejet.incrementPassenger).click();

		}
		System.out.println("Passengers RE- Incremented");
		noofPAX = driver.findElement(Spicejet.drpdnNoOfPAX).getText();
		System.out.println("Passengers REIncremented To:" + noofPAX);
	   // throw new io.cucumber.java.PendingException();
	}

	@When("Select the Curency")
	public void select_the_curency() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("About to select currency!");
		Thread.sleep(4000);
		driver.findElement(Spicejet.drpdnCurrency).click();

		currencySelect = "AED";
		Thread.sleep(2000);
		switch (currencySelect) {

		case "INR": {

			driver.findElement(By.xpath(" //div[contains(text(),'INR')]")).click();
			System.out.println("Currency Selected:" + currencySelect);
			break;
		}
		case "USD": {

			driver.findElement(By.xpath(" //div[contains(text(),'USD')]")).click();
			System.out.println("Currency Selected:" + currencySelect);
			break;
		}
		case "AED": {

			driver.findElement(By.xpath(" //div[contains(text(),'AED')]")).click();
			System.out.println("Currency Selected:" + currencySelect);
			break;
		}
		default: {

			System.out.println("Please select Currency!");
		}
		}
	   // throw new io.cucumber.java.PendingException();
	}

	@When("Clicks on the Search Fight button")
	public void clicks_on_the_search_fight_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		driver.findElement(Spicejet.buttonSearchFlight).click();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("User able to see the avaibale flights for that route")
	public void user_able_to_see_the_avaibale_flights_for_that_route() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(7000);
		validateFlightDetails = driver.findElement(Spicejet.labelFlighDetailspage).getText();
		System.out.println(validateFlightDetails);
		Assert.assertEquals("Compare Fares", validateFlightDetails);
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Users Closes the Browser")
	public void users_closes_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().deleteAllCookies();
		driver.quit();
		System.out.println("Browser Closed, Test Concluded!");
	    //throw new io.cucumber.java.PendingException();
	}

}
