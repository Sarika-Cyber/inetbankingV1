package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");

		lp.clickButton();
		logger.info("Login button is clicked");
		String HomePageTitle=driver.getTitle();
		System.out.println(HomePageTitle);
		logger.info("Home page title is printed");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test is passed");
			}
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test is failed");
			
		}


	}


}
