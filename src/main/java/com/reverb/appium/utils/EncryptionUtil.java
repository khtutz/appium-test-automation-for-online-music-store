package com.reverb.appium.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {
	private static final String KEY = System.getenv("APPIUM_JAVA_REVERB_ENCRYPTION_KEY");
	
	public static String encrypt(String plainPassword) throws Exception {
		SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedValue = cipher.doFinal(plainPassword.getBytes());
		
		return Base64.getEncoder().encodeToString(encryptedValue);
	}
	
	public static String decrypt(String encryptedPassword) throws Exception {
		SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decodedValue = Base64.getDecoder().decode(encryptedPassword);
		byte[] decryptedValue = cipher.doFinal(decodedValue);
		
		return new String(decryptedValue);
	}
}
