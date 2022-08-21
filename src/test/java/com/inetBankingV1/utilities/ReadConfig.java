package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
     public ReadConfig() {
	File src = new File("./Configuration/config.properties");

	try
	{
	FileInputStream fis = new FileInputStream(src); 
pro = new Properties();	
pro.load(fis);
	}
 catch (Exception e){
	 System.out.println("exception"+e.getMessage());
 }
}

 public String getApplicationUrl() {
	String baseurl = pro.getProperty("baseURL");
	return baseurl;
 }
 public String getUserName() {
		String username = pro.getProperty("Username");
		return username;
	 }
 public String getPassword() {
		String Password = pro.getProperty("Password");
		return Password;
	 }
 public String getChromepath() {
		String chromepath = pro.getProperty("Chromepath");
		return chromepath;
	 }
 public String getIEpath() {
		String IEpath = pro.getProperty("IEpath");
		return IEpath;
	 }
 public String getFirefoxpath() {
		String Firefoxpath = pro.getProperty("Firefoxpath");
		return Firefoxpath;
	 }
}
