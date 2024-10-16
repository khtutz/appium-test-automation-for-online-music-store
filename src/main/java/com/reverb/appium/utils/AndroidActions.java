package com.reverb.appium.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void longPressAction(WebElement element, int duration) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(), 
				"duration", duration
		));
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
	
	public void scrollToText(String txt) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + txt + "\"))"));
	}
	
	public void swipeAction(WebElement element, String direction, float percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			"elementId", ((RemoteWebElement) element).getId(),
		    "direction", direction,
		    "percent", percent
		));
	}
	
	public void dragAndDropAction(WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId(),
		    "endX", x,
		    "endY", y
		));
	}
	
	public void activityAction(String packageAndActivity) {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
		    "intent", packageAndActivity
		));
	}
}
