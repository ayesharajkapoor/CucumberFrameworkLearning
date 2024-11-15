package com.lao.step_definitons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.lao.constants.Constants;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.pageobjects.TimePage;
import com.lao.utilities.CommonUtilities;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Pending_Timesheets_Step_DEf {
	public static final Logger LOGGER = LogManager.getLogger(Verify_Pending_Timesheets_Step_DEf.class);

	@Given("User should be looged on home page successfully")
	public void user_should_be_looged_on_home_page_successfully() throws InterruptedException {
		try {
			
			String url = DriverManager.getDriver().getCurrentUrl();

			if (url.contains("dashboard")) {

				LOGGER.info("User should be looged on home page successfully");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}
	}

	@When("User clicks Time option from menu bar")
	public void user_clicks_time_option_from_menu_bar() throws InterruptedException {
		try {
			Thread.sleep(10000);
			HomePage.getHomePageInstance().clickTime();
			String url = DriverManager.getDriver().getCurrentUrl();
			if (url.contains("viewEmployeeTimesheet")) {
				LOGGER.info("User should be looged on home page successfully");
			}
			Thread.sleep(10000);
		} catch (Exception e) {
			LOGGER.error(e);
		
			Assert.fail(e.getMessage());
		}
	}

	@When("User enters the employee name in Timesheet page as {string}")
	public void user_enters_the_employee_name_as(String string) throws InterruptedException {
		try {

			TimePage.getTimeInstance().enterEmployeeName(string);

			LOGGER.info("User enters the employee name as Orange Test");
		} catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}

	}

	@When("USer clicks the view button")
	public void u_ser_clicks_the_view_button() {
		try {

			TimePage.getTimeInstance().clickView();
			LOGGER.info("USer clicks the view button");
		} catch (Exception e) {
			LOGGER.error(e);
		
			Assert.fail(e.getMessage());
		}

	}

	@Then("User should see the message as {string}")
	public void user_should_see_the_message_as(String acTualmessage) {
		try {

			String seenMsg = TimePage.getTimeInstance().viewNoTimsheet();
			if (seenMsg.equals(acTualmessage)) {
				LOGGER.info("User should see the message as No Timesheet found");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}

	}
}
