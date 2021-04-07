package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();

	// Reading the variables from ReadConfig class
	/*
	 * public static final String baseURL = "http://demo.guru99.com/V4/"; 
	 * public static final String userName = "mngr266311";
	 * public static final String password = "YvuzYtY";
	 */

	public static WebDriver driver;
	public static final String btnlog = "loginbtn";
	public static final String btnlogout = "logoutbtn";
	public static Logger logger;

	//@Parameters("browsers")
	@BeforeClass
	public void setUp() {
		

			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(baseURL);

			/*
			 * logger = Logger.getLogger("ebanking");
			 * propertycongfigurator.configure("Log4j.properties");
			 */
		} 
	/*else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(baseURL);
		}*/
		


	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
//Capturing screenshot is common for all TCs.
	
	public void captureScreenShots(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
