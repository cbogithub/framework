package com_movii_tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;
import com_movii_pages.Movii_Login_Page;
import com_movii_pages.Movii_TuDinero_Page;

public class Movii_TuDinero_Successful_transaction extends Movii_Core_Page
{

	Movii_Login_Page login_obj = new Movii_Login_Page();
	Movii_TuDinero_Page dinero = new Movii_TuDinero_Page();

	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException {
		if (!TestUtil.isExecutable("Movii_TuDinero_Successful_transaction")) {
			throw new SkipException("Skipping the test as the Run mode is No");
		}
		else {
			movi();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Movii_TuDinero_Successful_transaction", "Test Case for successfull transaction Tu Dinero");
		}
	}

	@Test(priority = 1)
	public void sucessful_transaction() throws IOException {
		login_obj.success_login();
		dinero.TuDinero_Successful_transaction();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterMethod() {
		if(driver!=null)
		{
		Movii_Core_Page.report.flush();
		System.out.println("Test Complete");
		driver.quit();
		} 
	}
}
