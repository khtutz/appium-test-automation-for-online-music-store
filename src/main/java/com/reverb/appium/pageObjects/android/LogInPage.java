package com.reverb.appium.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.reverb.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogInPage extends AndroidActions {
	AndroidDriver driver;
	
	public LogInPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log In to Reverb\"]")
	WebElement titleLogIn;
	
	@AndroidFindBy(id = "user_session_login")
	WebElement txtEmail;
	
	@AndroidFindBy(id = "password")
	WebElement txtPassword;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Log In\"]")
	WebElement btnLogIn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reset it\"]")
	WebElement btnResetPassword;
	
	public String getLogInPageTitle() {
		return titleLogIn.getText();
	}
	
	public void logIn(
			String email,
			String password
	) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogIn.click();
	}
	
	public void loadLogInPage() {
		activityAction("com.reverb.app/.login.LoginActivity");
	}
}
