package com.inetBanking.testCases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObject.LoginPage;

public class Login_test_001 extends BaseClass{
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		driver.get(baseurll);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("url opened");
		lp =new LoginPage(driver);
		lp.setUserid(Username);
		lp.setPwd(password);
		Thread.sleep(2000);
		lp.setlogin();
		Thread.sleep(2000);
		logger.info("login details entered");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("title is correct");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.info("test failed");
			capturescreen(driver ,"LoginTest");
			Assert.assertTrue(false);
		}
		
	}//<listeners>
    //<listener class-name="listners.Listeners"/>
//</listeners>

}
