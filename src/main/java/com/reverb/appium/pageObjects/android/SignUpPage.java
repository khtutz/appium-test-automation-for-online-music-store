package com.reverb.appium.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.reverb.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends AndroidActions {
	AndroidDriver driver;
	
	public SignUpPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.reverb.app:id/tv_login_signup_title")
	WebElement titleSignUp;
	
	@AndroidFindBy(id = "com.reverb.app:id/et_log_in_signup_first_name")
	WebElement txtFirstName;
	
	@AndroidFindBy(id = "com.reverb.app:id/et_log_in_signup_last_name")
	WebElement txtLastName;
	
	@AndroidFindBy(id = "com.reverb.app:id/et_log_in_signup_email")
	WebElement txtEmail;
	
	@AndroidFindBy(id = "com.reverb.app:id/pet_log_in_signup_password")
	WebElement txtPassword;
	
	@AndroidFindBy(id = "com.reverb.app:id/cb_log_in_news_letter_signup")
	WebElement chkbxPromotions;
	
	@AndroidFindBy(id = "com.reverb.app:id/cb_log_in_singup_agree_to_terms")
	WebElement chkbxTAndC;
	
	@AndroidFindBy(id = "com.reverb.app:id/btn_login_signup")
	WebElement btnSignUp;
	
	public String getSignUpPageTitle() {
		return titleSignUp.getText();
	}
	
	public void fillFormAndSignUp(
			String firstName,
			String lastName,
			String email,
			String password,
			boolean promotion
	) {
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		
		// Scroll down to make other elements visible
		scrollToEndAction("down", 1.0f);
		
		if (promotion) {
			chkbxPromotions.click();
		}
		
		chkbxTAndC.click();
		btnSignUp.click();
	}
	
	public void loadSignUpPage() {
		activityAction("com.reverb.app/.login.LoginActivity");
	}
}
