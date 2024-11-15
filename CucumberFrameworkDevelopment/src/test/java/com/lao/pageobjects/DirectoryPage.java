package com.lao.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.lao.utilities.CommonUtilities;
import com.lao.webdriver_manager.DriverManager;

public class DirectoryPage {
	private static DirectoryPage DirectoryPageInstance;

	private DirectoryPage() {
	}

	public static DirectoryPage getDirectoryPageInstance() {

		if (DirectoryPageInstance == null) {
			DirectoryPageInstance = new DirectoryPage();
		}
		return DirectoryPageInstance;

	}

	@FindBy(how = How.CSS, using = "div.oxd-autocomplete-text-input")

	private WebElement Employee_Name;

	@FindBy(how = How.CSS, using = "input[placeholder='Type for hints...'']")
	private WebElement Employee_Name_Input;

	@FindBy(how = How.CSS, using = "button[type=submit]")
	private WebElement SearchButton;

	@FindBy(how = How.CSS, using = "div.oxd-grid-item.oxd-grid-item--gutters")
	private List<WebElement> firstRecord;




	

	/*
	 * public WebElement getEmployee_Name() { return Employee_Name; }
	 * 
	 * public WebElement getEmployee_Name_Input() { return Employee_Name_Input; }
	 * 
	 * public WebElement getSearchButton() { return SearchButton; }
	 * 
	 * public List<WebElement> getFirstRecord() { return firstRecord; }
	 */

	public void clickEmployeeNAme() {
		CommonUtilities.getcommInstance().highLightElement(Employee_Name);
		Employee_Name.click();

	}

	public void clickSearch() {
		CommonUtilities.getcommInstance().highLightElement(SearchButton);
		SearchButton.click();
	}

	public boolean ValidateRcord() {
		boolean result = false;
		result = firstRecord.get(3).isDisplayed();

		return result;

	}

	
}
