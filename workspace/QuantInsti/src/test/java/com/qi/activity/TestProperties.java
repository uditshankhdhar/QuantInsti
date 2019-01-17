package com.qi.activity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		
		
		Properties config =new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		Properties OR =new Properties();
		fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		System.out.println(OR.getProperty("LoginBtn"));
	}

}
