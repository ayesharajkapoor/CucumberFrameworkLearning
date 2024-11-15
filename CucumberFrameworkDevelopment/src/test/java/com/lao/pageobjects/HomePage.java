package com.lao.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;
import com.lao.utilities.CommonUtilities;
import com.lao.webdriver_manager.DriverManager;

public class HomePage {
	
	private static HomePage HomePageInstance;
	private HomePage() {
		
	}
	public static HomePage getHomePageInstance() {
		
		if(HomePageInstance==null) {
			HomePageInstance= new HomePage();
		}
		return HomePageInstance;
		
	}
	
	/*
	 * @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a")
	 * private WebElement DIRECTORY;
	 */
	
	By DIRECTORY=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a");
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")
	private WebElement Time;

	/*
	 * public WebElement getDIRECTORY() { return DIRECTORY; }
	 */
	public void clickDirectory() {
		try {
			CommonUtilities.getcommInstance().highLightElement(DriverManager.getDriver().findElement(DIRECTORY));
			(DriverManager.getDriver().findElement(DIRECTORY)).click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Element is not visible try to add wait"); 
			try {
				
			WebDriverWait wait=new WebDriverWait(DriverManager.
					getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(DIRECTORY));
			
			} catch (NoSuchElementException e2) {
				e.printStackTrace();
				System.out.println("Still element is not able to found");
			}
		}
		
		

	}
	
	public void clickTime() {
		CommonUtilities.getcommInstance().highLightElement(Time);
		Time.click();		
	}

}
