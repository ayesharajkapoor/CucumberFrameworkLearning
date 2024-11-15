package com.lao.step_definitons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.lao.constants.Constants;
import com.lao.pageobjects.DirectoryPage;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.utilities.CommonUtilities;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_CEO_Name_Step_Def {
	public static final Logger LOGGER = LogManager.getLogger(Verify_CEO_Name_Step_Def.class);

	@Given("User should be logged on home page successfully")
	public void user_should_be_logged_on_home_page_successfully() throws InterruptedException {

		LOGGER.info("User should be logged on home page of OrangeHRM Appsuccessfully");

	}

	@When("User clicks on the directory option from menu bar")
	public void user_clicks_on_the_directory_option_from_menu_bar() throws InterruptedException {

		System.out.println("User clicks on the directory option from home menu bar");

	}

	@When("User selects the Job title as {string}")
	public void user_selects_the_job_title_as(String string) throws InterruptedException {

		System.out.println("User selects the Job title as Chief Executive Officer");

	}

	@When("User click the search button")
	public void user_click_the_search_button() {
		System.out.println("User click the search button");

	}

	@Then("User can see the CEO  name as {string}")
	public void user_can_see_the_hr_manager_name_as(String string) {
		System.out.println("User can see the HR Manager name as Maria Landa");

	}

}
