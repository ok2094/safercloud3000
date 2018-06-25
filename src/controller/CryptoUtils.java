package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
	private static final String Algorithm = "AES", Transformation = "AES";

	public static File encrypt(String key, File inputFile, File outputFile) throws Exception {
		File encrypted =doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
	return encrypted;
	}

	public static void decrypt(String key, File inputFile, File outputFile) throws Exception {
		doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
	}

	public static File doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
		Key secretKey = new SecretKeySpec(key.getBytes(), Algorithm);
		Cipher cipher = Cipher.getInstance(Transformation);
		cipher.init(cipherMode, secretKey);

		FileInputStream inStream = new FileInputStream(inputFile);
		byte[] inputBytes = new byte[(int) inputFile.length()];
		inStream.read(inputBytes);

		byte[] outputBytes = cipher.doFinal(inputBytes);

		FileOutputStream outStream = new FileOutputStream(outputFile);
		outStream.write(outputBytes);
		inStream.close();
		outStream.close();
		return outputFile;
		
		

	}

}
