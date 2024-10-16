package com.reverb.appium.tests.android;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.reverb.appium.pageObjects.android.HomePage;
import com.reverb.appium.testUtils.AndroidBaseTest;

public class HomeTestCase extends AndroidBaseTest {
	@Test
	public void testHomePageLoading() {
		HomePage homePage = new HomePage(driver);
		homePage.loadMainPage();//.cancelNotification();
		
		assertEquals(
				homePage.checkIfHomePageIsLoaded(), 
				true, 
				"The home page is not loaded correctly");
	}
}
