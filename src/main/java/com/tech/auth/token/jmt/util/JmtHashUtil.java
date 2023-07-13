package com.tech.auth.token.jmt.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmtHashUtil {

	private static final Logger _logger = LoggerFactory.getLogger(JmtHashUtil.class);

	private static final String secret = "jup!terS@turn";
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void setKey(/*final String myKey*/) {
		MessageDigest sha = null;
		try {
			key = secret.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-256");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			_logger.info(e.getMessage(), e);
		}
	}

	public static String encrypt(final String strToEncrypt/*, final String secret*/) {
		try {
			setKey(/*secret*/);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(final String strToDecrypt/*, final String secret*/) {
		try {
			setKey(/*secret*/);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

}
