package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class KeyGenerator {
	
	public void generateKey(String path) throws Exception{
		
		
		
        byte[] salt = new byte[8];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        FileOutputStream saltOutFile = new FileOutputStream(path+"\\key1.enc");
        saltOutFile.write(salt);
        saltOutFile.close();
	}
	
	public String getKey(File key) throws Exception{
		
		Scanner scanner = new Scanner(key);
		String content = scanner.useDelimiter("\\A").next();
		scanner.close();
				
		
		return content;
	}



}
