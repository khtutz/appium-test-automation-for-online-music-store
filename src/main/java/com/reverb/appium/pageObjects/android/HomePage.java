package com.reverb.appium.pageObjects.android;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.reverb.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidActions {
	AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"OptInButton\"]/android.widget.Button")
	private WebElement btnOptIn;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"OptOutButton\"]/android.widget.Button")
	private WebElement btnOptOut;
	
	@AndroidFindBy(id = "com.reverb.app:id/navigation_bar_item_large_label_view")
	private WebElement lblHomeMenuLarge;
	
	@AndroidFindBy(id = "com.reverb.app:id/mi_tab_my_reverb")
	private WebElement menuMyReverb;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View/android.widget.Button")
	private WebElement btnLogInOrSignUp;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[2]/android.widget.Button")
	private WebElement btnSignUp;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.widget.Button")
	private WebElement btnLogIn;
	
	@AndroidFindBy(id = "com.reverb.app:id/mi_search")
	private WebElement iconSearch;
	
	@AndroidFindBy(id = "com.reverb.app:id/et_search_focus_input")
	private WebElement txtSearch;
	
	public HomePage loadMainPage() {
		activityAction("com.reverb.app/.browse.BrowseActivity");
		return this;
	}
	
	public HomePage notifyMe() {
		btnOptIn.click();
		return this;
	}
	
	public HomePage cancelNotification() {
		try {
			btnOptOut.click();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		
		return this;
	}
	
	public boolean checkIfHomePageIsLoaded() {
		// Large label if the current location is at 'Home', else small label
		try {
			return lblHomeMenuLarge.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public SignUpPage loadSignUpPage() {
		menuMyReverb.click();
		btnLogInOrSignUp.click();
		btnSignUp.click();
		return new SignUpPage(driver);
	}
	
	public LogInPage loadLogInPage() {
		menuMyReverb.click();
		btnLogInOrSignUp.click();
		btnLogIn.click();
		return new LogInPage(driver);
	}
}
