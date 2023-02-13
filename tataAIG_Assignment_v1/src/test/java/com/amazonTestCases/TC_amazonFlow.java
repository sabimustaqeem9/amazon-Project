package com.amazonTestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazonPageObjects.amazonCompleteFlow;

import junit.framework.Assert;

public class TC_amazonFlow extends BaseClass {
	
	@Test
	public void amazonFlow() throws InterruptedException {
		driver.get(baseURL);
		
		amazonCompleteFlow obj = new amazonCompleteFlow(driver);
		obj.searchBox(SearchedItem);
		//System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Amazon.in : "+SearchedItem)) {
			Assert.assertTrue(true);	
		}
		else {
			Assert.assertTrue(false);	
		}
		
		//Get list of webEelements to select the right product
		 List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		 for(WebElement link:allLinks){
		 //System.out.println(link.getText());
		 if(link.getText().toUpperCase().contains(SearchedItem.toUpperCase())) {
			 System.out.println(link.getText());
			 link.click();
			 Thread.sleep(500);
			 System.out.println("Searched item found");
			 break;
		 }
		 }
		 
		 //filter by price
		 obj.filterByPrice();
		
		//switch to new tab
		Thread.sleep(5000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(1));
		
	    //add to cart
	    obj.addToCart(SearchedItemColor, SearchedItemSize);
	    
	    //validate checkout page
	    obj.validateCheckoutDetails(SearchedItemColor, SearchedItemSize, quantityAdded);
}
	}
