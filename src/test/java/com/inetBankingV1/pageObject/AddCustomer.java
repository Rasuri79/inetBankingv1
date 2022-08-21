package com.inetBankingV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	public WebDriver driver;
	
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement NewCust;
	@FindBy(name ="name")
	@CacheLookup
	WebElement CustName;
	
	@FindBy(xpath = "//input[@value='m']")
	@CacheLookup
	WebElement MaleRadio;
	
	@FindBy(xpath = "//input[@value='f']")
	@CacheLookup
	WebElement FemaleRadio;
	
	@FindBy(xpath ="//input[@name='dob']")
	@CacheLookup
	WebElement Dob;
	
	@FindBy(xpath ="//textarea[@name='addr']")
	@CacheLookup
	WebElement Address;
	
	@FindBy(xpath ="//input[@name='city']")
	@CacheLookup
	WebElement City;
	
	@FindBy(xpath ="//input[@name='state']")
	@CacheLookup
	WebElement State;
	
	@FindBy(xpath ="//input[@name='pinno']")
	@CacheLookup
	WebElement PinNo;
	@FindBy(xpath ="//input[@name='telephoneno']")
	@CacheLookup
	WebElement Telephone;
	
	@FindBy(xpath ="//input[@name='emailid']")
	@CacheLookup
	WebElement EmailId;
	
	@FindBy(xpath ="//input[@name='password']")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath ="//input[@name='sub']")
	@CacheLookup
	WebElement Submit;
	
	
	public AddCustomer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SetNewcust() {
	  NewCust.click();
	}
	public void SetName(String name) {
		CustName.sendKeys(name);
	}
	
	
	public void setGender(String Gender) {

		if (Gender.equals("Male")) {
			MaleRadio.click();

		} else if (Gender.equals("Female")) {
			FemaleRadio.click();

		} 
	}
	
	public void SetDob(String mm,String dd,String yyyy) {
		Dob.sendKeys(mm);
		Dob.sendKeys(dd);
		Dob.sendKeys(yyyy);
	}
	public void SetAddr(String addr) {
		Address.sendKeys(addr);
	}
	public void SetCity(String city) {
		City.sendKeys(city);
	}
	public void Setstate(String state) {
		State.sendKeys(state);
	}
	public void SetPin(String pin) {
		PinNo.sendKeys(pin);
	}
	
	public void SetTelephone(String num) {
		Telephone.sendKeys(num);
	}
	
	public void SetEmail(String email) {
		EmailId.sendKeys(email);
	}
	public void SetPwd(String pwd) {
		Password.sendKeys(pwd);
	}
	public void SetSubmit() {
		Submit.click();
	}
	
	
}
