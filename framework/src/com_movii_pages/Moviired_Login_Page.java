package com_movii_pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;

public class Moviired_Login_Page {

	public By field_username = By.id("txt_username");
	public By field_pwd = By.id("txt_pass");
	public By signin = By.id("btn_signIn");
	// public By closeButton = By.id("com.movilred.subscriber:id/iconClose");
	// public By tuDinero = By.id("com.movilred.subscriber:id/opt_title");
	String message = "RECARGAS";
	public By RECARGAS_A_PRODUCTOS = By.id("com.movilred.merchant:id/textView");

	public void login() throws Exception {
		try {

			System.out.println("Welcome to Moviired native application");
			Movii_Core_Page.driver.findElement(field_username)
					.sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
			Movii_Core_Page.logger.log(Status.PASS, "Entered Username Successfully");

			Movii_Core_Page.driver.findElement(field_pwd).sendKeys(Movii_Core_Page.config.getProperty("moviired_pwd"));
			Movii_Core_Page.logger.log(Status.PASS, "Entered Password Successfully");

			Movii_Core_Page.driver.findElement(signin).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Sign In Successfully");

			if (Movii_Core_Page.driver.findElement(RECARGAS_A_PRODUCTOS).getText().contains(message)) {
				System.out.println(
						"user: " + Movii_Core_Page.config.getProperty("moviired_user") + " logged im sucessfully");
				TestUtil.logAndCaptureScreenshot("Logged In Successfully", "Pass");
			} else {
				System.out.println("Login Test fail");
				Assert.fail("User Login fails");
			}

		} catch (Exception e) {
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			throw e;
		}
	}


}
