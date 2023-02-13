package com.amazonTestCases;

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
		public static WebDriver driver;
		
		@BeforeClass
		public void setup() {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		@AfterClass
		public void teardown() {
			driver.quit();
			
		}
}
