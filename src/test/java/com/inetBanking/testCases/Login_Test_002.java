package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObject.LoginPage;
import com.inetBankingV1.utilities.XLUtils;


public class Login_Test_002 extends BaseClass{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
		driver.get(baseurll);
		driver.manage().window().maximize();
		lp =new LoginPage(driver);
		lp.setUserid(user);
		lp.setPwd(pwd);
		logger.info("user & pwd entered");
		lp.setlogin();
		Thread.sleep(3000);
		logger.info("clicked on login button");
		
		if(isAlertPresent()==true) {
			
			capturescreen(driver ,"loginDDT");
			logger.warn("wrong credentials");
			driver.switchTo().alert().accept();
			
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.setLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			logger.info("succesfully logged out");
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBankingV1/testData/Logintestdata.xlsx";
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colnum = XLUtils.getCellCount(path,"Sheet1",1);
		
		String LoginData[][] = new String[rownum][colnum];
		for(int i=1;i<rownum;i++) {
			
			for(int j=0;j<colnum;j++) {
				
				LoginData[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);//1,0
			}
		
		
			}
		return LoginData;
	}
	
}
