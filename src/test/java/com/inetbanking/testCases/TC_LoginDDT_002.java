package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData") // if TC contains multiple dataprovider methods then method doesnt know from
										// which method we have to take the data. So, it is necessary to mention the
										// dataprovider in @Test with methodname
	public void loginDDT(String user, String pwd) throws Exception {

		LoginPage loginPage = new LoginPage();
		loginPage.setUserName(user);
		loginPage.setPassword(pwd);
		loginPage.clickSubmit(btnlog);

		Thread.sleep(3000);
		
		//After executing isAlertPresent method
		
		if (isAlertPresent() == true) //condition false 
		{
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent(); //move to original login window
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			loginPage.clickLogout(btnlogout);
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logour alert
			driver.switchTo().defaultContent();
		}
	}

	// Checking of Alert Window
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginDetails.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", rownum);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0 In 2D array, it starts from 0
																				// while in Excel sheet, it starts from
																				// 1
			}
		}
		return logindata;
	}

}
