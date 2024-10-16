package com.reverb.appium.tests.android;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.reverb.appium.pageObjects.android.HomePage;
import com.reverb.appium.pageObjects.android.LogInPage;
import com.reverb.appium.pageObjects.android.ProfilePage;
import com.reverb.appium.testUtils.AndroidBaseTest;
import com.reverb.appium.utils.EncryptionUtil;
import com.reverb.appium.utils.PasswordUtil;

public class LogInTestCase extends AndroidBaseTest {
	@Test
	public void testLogIn() throws Exception {
		// Home > My Reverb > Log in > Log in
		
		// Load home page
		HomePage homePage = new HomePage(driver);
		
		// Load log-in page
		LogInPage logInPage = homePage.loadMainPage()
									  .loadLogInPage();
		
		String pageTitle = logInPage.getLogInPageTitle();
		assertEquals(pageTitle, "Log In to Reverb", "Mismatch title at Log In page");	
		
		// Get encrypted password and decrypt it, and log in
		String firstName = "Adam";
		String lastName = "Smith";
		String email = "wotilon587@craftapk.com";
		String encryptedPassword = PasswordUtil.getValueFromProperties(
				"auth", 
				"encryptedPassword");
		String password = EncryptionUtil.decrypt(encryptedPassword);
		logInPage.logIn(email, password);
		
		// Confirm successful log in
		ProfilePage profilePage = new ProfilePage(driver);
		String fullName = firstName + " " + lastName;
		boolean profileNameDisplayed = profilePage.profileNameDisplayed(fullName);
		assertEquals(profileNameDisplayed, true, "Profile does not load correctly");
	}
}
