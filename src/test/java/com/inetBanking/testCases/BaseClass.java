package com.inetBanking.testCases;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.inetBankingV1.pageObject.AddCustomer;

//import org.apache.logging.log4j.Logger;

import com.inetBankingV1.pageObject.LoginPage;
import com.inetBankingV1.utilities.ReadConfig;
public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
//	public String baseUrl = "https://demo.guru99.com/v4/index.php";
//	public String Username = "mngr430294";
//	public String password = "YzybYdE";
	
	public String  baseUrl = readconfig.getApplicationUrl() ;
	String baseurll = baseUrl.replaceAll("[;]", " "); 
	public String Username = readconfig.getUserName() ;
	public String password=  readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	public LoginPage lp;
	public AddCustomer cust;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		//System.getProperty("user.dir")+"//Drivers//chromedriver.exe"
	    logger = Logger.getLogger("ebanking");
		//logger =  (Logger) LogManager.getLogger(BaseClass.class.getName());
	    
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")){
			System.setProperty("webdriver.edge.driver",readconfig.getIEpath());
			driver = new EdgeDriver();
		}
		//driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("browser closed");
	}
	public void capturescreen(WebDriver driver ,String tname) throws IOException {
		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+Timestamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	
	public static String randomestring(){
	    String generatedString1 = RandomStringUtils.randomAlphabetic(5);
	    return(generatedString1);
	}

	public static String randomeNum(){	    String generatedString1 = RandomStringUtils.randomNumeric(10);	  
	return(generatedString1);
	}
	
	

}
