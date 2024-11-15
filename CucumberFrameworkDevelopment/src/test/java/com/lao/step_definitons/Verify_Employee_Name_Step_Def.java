package com.lao.step_definitons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.lao.constants.Constants;
import com.lao.pageobjects.DirectoryPage;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.utilities.CommonUtilities;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Employee_Name_Step_Def {
	public static final Logger LOGGER = LogManager.getLogger(Verify_Employee_Name_Step_Def.class);

	@Given("User should be logged on home page of OrangeHRM Appsuccessfully")
	public void user_should_be_logged_on_home_page_of_orange_hrm_appsuccessfully() throws InterruptedException {
		try {

		Thread.sleep(5000);
		String url = DriverManager.getDriver().getCurrentUrl();
		if (url.contains("dashboard")) {
			LOGGER.info("User should be logged on home page of OrangeHRM Appsuccessfully");
		}
		}catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}

	}

	@When("User clicks on the directory option from home menu bar")
	public void user_clicks_on_the_directory_option_from_home_menu_bar() throws InterruptedException {
		try {

	

		HomePage.getHomePageInstance().clickDirectory();
		System.out.println("User clicks on the directory option from home menu bar");
		}
		catch (Exception e) {
			LOGGER.error(e);
		
			Assert.fail(e.getMessage());
		}

	}

	@When("User enters the employee name as {string}")
	public void user_enters_the_employee_name_as(String string) throws InterruptedException {
		try {

		Thread.sleep(10000);

		DirectoryPage.getDirectoryPageInstance().clickEmployeeNAme();

		// DirectoryPage.Employee_Name_Input.sendKeys("Peter"); // this thinh is not
		// wrking fine
//		//DirectoryPage.JobTitle_Dropdown.click();
		LOGGER.info("User enters the employee name as " + string);
		}
		catch (Exception e) {
			LOGGER.error(e);
		
			Assert.fail(e.getMessage());
		}

	}

	@When("User click the search button of directory page")
	public void user_click_the_search_button_of_directory_page() throws InterruptedException {
		try {

		DirectoryPage.getDirectoryPageInstance().clickSearch();
		Thread.sleep(5000);
		LOGGER.info("User click the search button of directory page");
		}
		catch (Exception e) {
			LOGGER.error(e);
		
			Assert.fail(e.getMessage());
		}

	}

	@Then("User can see the Employee name as {string}")
	public void user_can_see_the_employee_name_as(String string) {
		try {

		boolean record = DirectoryPage.getDirectoryPageInstance().ValidateRcord();
		if (record) {
			LOGGER.info("User can see the Employee name as {string}");
		}
		}
		catch (Exception e) {
			LOGGER.error(e);
		
			Assert.fail(e.getMessage());
		}

	}

}
