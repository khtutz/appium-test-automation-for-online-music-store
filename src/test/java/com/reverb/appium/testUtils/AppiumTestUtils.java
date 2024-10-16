package com.reverb.appium.testUtils;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumTestUtils {
	private static final String appiumJsFilePath = "//usr//local//lib//node_modules//appium//build//lib//main.js";
	private AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(appiumJsFilePath))
				.withIPAddress(ipAddress)
				.usingPort(port)
				.build();
		service.start();
		
		return service;
	}
}
