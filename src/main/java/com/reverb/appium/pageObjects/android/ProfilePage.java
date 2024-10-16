package com.reverb.appium.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.reverb.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends AndroidActions {
	AndroidDriver driver;
	
	public ProfilePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public boolean profileNameDisplayed(String profileName) {
		String dynamicXPath = "//android.widget.TextView[@text=\"" + profileName + "\"]";
	    List<WebElement> elements = driver.findElements(By.xpath(dynamicXPath));
	    if (elements.isEmpty()) {
	    	return false;
	    }
	    return true;  
	}
}
