package com.reverb.appium.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumTestUtils {
	protected AppiumDriverLocalService service;
	protected AndroidDriver driver;
	
	@BeforeClass
	public void configureAppiumForInspection() throws URISyntaxException, MalformedURLException {		
		// Start appium server manually
		
		// Set up uiautomator2 options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android Device");
		
		// Set up android driver
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void configureAppium() throws IOException {
		// Load properties
		final String propertiesFilePath = "//src//main//java//com//udemy//appium//resources//data.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propertiesFilePath);
		prop.load(fis);
		
		// Start appium server
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
		// Set up uiautomator2 options
		String androidDeviceName = prop.getProperty("androidRealDevice");
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(androidDeviceName);
		
		// Set up android driver
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		// To uncomment only when appium server is started
		// automatically from AppiumTestUtils.startAppiumServer()
		//service.stop();
	}
}
