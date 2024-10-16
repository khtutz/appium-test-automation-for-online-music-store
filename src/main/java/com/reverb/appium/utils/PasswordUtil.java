package com.reverb.appium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

public class PasswordUtil {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()_+-=[]|,./?>";
	private static final int PASSWORD_LENGTH = 12;
	
	public static String generateRandomPassword() {
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
		
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			password.append(CHARACTERS.charAt(
					random.nextInt(CHARACTERS.length())));
		}
		
		return password.toString();
	}
	
	public static void storeEncryptedPassword(String password) throws Exception {
		String filePath = getAuthFilePath("auth");
		String encryptedPassword = EncryptionUtil.encrypt(password);
        Properties prop = new Properties();
        prop.setProperty("encryptedPassword", encryptedPassword);
        
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            prop.store(fos, null);
        }
    }
	
	public static boolean storeValueIntoProperties(
			String propertiesType, 
			String key, 
			String value) {
		String filePath = getAuthFilePath(propertiesType);
        Properties prop = new Properties();
        prop.setProperty(key, value);
        
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            prop.store(fos, null);
            return true;
        } catch (Exception e) {
        	System.out.println(e);
        	return false;
        }
    }
	
	public static String getValueFromProperties(
			String propertiesType, 
			String key) throws FileNotFoundException, IOException {
		String filePath = getAuthFilePath(propertiesType);
		Properties prop = new Properties();
		
		try (FileInputStream fis = new FileInputStream(filePath)) {
	        prop.load(fis);
	    }
		
		return prop.getProperty(key);
	}
	
	private static String getAuthFilePath(String propertiesType) {
		String projectPath = System.getProperty("user.dir");
		return projectPath + 
				"/src/main/java/com/reverb/appium/resources/" + 
				propertiesType + ".properties";
	}
}
