package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObject.AddCustomer;
import com.inetBankingV1.pageObject.LoginPage;

public class Login_Test_003 extends BaseClass{

	
	@Test
	public void AddCust() throws InterruptedException, IOException {
	
	driver.get(baseurll);
	driver.manage().window().maximize();
	logger.info("url opened");
	lp =new LoginPage(driver);
	lp.setUserid(Username);
	lp.setPwd(password);
	Thread.sleep(2000);
	lp.setlogin();
	Thread.sleep(2000);
	logger.info("login details entered");
	cust = new AddCustomer(driver);
	cust.SetNewcust();
	cust.SetName("Rajkumar");
	cust.setGender("Male");
	cust.SetDob("17","08","1976");
	Thread.sleep(5000);
	cust.SetAddr("Lig 120 BHEL");
	cust.SetCity("Hyderabad");
	cust.Setstate("Andhra");
	cust.SetPin("500032");
	String num = randomeNum();
	cust.SetTelephone(num);
	Thread.sleep(10000);
	String email = randomestring()+"@gmail.com";
	cust.SetEmail(email);
	cust.SetPwd("rajkumar9");
	cust.SetSubmit();
	logger.info("Clicked on submit");
	Thread.sleep(10000);
	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	if(res==true) {
		logger.info("Customer Added");
		Assert.assertTrue(true);
	}
	else  {
		
		capturescreen(driver,"AddCust");
		Assert.assertTrue(false);
	}
	
	
}
}