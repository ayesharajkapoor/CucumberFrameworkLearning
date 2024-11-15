package com.lao.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lao.utilities.CommonUtilities;

public class LoginPage {
	
	private static LoginPage LoginPageInstance;
	
	private  LoginPage() {

	}
	
	public static LoginPage getLoginInstance() {
		if(LoginPageInstance==null) {
			LoginPageInstance= new LoginPage(); 
		}
		
		return LoginPageInstance;
		
	}
	@FindBy(name = "username")
	private  WebElement USERNAME;
	@FindBy(name = "password")
	private  WebElement PASSWORD;
	@FindBy(xpath="//button")
	private  WebElement LOGIN_BTN;
	/*
	 * public WebElement getUSERNAME() { return USERNAME; } public WebElement
	 * getPASSWORD() { return PASSWORD; } public WebElement getLOGIN_BTN() { return
	 * LOGIN_BTN; }
	 */
	
	public void enterUserName(String name) {
		CommonUtilities.getcommInstance().highLightElement(USERNAME);
		USERNAME.sendKeys(name);
		
	}
	public void enterPasswrd(String pwd) {
		CommonUtilities.getcommInstance().highLightElement(PASSWORD);
		PASSWORD.sendKeys(pwd);
		
	}
	public void clicLoginBtn() {
		CommonUtilities.getcommInstance().highLightElement(LOGIN_BTN);
		LOGIN_BTN.click();
		
	}

}
