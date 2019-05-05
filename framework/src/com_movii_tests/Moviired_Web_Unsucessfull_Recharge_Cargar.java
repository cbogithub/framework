package com_movii_tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;
import com_movii_pages.Moviired_Web_Login_Page;

public class Moviired_Web_Unsucessfull_Recharge_Cargar extends Movii_Core_Page {
	Moviired_Web_Login_Page Moviired_login_obj = new Moviired_Web_Login_Page();

	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException {
		if (!TestUtil.isExecutable("Moviired_Web_Unsucessfull_Recharge_Cargar")) {

			throw new SkipException("Skipping the test as the Run mode is No");

		} else {
			moviRedWeb();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Moviired_Web_Unsucessfull_Recharge_Cargar", "Test Case for Moviired_Web_Unsucessfull_Recharge_Cargar");
		}
	}

	@Test(priority = 1)
	public void login_verification() throws IOException {
		Moviired_login_obj.login();

		Movii_Core_Page.logger.log(Status.INFO, "Logged In");
	}
   
	@Test(dependsOnMethods= {"login_verification"})
	public void Unsucessfull_Recharge_verification() throws IOException {
		Moviired_login_obj.Unsucessfull_Recharge_CargarENLinea();
		Movii_Core_Page.logger.log(Status.INFO, "Logged In");
	}

	@AfterClass(alwaysRun = true)
	public void afterMethod() {
		if(w_driver!=null)
		{
		Movii_Core_Page.report.flush();
		System.out.println("Moviired_Web_Unsucessfull_Recharge_Cargar Test Complete therefore closing this session");
		w_driver.quit();
		} 
	}
}
