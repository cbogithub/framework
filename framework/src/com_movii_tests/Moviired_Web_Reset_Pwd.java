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
import com_movii_pages.Moviired_Web_Home_Page;

public class Moviired_Web_Reset_Pwd extends Movii_Core_Page{

	Moviired_Web_Home_Page obj= new Moviired_Web_Home_Page();
	
	@BeforeClass(alwaysRun=true)
	public void isSkip() throws MalformedURLException, IOException
	{
		if(!TestUtil.isExecutable("Moviired_Web_Reset_Pwd"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
		else
		{
			moviRedWeb();
			Movii_Core_Page.logger=Movii_Core_Page.report.createTest("Moviired_Web_Reset_Pwd","Test Case for reset pwd");
		}
	}
	
	@Test(priority=1)
	public void  reset_pwd_verification()
	{
		obj.reset_pwd();
		Movii_Core_Page.logger.log(Status.INFO, "Reset password");
	}

	@AfterClass(alwaysRun=true)
	public void afterMethod()
	{
		if(w_driver!=null)
		{
		Movii_Core_Page.report.flush();
		System.out.println("Moviired_Web_Reset_Pwd Test Complete");
		w_driver.quit();
		} 
	}
	
}
