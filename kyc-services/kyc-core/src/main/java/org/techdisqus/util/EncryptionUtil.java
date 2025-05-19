package org.techdisqus.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class EncryptionUtil {
	
	@Autowired
	public EncryptionCredentials encryptionCredentials;
	
	@Autowired
	EncryptionCredentials digitalWalletTokenEncryptionCredentials;
	
	@Autowired
	private Environment environment;
	
	public Environment getEnvironment() {
		return environment;
	}


	
	public String encrypt(String value) {
        try {
        	
            Cipher cipher = getCihper(Cipher.ENCRYPT_MODE);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            return  Base64.getEncoder().encodeToString(encrypted);
            
        } catch (Exception e) {
        	//logger.error("Failed to encrypt", e);
        }

        return null;
    }


	public String decrypt(String encrypted) {
        try {
        	
        	Cipher cipher = getCihper(Cipher.DECRYPT_MODE);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
            
        } catch (Exception e) {
        	//logger.error("Failed to decrypt", e);
        }

        return null;
    }
	
	public String encryptDigitalWalletToken(String value) {
        try {
        	
            Cipher cipher = getDigitalWalletTokenCihper(Cipher.ENCRYPT_MODE);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            return  Base64.getEncoder().encodeToString(encrypted);
            
        } catch (Exception e) {
        	//logger.error("Failed to encrypt", e);
        }

        return null;
    }


	public String decryptDigitalWalletToken(String encrypted) {
        try {
        	
        	Cipher cipher = getDigitalWalletTokenCihper(Cipher.DECRYPT_MODE);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
            
        } catch (Exception e) {
        	//logger.error("Failed to decrypt", e);
        }

        return null;
    }
	
	private Cipher getCihper(int mode) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		
    	String key = encryptionCredentials.getKey(); // 128 bit key
    	String initVector = encryptionCredentials.getInitVector(); // 16 bytes IV
    	
    	IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
    	
    	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    	cipher.init(mode, skeySpec, iv);
    	return cipher;
    }
	
	private Cipher getDigitalWalletTokenCihper(int mode) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		
    	String key = digitalWalletTokenEncryptionCredentials.getKey(); // 128 bit key
    	String initVector = digitalWalletTokenEncryptionCredentials.getInitVector(); // 16 bytes IV
    	
    	IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
    	
    	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    	cipher.init(mode, skeySpec, iv);
    	return cipher;
    }


//	public EncryptionUtil(EncryptionCredientials encryptionCredientials) {
//		super();
//		this.encryptionCredientials = encryptionCredientials;
//	}
//	public EncryptionUtil() {
//		super();
//	}
	
//	public MockReadWriteService(String path) {
//		super();
//		this.path = path;
//	}
//
//	public MockReadWriteService() {
//		super();
//	}
}
