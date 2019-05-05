package com_movii_pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com_movii_framework.Movii_Core_Page;

public class Movii_Hamburger_Flow_Page {

	public static By modificarClaveMovii = By.xpath("(//*[@id='com.movilred.subscriber:id/opt_title'])[1]");
	public static By claveMoviiActual = By.id("com.movilred.subscriber:id/txt_pass");
	public static By claveMoviiNew = By.id("com.movilred.subscriber:id/txt_pass_new");
	public static By claveMoviiRepeat = By.id("com.movilred.subscriber:id/txt_pass_repeat");
	public static By saveButton = By.id("com.movilred.subscriber:id/btn_save_key");
	
	public void successfulPasswordChange() {
		try {
			System.out.println("Welcome to Movii application for successfull login method ");
			Movii_Core_Page.driver.findElement(Movii_Login_Page.hamburger).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Hamburger");
			Movii_Core_Page.driver.findElement(modificarClaveMovii).click();
			Movii_Core_Page.logger.log(Status.PASS, "Modificar Clave Movii Clicked");
			Movii_Core_Page.driver.findElement(claveMoviiActual).sendKeys("1234");
			Movii_Core_Page.logger.log(Status.PASS, "Clave Movii Actual");
			Movii_Core_Page.driver.findElement(claveMoviiNew).sendKeys("1234");;
			Movii_Core_Page.logger.log(Status.PASS, "Nueva Clave Movii");
			Movii_Core_Page.driver.findElement(claveMoviiRepeat).sendKeys("1234");
			Movii_Core_Page.logger.log(Status.PASS, "Repetir nueva Clave Movii");
			System.out.println();
		} catch (Exception e) {
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			Assert.fail("User Login fails");
		}
	}

}
