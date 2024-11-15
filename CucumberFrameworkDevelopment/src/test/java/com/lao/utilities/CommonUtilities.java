package com.lao.utilities;


import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.lao.constants.Constants;
import com.lao.pageobjects.DirectoryPage;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.pageobjects.TimePage;
import com.lao.step_definitons.Common_Step_Definitions;
import com.lao.webdriver_manager.DriverManager;

public class CommonUtilities {

	private static CommonUtilities commInstance=null;
	private CommonUtilities() {
		
	}
	public static CommonUtilities getcommInstance() {
		
		if(commInstance==null) {
			commInstance= new CommonUtilities();
		}
		return commInstance;
		
	}
	public  void loadProperties() {

		Properties prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		Constants.App_URL = prop.getProperty("App_URL");
		Constants.Browser = prop.getProperty("BROWSER");
		Constants.UserName = prop.getProperty("UserNAme");
		Constants.Password = prop.getProperty("Password");
		Constants.CHROME_DRIVER_LOCATION = prop.getProperty("CHROME_DRIVER_LOCATION");
		Constants.FIREFOX_DRIVER_LOCATION = prop.getProperty("FIREFOX_DRIVER_LOCATION");
		Constants.EDGE_DRIVER_LOCATION = prop.getProperty("EDGE_DRIVER_LOCATION");
	}
	
	public void InitWebElements() {
		
		PageFactory.initElements(DriverManager.getDriver(),LoginPage.getLoginInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomePageInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getDirectoryPageInstance());
		PageFactory.initElements(DriverManager.getDriver(), TimePage.getTimeInstance());
		
	}
	public void toTakeScreenshot() {
		
		File screenshot= ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Definitions.getScenarioName()+".png"));
			
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		
	}
	public void highLightElement(WebElement element) {
		JavascriptExecutor exeutor=(JavascriptExecutor) DriverManager.getDriver();
		exeutor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}
}
