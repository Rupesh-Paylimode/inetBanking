package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//Utility class read the properties from Configuration file and provide the values to baseClass.

public class ReadConfig {

	Properties properties = new Properties();

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {

			FileInputStream fis = new FileInputStream(src);
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Ecxeption is " + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String url = properties.getProperty("baseURL");
		return url;
	}

	public String getUserName() {
		String userName = properties.getProperty("userName");
		return userName;
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = properties.getProperty("chromepath");
		return chromepath;
	}

	public String getFireFoxPath() {
		String firefoxPath = properties.getProperty("firefoxpath");
		return firefoxPath;
	}
}
