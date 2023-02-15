package com.amazonPageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class amazonCompleteFlow {
	WebDriver ldriver;
	//WebDriverWait w = new WebDriverWait(ldriver,Duration.ofSeconds(20));
	public amazonCompleteFlow(WebDriver rDriver){
		ldriver = rDriver;
		PageFactory.initElements(rDriver,this);
	}
	
	//Page Factory - Object Repository:
	@FindBy(id = "twotabsearchtextbox")
	WebElement SearchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement SearchButton;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
	WebElement SearchedProduct;
	
	@FindBy(xpath = "//*[@id=\"p_36/1318507031\"]/span/a/span")
	WebElement FilterByPrice;
	
	@FindBy(xpath = "//*[@id=\"color_name_1\"]")
	WebElement SelectGoldColor;
	
	@FindBy(xpath = "//*[@id=\"color_name_3\"]")
	WebElement SelectBlackColor;
	
	@FindBy(xpath = "//*[@id=\"color_name_2\"]")
	WebElement SelectWhiteColor;
	
	@FindBy(xpath = "//*[@id=\"size_name_1\"]")
	WebElement size128GB;
	
	@FindBy(xpath = "//*[@id=\"size_name_2\"]")
	WebElement size256GB;
	
	@FindBy(xpath = "//*[@id=\"size_name_3\"]")
	WebElement size512GB;
	
	@FindBy(name = "submit.add-to-cart")
	WebElement addToCartButton;

	@FindBy(xpath = "*[@id=\"attach-sidesheet-checkout-button\"]/span/input")
	WebElement proceedToCheckout;
	
	@FindBy(xpath = "*[@id=\"sw-gtc\"]/span/a")
	WebElement goToCart;
	
	@FindBy(xpath = "//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")
	WebElement cart;
	
	@FindBy(id = "nav-cart-count")
	WebElement viewcart;
	
	@FindBy(xpath = "*[@id=\"sc-active-C110de225-a71c-40e8-be96-f7b1cf144c1d\"]/div[4]/div/div[3]/ul/li[5]/span/span[2]")
	WebElement productColor;
	
	@FindBy(xpath = "*[@id=\"sc-active-C110de225-a71c-40e8-be96-f7b1cf144c1d\"]/div[4]/div/div[3]/ul/li[6]/span/span[2]")
	WebElement productSize;
	
	@FindBy(xpath = "*[@id=\"a-autoid-0-announce\"]/span[2]")
	WebElement productQuantity;
	
	@FindBy(xpath = "//*[@id=\"sc-buy-box-ptc-button-announce\"]/div/div[1]")
	WebElement proceedToBuy;
	
	@FindBy(xpath = "*[@id=\"add-new-address-popover-link\"]")
	WebElement addAddressButton;

	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement fullName;
	
	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
	WebElement phoneNumber;

	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
	WebElement postalCode;
	
	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressLine1\"]")
	WebElement addAddressLine1;
	
	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressLine2\"]")
	WebElement addAddressLine2;
	
	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressCity\"]")
	WebElement city;
	
	@FindBy(xpath = "*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span/span")
	WebElement state;
	
	@FindBy(xpath = "*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
	WebElement useThisAddress;
	
	//function to search product
	public boolean searchBox(String searchItem) throws InterruptedException {
		Thread.sleep(5000);
		SearchBox.sendKeys(searchItem);
		Thread.sleep(5000);
		SearchButton.click();
		Thread.sleep(500);
		return true;
	}
	
	//function to filter results by price
	public void filterByPrice() {
		FilterByPrice.click();
	}
	
	//function to add product to cart
	public boolean addToCart(String itemColor, String itemSize) throws InterruptedException {
		
	    
	    Thread.sleep(10000);
	    
		//select color
		if (itemColor.toUpperCase().equals("GOLD")) {
			if (SelectGoldColor.isEnabled()) {
				SelectGoldColor.click();
			}
		}
		else if(itemColor.toUpperCase().contains("BLACK")) {
			if (SelectBlackColor.isEnabled()) {
				SelectBlackColor.click();
			}
			
		}
		else if(itemColor.toUpperCase().equals("WHITE")) {
			if (SelectWhiteColor.isEnabled()) {
				SelectWhiteColor.click();
			}
			
		}
		Thread.sleep(10000);
		
		//select size
		if(itemSize.equals("256")) {
			if(size256GB.isEnabled()) {
				size256GB.click();
		}
			else {
				System.out.print("Size option disabled");
			}
		}
		else if (itemSize.equals("128")) {
			if(size128GB.isEnabled()) {
				size128GB.click();
		}
			else {
				System.out.print("Size option disabled");
			}
			
		}
		else if(itemSize.equals("512")) {
			if(size512GB.isEnabled()) {
				size512GB.click();
		}
			else {
				System.out.print("Size option disabled");
			}	
		}
		Thread.sleep(5000);
		
		//click on add to cart button
		addToCartButton.click();
		Thread.sleep(5000);
		
		//click on goto cart button
		if(cart.isDisplayed()) {
			cart.click();
		}
		
		Thread.sleep(5000);
		return true;
	}
	
	public boolean validateProductColor(String itemColor) {
		String getProductcolor = ldriver.findElement(By.xpath("//*[@class='a-size-small' and contains(text(),'"+itemColor+"')]")).getText();  //fetch color
		//condition to validate color
		 if(getProductcolor.equals(itemColor)) {
			 return true;
		}
		else {
			return false;		
		}	
	}
	public boolean validateProductSize(String itemSize) {
		String getItemSize = ldriver.findElement(By.xpath("//*[@class='a-size-small' and contains(text(),'"+itemSize+"')]")).getText();  //fetch size
		//condition to validate size
		 if(getItemSize.equals(itemSize+" GB")) {
			 return true;
		}
		else {
			return false;		
		}	
	}
	
	public boolean validateProductQuantity(String quantity) {
		String getItemQuantity = ldriver.findElement(By.xpath("//*[@class='a-dropdown-prompt' and contains(text(),'"+quantity+"')]")).getText();  //fetch quantity
		//condition to validate quantity
		 if(getItemQuantity.equals(quantity)) {
			 return true;
		}
		else {
			return false;		
		}	
	}
	
	public boolean addAddress(String fname, String phoneNo, String postalcode, String addressLine1Val, String addressLine2Val, String cityVal, String stateVal) throws InterruptedException {
		
	    // presenceOfElementLocated condition
	    //w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")));
		ldriver.findElement(By.name("proceedToRetailCheckout")).click();
		/*addAddressButton.click();
		Thread.sleep(3000);
		fullName.sendKeys(fname);
		Thread.sleep(1000);
		phoneNumber.sendKeys(phoneNo);
		Thread.sleep(1000);
		postalCode.sendKeys(postalcode);
		Thread.sleep(1000);
		addAddressLine1.sendKeys(addressLine1Val);
		Thread.sleep(1000);
		addAddressLine2.sendKeys(addressLine2Val);
		Thread.sleep(1000);
		city.sendKeys(cityVal);
		Thread.sleep(2000);
		Select dropdown = new Select(state);
		dropdown.selectByValue(stateVal);
		useThisAddress.click();
		Thread.sleep(5000);*/
		return true;
		
	}
		
}
