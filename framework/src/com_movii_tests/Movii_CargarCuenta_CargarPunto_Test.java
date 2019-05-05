package com_movii_tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;
import com_movii_pages.Movii_CargarCuenta_Page;
import com_movii_pages.Movii_Login_Page;

public class Movii_CargarCuenta_CargarPunto_Test extends Movii_Core_Page
{
	Movii_Login_Page login_obj = new Movii_Login_Page();
	Movii_CargarCuenta_Page cargar = new Movii_CargarCuenta_Page();

	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException {
		if (!TestUtil.isExecutable("Movii_CargarCuenta_CargarPunto_Test")) {
			throw new SkipException("Skipping the test as the Run mode is No");
		}
		else {
			movi();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Movii_CargarCuenta_CargarPunto_Test", "Test Case for Cargar Punto");
		}
	}

	@Test(priority = 1)
	public void cargarPunto() throws IOException {
		login_obj.success_login();
		cargar.cargarPuntoMovi();
		
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
