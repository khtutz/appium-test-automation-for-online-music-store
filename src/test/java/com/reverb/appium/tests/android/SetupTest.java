package com.reverb.appium.tests.android;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.reverb.appium.pageObjects.android.HomePage;
import com.reverb.appium.testUtils.AndroidBaseTest;

public class SetupTest extends AndroidBaseTest {
	@Test
	public void testSetup() {
		// Udemy Video: 69
		// https://www.automationtestinghub.com/first-appium-test-script/
		
		/*
		 * Activity - Video: 41
		 * Command: adb shell dumpsys window | grep -E 'mCurrentFocus'
		 */
		
		//
		// Home Page Testing
		try {
			HomePage homePage = new HomePage(driver);
			homePage.loadMainPage();;

		} catch (Exception e) {
			System.out.println("********************");
			System.out.println(e);
			System.out.println("********************");
			assertEquals(false, true);
		}
	}
}
