package com.lao.step_definitons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lao.constants.Constants;
import com.lao.pageobjects.LoginPage;
import com.lao.utilities.CommonUtilities;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Step_Definitions {
	
	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Definitions.class);
	private static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	

	@Before

	public void BeforeScenario(Scenario scenario) {
		LOGGER.info("Exectuion started");
		try {
			scenarioName=scenario.getName();
			LOGGER.info("Loading the properties file");
			CommonUtilities.getcommInstance().loadProperties();
			LOGGER.info("Checking the DRIVER is null or not");
			if ((DriverManager.getDriver()) == null) {
				LOGGER.info("DRIVER is null. Instantiating it! ");
				DriverManager.launchBrower();
				CommonUtilities.getcommInstance().InitWebElements();
				login();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void login() throws InterruptedException {
		DriverManager.getDriver().get(Constants.App_URL);
		Thread.sleep(10000);
	
		LoginPage.getLoginInstance().enterUserName(Constants.UserName);
		LoginPage.getLoginInstance().enterPasswrd(Constants.Password);
		LoginPage.getLoginInstance().clicLoginBtn();
		
	}
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			byte[] screenshotTaken= ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", "Failed_sceanrio");
		}
		
	}
}
