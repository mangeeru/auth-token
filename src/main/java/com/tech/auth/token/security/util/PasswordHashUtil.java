package com.tech.auth.token.security.util;

import java.util.Base64;

import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.encrypt.BouncyCastleAesGcmBytesEncryptor;

public class PasswordHashUtil {

	private static final int SALT_LENGTH = 16;
	private static final int HASH_LENGTH = 32;
	private static final int PARALLELISM = 1;
	private static final int DEFAULT_MEMORY = 1 << 12;
	private static final int DEFAULT_ITERATIONS = 10;

	private String aesPassword;// encrypted password
	private CharSequence aesSalt;

	public PasswordHashUtil() {
		super();
	}

	public PasswordHashUtil(String aesPassword, CharSequence aesSalt) {
		super();
		this.aesPassword = aesPassword;
		this.aesSalt = aesSalt;
	}

	/**
	 * it will convert normal password String into encrypted password
	 * 
	 * @param pwdString password String
	 * @return return encrypted password
	 */
	public String generateHash(String pwdString) {
		BouncyCastleAesGcmBytesEncryptor bytesEncryptor = new BouncyCastleAesGcmBytesEncryptor(aesPassword, aesSalt);

		Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(SALT_LENGTH, HASH_LENGTH, PARALLELISM,
				DEFAULT_MEMORY, DEFAULT_ITERATIONS);

		String shaHexString = Sha512DigestUtils.shaHex(pwdString);
		String pwdHashString = passwordEncoder.encode(shaHexString);
		byte[] pwdHashBytesString = bytesEncryptor.encrypt(pwdHashString.getBytes());
		String hashedEncryptedPwd = new String(pwdHashBytesString);

		return hashedEncryptedPwd;
	}

	/**
	 * 
	 * @param pwdString
	 * @param hashedString
	 * @return will return boolean value
	 */
	public boolean verifyHash(String pwdString, String hashedString) {
		
		BouncyCastleAesGcmBytesEncryptor bytesEncryptor = new BouncyCastleAesGcmBytesEncryptor(aesPassword, aesSalt);

		Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(SALT_LENGTH, HASH_LENGTH, PARALLELISM,
				DEFAULT_MEMORY, DEFAULT_ITERATIONS);

		String shaHexString = Sha512DigestUtils.shaHex(pwdString);
		
		byte[] base64decodedString = Base64.getDecoder().decode(hashedString);
		byte[] aesDecryptedStringBytes = bytesEncryptor.decrypt(base64decodedString);
		
		String aesDecryptedString = new String(aesDecryptedStringBytes);
		
		if(passwordEncoder.matches(shaHexString, aesDecryptedString)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param pwdString
	 * @param hashedStrings array of hashed passwords
	 * @return will return boolean value
	 */
	public boolean verifyHash(String pwdString, String[] hashedStrings) {
		
		BouncyCastleAesGcmBytesEncryptor bytesEncryptor = new BouncyCastleAesGcmBytesEncryptor(aesPassword, aesSalt);

		Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(SALT_LENGTH, HASH_LENGTH, PARALLELISM,
				DEFAULT_MEMORY, DEFAULT_ITERATIONS);

		String shaHexString = Sha512DigestUtils.shaHex(pwdString);
		
		for(String hashedString : hashedStrings) {
			byte[] base64decodedString = Base64.getDecoder().decode(hashedString);
			byte[] aesDecryptedStringBytes = bytesEncryptor.decrypt(base64decodedString);
			
			String aesDecryptedString = new String(aesDecryptedStringBytes);
			if(passwordEncoder.matches(shaHexString, aesDecryptedString)) {
				return true;
			}
		}
		return false;
		
	}

}
