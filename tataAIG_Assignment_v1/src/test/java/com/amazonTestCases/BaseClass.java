package com.amazonTestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

		public String baseURL = "https://amazon.in";
		public String SearchedItem = "Iphone 14 pro 128gb";
		public String SearchedItemColor = "Space Black";
		public String SearchedItemSize = "128";
		public String quantityAdded = "1";
		public String full_name = "Sabi Mustaqeem";
		public String phone_No = "9871789742";
		public String postal_code = "110006";
		public String address_Line1Val = "Test Address Street";
		public String address_Line2Val = "Test Address Landmark";
		public String cityVal = "Delhi";
		public String stateVal = "Delhi";
		public static WebDriver driver;
		public static Logger logger;
		@BeforeClass
		public void setup() {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			logger = Logger.getLogger("amazonFlow");
			PropertyConfigurator.configure("Log4j.properties");
			
		}
		
		@AfterClass
		public void teardown() {
			driver.quit();
			
		}
}
