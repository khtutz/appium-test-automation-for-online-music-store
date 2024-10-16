package com.reverb.appium.pageObjects.android;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.reverb.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchResultPage extends AndroidActions {
	AndroidDriver driver;
	
	public SearchResultPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sort\"]")
	private WebElement btnSort;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Filter\"]")
	private WebElement btnFilter;
	
	public void notifyMe() {
		
	}
}
