package com.reverb.appium.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils {
	
	IOSDriver driver;
	
	public IOSActions(IOSDriver driver) {
		this.driver = driver;
	}
	
	public void longPressAction(WebElement element) {
		Map<String,Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) element).getId());
		params.put("duration", 5);
			
		driver.executeScript("mobile:touchAndHold", params);
	}

	public void scrollToEndAction(String direction, float percent) {
		boolean canScrollMore;
		
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
				 "mobile: scrollGesture", ImmutableMap.of(
						 "left", 100, 
						 "top", 100, 
						 "width", 200, 
						 "height", 200,
						 "direction", direction,
						 "percent", percent
			));
		} while(canScrollMore);
	}
	
	public void scrollToWebElement(WebElement element) {
		Map<String,Object> params = new HashMap<>();
		params.put("direction", "down");		
		params.put("element", ((RemoteWebElement) element).getId());
		
		driver.executeScript("mobile:scroll", params);
	}
	
	
	public void swipeAction(WebElement element, String direction) {
		Map<String,Object> params = new HashMap<String,Object> ();
		params.put("direction", direction);
		params.put("element", ((RemoteWebElement) element).getId());
		
		driver.executeScript("mobile:swipe", params);
	}

}
