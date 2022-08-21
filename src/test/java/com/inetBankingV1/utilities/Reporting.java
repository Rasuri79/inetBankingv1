package com.inetBankingV1.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;





import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import extentreports.Reporting;

public class Reporting extends TestListenerAdapter {

	
public	ExtentHtmlReporter htmlreporter;
public 	ExtentReports extent;// specify the location of the report
public 	ExtentTest test;// what details should be populated in the report
	
	
	public void onStart(ITestContext  testContext)
	
	{
		
	String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	String repname = "Test-Report-"+Timestamp+".html";
		//String path = System.getProperty("user.dir")+"/test-output/"+repname;
	
	    htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
	    htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	    htmlreporter.config().setDocumentTitle("Automation reports");
	    htmlreporter.config().setReportName("Function Test Report");
	    htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	    htmlreporter.config().setTheme(Theme.DARK);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlreporter);
	    extent.setSystemInfo("Host Name","LocalHost");
	    extent.setSystemInfo("Environment","QA");
	    extent.setSystemInfo("User Name","Rajkumar");
	    extent.setSystemInfo("Browser","chrome");
	    
	}
	
	
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//send the passed information to the report with GREEN color highlighted
	}

	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String Screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(Screenshotpath); 
		if(f.exists()) {
			try {
			test.fail("Screenshot is below :"+test.addScreenCaptureFromPath(Screenshotpath));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		}
	}

	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName()); // create new entry in th report
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	
	public void onFinish(ITestContext testContext)
	{
	    extent.flush();
	}
	
}
	
	
	