package com.reverb.appium.pageObjects.android;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.reverb.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductSortPage extends AndroidActions {
	AndroidDriver driver;
	
	public ProductSortPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
	private WebElement rbBestMatch;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
	private WebElement rbMostRecent;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[3]")
	private WebElement rbPriceLowToHigh;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[4]")
	private WebElement rbPriceHighToLow;
	
	public void sortByBestMatch() {
		rbBestMatch.click();
	}
	
	public void sortByMostRecent() {
		rbMostRecent.click();
	}
	
	public void sortByPriceLowToHigh() {
		rbPriceLowToHigh.click();
	}
	
	public void sortByPriceHighToLow() {
		rbPriceHighToLow.click();
	}
}
