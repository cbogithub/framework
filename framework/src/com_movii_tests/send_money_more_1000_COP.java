package com_movii_tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;
import com_movii_pages.Enviar_Dinero;

public class send_money_more_1000_COP extends Movii_Core_Page {
	Enviar_Dinero obj = new Enviar_Dinero();

	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException {
		if (!TestUtil.isExecutable("Movii_EnviarDinero_Value_less_1000_COP_Test")) {
			throw new SkipException("Skipping the test as the Run mode is No");
		}
		else {
			movi();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Movii_EnviarDinero_Value_less_1000_COP_Test", "Test Case for Movii_EnviarDinero_Value_less_then_1000_COP_Test");
		}
	}
// User should not be able to send money below the minimum value that is 1000 COP.
	@Test(priority = 1)
	public void successfull_send_money_above_minimum_1000_COP() throws IOException
	{
		obj.send_money_value_more_or_equal_1000_COP();
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
