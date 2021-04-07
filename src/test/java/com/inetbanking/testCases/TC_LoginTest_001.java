package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		driver.get(baseURL);

		LoginPage loginPage = new LoginPage();

		loginPage.setUserName(userName);
		loginPage.setPassword(password);

		loginPage.clickSubmit(btnlog);
		
		if (driver.getTitle().equals("Guru99 Bank Manager Home Page")) {
			System.out.println("Title" + "Guru99 Bank Manager Home Page" );
		} else {
			captureScreenShots (driver,"loginTest");
			System.out.println("Page can not be displayed");
		}

	}

}
