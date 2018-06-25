package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.util.Scanner;

public class KeyGenerator {
	
	public void generateKey(String path) throws Exception{
		
		
		
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        FileOutputStream saltOutFile = new FileOutputStream(path+"\\key1.enc");
        saltOutFile.write(salt);
        saltOutFile.close();
	}
	
	public String getKey(File key) throws Exception{
		
		FileInputStream fis = new FileInputStream(key);
		byte[] data = new byte[(int) key.length()];
		fis.read(data);
		fis.close();

		String content = new String(data, "UTF-8");
		
		return content;
	}



}
