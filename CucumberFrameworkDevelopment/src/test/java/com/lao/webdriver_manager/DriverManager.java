package com.lao.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.lao.constants.Constants;

public class DriverManager {
	
	public static WebDriver driver=null;
	private static final Logger LOGGER=LogManager.getFormatterLogger(DriverManager.class);
	public static void launchBrower() {
		try {
			switch (Constants.Browser) {
			case "Chrome":
				System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
				LOGGER.info("Launching the browser : " +Constants.Browser);
				driver = new ChromeDriver();

				break;
			case "FireFox":

				System.setProperty(Constants.FIREFOX_DRIVER, Constants.FIREFOX_DRIVER_LOCATION);
				LOGGER.info("Launching the browser : " +Constants.Browser);
				driver = new FirefoxDriver();
				break;

			case "edge":

				System.setProperty(Constants.EDGE_DRIVER, Constants.EDGE_DRIVER_LOCATION);
				LOGGER.info("Launching the browser : " +Constants.Browser);
				driver = new EdgeDriver();
				break;
			default:
				System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
				LOGGER.info("Launching the browser : " +Constants.Browser);
				driver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}

}
