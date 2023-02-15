package com.amazonTestCases;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazonPageObjects.amazonCompleteFlow;

import junit.framework.Assert;

public class TC_amazonFlow extends BaseClass {
	public boolean flag;
	@Test
	public void amazonFlow() throws InterruptedException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		amazonCompleteFlow obj = new amazonCompleteFlow(driver);
		boolean searchCheck = obj.searchBox(SearchedItem);
		if (searchCheck) {
	    	logger.info("PASS: Product searched successfully");			
		}
		else{
	    	logger.info("FAIL: Product could not be searched");	
		}
		
		if(driver.getTitle().equals("Amazon.in : "+SearchedItem)) {
			logger.info("PASS: Searched Item page opened");	
		}
		else {
			logger.info("PASS: Searched Item page did not open");	
		}
		
		//Get list of webEelements to select the right product
		 List <WebElement> allLinks = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")); //and contains(text(),'"+SearchedItem+"')
		 for(WebElement link:allLinks){
		 
		 if(link.getText().toUpperCase().contains(SearchedItem.toUpperCase())) {
			 System.out.println(link.getText());
			 link.click();
			 flag = true;
			 Thread.sleep(500);
			 logger.info(SearchedItem+" product found");
			 break;
		 }
		 }
		 if (flag = false) {
			 
			 Assert.assertTrue(false);
			 logger.info(SearchedItem+" product not found");
		 }
		 //filter by price
		 obj.filterByPrice();
		
		//switch to new tab
		Thread.sleep(5000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(1));
		
	    //add to cart
	    boolean addToCartCheck = obj.addToCart(SearchedItemColor, SearchedItemSize);
	    if(addToCartCheck) {
	    	logger.info("PASS: Product added to cart");	
	    }
	    else {
	    	logger.info("FAIL: Product added to cart");
	    }
	    
	    //validate color
	    boolean colorCheck = obj.validateProductColor(SearchedItemColor);
	    if (colorCheck) {
	    	logger.info("PASS: Color validated");	
	    }
	    else {
	    	logger.info("FAIL: Color not correct");	
	    }
	    
	  //validate size
	    boolean sizeCheck = obj.validateProductSize(SearchedItemSize);
	    if (sizeCheck) {
	    	logger.info("PASS: Size validated");	
	    }
	    else {
	    	logger.info("FAIL: Size not correct");	
	    }
	    
	  //validate quantity
	    boolean quantityCheck = obj.validateProductQuantity(quantityAdded);
	    if (quantityCheck) {
	    	logger.info("PASS: Quantity validated");	
	    }
	    else {
	    	logger.info("FAIL: Quantity not correct");	
	    }
	    
	    //add new address
	    boolean addAddressCheck = obj.addAddress(full_name,phone_No,postal_code,address_Line1Val,address_Line2Val,cityVal,stateVal);
	    if (addAddressCheck) {
	    	logger.info("PASS: Proceed to checkout");		
	    }
	    else {
	    	logger.info("FAIL: Proceed to checkout");
	    }
}
	}
