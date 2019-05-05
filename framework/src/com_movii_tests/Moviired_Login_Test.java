package com_movii_tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;
import com_movii_pages.Moviired_Login_Page;

public class Moviired_Login_Test extends Movii_Core_Page
{

	Moviired_Login_Page login_obj = new Moviired_Login_Page();

	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException
	{
		if (!TestUtil.isExecutable("Moviired_Login_Test"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		} 
		else
		{
			moviRed();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Login", "Test Case for Login");
		}
	}

	@Test(priority = 1)
	public void login_verification() throws Exception
	{
		login_obj.login();
	}
	
	/*@Test(priority = 2, dependsOnMethods  = {"login_verification"})
	public void logout_verification() throws IOException
	{
		login_obj.logout();
	}*/


	@AfterClass(alwaysRun = true)
	public void afterMethod() 
	{
		if(driver!=null)
		{
		Movii_Core_Page.report.flush();
		System.out.println("Test Complete");
		driver.quit();
		} 
	}


}
