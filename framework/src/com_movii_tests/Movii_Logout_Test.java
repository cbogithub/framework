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

public class Movii_Logout_Test extends Movii_Core_Page
{
	Movii_Login_Page login_obj = new Movii_Login_Page();

	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException {
		if (!TestUtil.isExecutable("Movii_Logout_Test")) {
			throw new SkipException("Skipping the test as the Run mode is No");
		} else {
			movi();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Successfully Logout", "Test Case for User Successfully Logout");
		}
	}

	@Test
	public void login_verification() throws IOException {
		login_obj.success_login();
	}
	
	@Test(dependsOnMethods= {"login_verification"})
	public void logout_verification() throws IOException {
		login_obj.user_logout();
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
