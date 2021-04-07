package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.BaseClass;

public class LoginPage extends BaseClass{


	//public static final String txtBoxUserID = "//input[@name='uid']";
	//public static final String txtBoxPassword = "//input[@name='password']";
	//public static final String loginbtn = "//input[@name='btnLogin']";

	
	public void setUserName(String uname) {
		WebElement userName = driver.findElement(By.xpath("//input[@name='uid']"));
		userName.sendKeys("mngr266311");
	}

	public void setPassword(String pswd) {
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("YvuzYtY");
	}

	public void clickSubmit(String btnlog) {
		WebElement login = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		login.click();
	}
	public void clickLogout(String btnlogout) {
		WebElement logout = driver.findElement(By.xpath("//a[text()='Log out']"));
		logout.click();
	}
}
