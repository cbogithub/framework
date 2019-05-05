package com_movii_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com_movii_framework.CommonFunctions;
import com_movii_framework.Movii_Core_Page;

public class Movii_CargarCuenta_Page {
	public static By cargarCuenta = By.xpath(
			"(//*[@id='list_options1']/*/*/*[@id='opt_image' and ./parent::*[./parent::*[@id='main_content']]])[2]");
	public static By cargarlinea = By.xpath("(//*[@id='list']/*/*/*/*[@id='title'])[1]");

	public static By amountTextbox = By.xpath("//*[@id='txt_value']");
	public static By continuar = By.xpath("//*[@id='btnContinue'] | //*[@id='btn_continue']");
	public static By centrodepagos = By.xpath(
			"//*[@text and @class='android.view.View' and ./parent::*[@text and ./parent::*[@id='encabezado']]]");
	public static By cargarAliado = By.xpath("//*[@text='Ir a un punto aliado']");
	public static By cargarBalato = By.xpath("//*[@text='En puntos Baloto de\\ntiendas y farmacias']");
	public static By cargarPuntoMas = By.xpath("//*[@text='Ir al punto más cercano']");
	public static By cargarPuntoMovi = By.xpath("//*[@text='Ir a un punto MOVii']");
	
	
	String amount = "100";

	public void cargarEnLinea() {
		try {
			Movii_Core_Page.driver.findElement(cargarCuenta).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Cuenta");
			Movii_Core_Page.driver.findElement(cargarlinea).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Linea");
			Movii_Core_Page.driver.findElement(amountTextbox).sendKeys(amount);
			Movii_Core_Page.logger.log(Status.PASS, "Entered amount "+amount);
			Movii_Core_Page.driver.findElement(continuar).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Continue");
			Movii_Core_Page.driver.findElement(continuar).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar");
			
			Thread.sleep(5000);
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Assert.assertTrue(CommonFunctions.isDisplayed(centrodepagos));
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Movii_Core_Page.logger.log(Status.PASS, "Url is "+Movii_Core_Page.driver.getCurrentUrl());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("User Login fails");
		}
	}

	public void cargarAlido() {
		try {
			Movii_Core_Page.driver.findElement(cargarCuenta).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Cuenta");
			Movii_Core_Page.driver.findElement(cargarAliado).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Aliado");
			Movii_Core_Page.driver.findElement(cargarBalato).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Balato");
			Movii_Core_Page.driver.findElement(cargarPuntoMas).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Punto Mas");

			Thread.sleep(5000);
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Movii_Core_Page.logger.log(Status.PASS, "Url is " + Movii_Core_Page.driver.getCurrentUrl());
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("User Login fails");
		}

	}
	
	public void cargarPuntoMovi() {
		try {
			Movii_Core_Page.driver.findElement(cargarCuenta).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Cuenta");
			Movii_Core_Page.driver.findElement(cargarPuntoMovi).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Punto Movi");
			Movii_Core_Page.driver.findElement(cargarPuntoMas).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Cargar Punto Mas");

			Thread.sleep(5000);
		
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("User Login fails");
		}

	}

}
