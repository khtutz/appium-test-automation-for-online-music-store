package com.reverb.appium.tests.android;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.reverb.appium.pageObjects.android.HomePage;
import com.reverb.appium.pageObjects.android.ProfilePage;
import com.reverb.appium.pageObjects.android.SignUpPage;
import com.reverb.appium.testUtils.AndroidBaseTest;
import com.reverb.appium.utils.EncryptionUtil;
import com.reverb.appium.utils.PasswordUtil;

/*
 * Prerequisite to run the test case:
 * - App must be closed [At android device]
 * - No account must be signed in [At android device]
 * - Following data field must be provided [At test case]:
 *   - First name
 *   - Last name
 *   - Email
 *   - Password
 *   - Opt in/out promotion choice
 */
public class SignUpTestCase extends AndroidBaseTest {
	@Test
	public void testSignUp() throws Exception {
		// Home > My Reverb > Log in > Sign up
		
		// Load home page
		HomePage homePage = new HomePage(driver);
		
		// Load sign-up page
		SignUpPage signUpPage = homePage.loadMainPage()
										.loadSignUpPage();
		
		String pageTitle = signUpPage.getSignUpPageTitle();
		assertEquals(pageTitle, "Sign Up", "Mismatch title at Sign Up page");
		
		// Fill and submit sign-up form
		String firstName = "Adam";
		String lastName = "Smith";
		String email = "wotilon587@craftapk.com";
		String randomPassword = PasswordUtil.generateRandomPassword();
		boolean promotion = false;
		
		signUpPage.fillFormAndSignUp(
				firstName, 
				lastName, 
				email, 
				randomPassword, 
				promotion);
		
		// Check for correct profile name that represents successful account registration
		ProfilePage profilePage = new ProfilePage(driver);
		String fullName = firstName + " " + lastName;
		boolean profileNameDisplayed = profilePage.profileNameDisplayed(fullName);
		assertEquals(profileNameDisplayed, true, "Profile does not load correctly");
		
		// After successful account signup, encrypt the password
		// and save it inside properties
		if (profileNameDisplayed) {
			String encryptedPassword = EncryptionUtil.encrypt(randomPassword);
			PasswordUtil.storeValueIntoProperties(
					"auth", 
					"encryptedPassword", 
					encryptedPassword);
		}
		
	}
}
