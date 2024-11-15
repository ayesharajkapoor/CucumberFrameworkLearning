package com.lao.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lao.utilities.CommonUtilities;

public class TimePage {
	
	private static TimePage timeInstance=null;
	private TimePage() {
		
	}
	public static TimePage getTimeInstance() {
		if(timeInstance==null) {
			timeInstance = new TimePage();
		}
		return timeInstance;
	}
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input")
	private WebElement employeeName;
	
	
	@FindBy(how = How.CSS, using = " div.oxd-autocomplete-text-input--after")
	private WebElement firstRecord;
	
	public void enterEmployeeName(String name) throws InterruptedException {
		CommonUtilities.getcommInstance().highLightElement(employeeName);
		employeeName.click();
		employeeName.sendKeys(name);
		Thread.sleep(5000);
		//firstRecord.click();
		
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button")
	private WebElement viewBtn;

	public void clickView() {
		CommonUtilities.getcommInstance().highLightElement(viewBtn);
		viewBtn.click();
		
	}
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/div/div[1]/p")
	private WebElement NoTimeSheet;
	
	public String viewNoTimsheet() {
		
		String noRecord=NoTimeSheet.getText();
		return noRecord;
		
	}
}
