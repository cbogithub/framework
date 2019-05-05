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
import com_movii_pages.Movii_Recargas_Cellular_Page;

public class Movii_RecargarCelular_Paquetes_Datos extends Movii_Core_Page
{
	Movii_Login_Page login_obj = new Movii_Login_Page();
	Movii_Recargas_Cellular_Page obj= new Movii_Recargas_Cellular_Page();
	
	@BeforeClass(alwaysRun = true)
	public void isSkip() throws MalformedURLException, IOException {
		if (!TestUtil.isExecutable("Movii_RecargarCelular_Paquetes_Datos")) {
			throw new SkipException("Skipping the test as the Run mode is No");
		}
		else {
			movi();
			Movii_Core_Page.logger = Movii_Core_Page.report.createTest("Movii_RecargarCelular_Paquetes_Datos", "Test Case for Recargar Celular Productos");
		}
	}

	@Test(priority = 1)
	public void cargarAlido() throws IOException {
		login_obj.success_login();
		obj.Recharge_Paquetes_Datos();;
		
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
