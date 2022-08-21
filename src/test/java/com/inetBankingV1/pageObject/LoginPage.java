package com.inetBankingV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement Userid;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnReset;
	@FindBy(xpath = "//a[contains(text(),\"Log out\")]")
	@CacheLookup
	WebElement Logout;
	//a[contains(text(),"Log out")]
	
	public void setUserid(String id) {
		Userid.sendKeys(id);
	}
	public void setPwd(String pwd) {
		password.sendKeys(pwd);
	}
	public void setlogin() {
		btnLogin.click();;
	}
	public void setReset() {
		btnReset.click();
	}
	public void setLogout() {
		Logout.click();
	}
}
