package com_movii_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com_movii_framework.Movii_Core_Page;

public class Movii_Recargas_Cellular_Page {
	// By Recargarcelular = By.id("com.movilred.subscriber:id/opt_title");
	By Recargarcelular = By.xpath("//*[contains(text(),'Recargar')]");
	// By celular= By.id("com.movilred.subscriber:id/opt_title");
	By celular = By.xpath("//*[@text='Recargar celular']");
	// By claro= By.id("com.movilred.subscriber:id/img_icon");
	By paquetes = By.xpath("//*[@text='Paquetes, voz y datos']");
	By productos = By.xpath("//*[@text='Otros Productos']");

	By claro = By.xpath("(//*[@id='list']/*/*/*[@id='img_icon'])[1]");
	By Numero = By.id("com.movilred.subscriber:id/txt_recharge_number");
	By usarelmio = By.id("com.movilred.subscriber:id/my_phone");
	By recarga = By.id("com.movilred.subscriber:id/txt_recharge_value");
	By continu = By.id("com.movilred.subscriber:id/btn_continue_send");
	By confirmarecargar = By.id("com.movilred.subscriber:id/btn_recharge");

	By Recargaexitosa = By.id("com.movilred.subscriber:id/lbl_title");
	By finalizar = By.id("com.movilred.subscriber:id/btn_finish");

	By paquetesVozNumero = By.xpath("//*[@id='txt_phone']");
	By paquetesVozContinue = By.xpath("//*[@text='Continuar']");
	By tigo = By.xpath("(//*[@id='rcv_packages_operator']/*/*/*[@id='img_icon'])[1]");
	By voz = By.xpath("//*[@id='layout_package' and ./*[@text='Voz']]");
	By datos = By.xpath("//*[@text='Datos']");
	By vozDatos = By.xpath("//*[@text='Voz y Datos']");
	By packet = By.xpath("(//*[@id='rcv_list_packages']/*/*/*[@id='txt_description' and (./preceding-sibling::* | ./following-sibling::*)[@id='divider_duration']])[1]");
	By comprar = By.xpath("//*[@text='COMPRAR']");
	By recargar = By.xpath("//*[@text='Recargar']");

	String expectedrecharge = "Recarga";
	String exp = "Confirmar";
	String actmsg = "";

	public void Recharge_Successful() {
		try {
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Movii_Core_Page.wait = new WebDriverWait(Movii_Core_Page.driver, 60);

			Movii_Core_Page.driver.findElement(Recargarcelular).click();
			System.out.println("user clicked on Recargar celular");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on Recargar celularo");

			Movii_Core_Page.driver.findElement(celular).click();
			System.out.println("user clicked on celular");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on celular");

			Movii_Core_Page.driver.findElement(claro).click();
			System.out.println("user clicked on claro");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on claro");

			Movii_Core_Page.driver.findElement(Numero).sendKeys(Movii_Core_Page.config.getProperty("movii_user"));
			System.out.println("user input number to be recharge");
			Movii_Core_Page.logger.log(Status.PASS, "user input number to be recharge");

			Movii_Core_Page.driver.findElement(usarelmio).click();
			System.out.println("user click usarelmio");
			Movii_Core_Page.logger.log(Status.PASS, "user click usarelmio");

			Movii_Core_Page.driver.findElement(recarga).sendKeys("1000");
			System.out.println("user input amount to be recharge");
			Movii_Core_Page.logger.log(Status.PASS, "user input amount to be recharg");

			Movii_Core_Page.driver.findElement(continu).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continu");

			Movii_Core_Page.driver.findElement(confirmarecargar).click();
			System.out.println("user click confirmarecargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click confirmarecargar");

			actmsg = Movii_Core_Page.driver.findElement(Recargaexitosa).getText();

			if (actmsg.contains(expectedrecharge)) {
				System.out.println(" Recharge Successful transaction test case pass");
				Movii_Core_Page.logger.log(Status.PASS,
						" verified Recharge Successful transaction with message = : " + actmsg);

				Movii_Core_Page.driver.findElement(finalizar).click();
				System.out.println("user click finalizar");
				Movii_Core_Page.logger.log(Status.PASS, "user click finalizar");
			} else {
				System.out.println("Recharge_Successful transaction test case fail");
				Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction not verified");
				Assert.assertTrue(false);
			}
		}

		catch (Exception e) {
			System.out.println(" Recharge_Successful Transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction verification fail");
			e.printStackTrace();
			Assert.fail("Recharge Successful transaction verification fail");
		}
	}

	public void Recharge_Paquetes_Voz() {
		try {
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Movii_Core_Page.wait = new WebDriverWait(Movii_Core_Page.driver, 60);

			Movii_Core_Page.driver.findElement(Recargarcelular).click();
			System.out.println("user clicked on Recargar celular");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on Recargar celularo");

			Movii_Core_Page.driver.findElement(paquetes).click();
			System.out.println("user clicked on paquetes");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on paquetes");

			Movii_Core_Page.driver.findElement(paquetesVozNumero)
					.sendKeys(Movii_Core_Page.config.getProperty("movii_user"));
			System.out.println("user input number to be recharge");
			Movii_Core_Page.logger.log(Status.PASS, "user input number to be recharge");

			Movii_Core_Page.driver.findElement(paquetesVozContinue).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continue");

			Movii_Core_Page.driver.findElement(tigo).click();
			System.out.println("user click tigo");
			Movii_Core_Page.logger.log(Status.PASS, "user click tigo");

			Movii_Core_Page.driver.findElement(voz).click();
			System.out.println("user click voz");
			Movii_Core_Page.logger.log(Status.PASS, "user click voz");

			Movii_Core_Page.driver.findElement(paquetesVozContinue).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continue");

			Movii_Core_Page.driver.findElement(packet).click();
			System.out.println("user click packet");
			Movii_Core_Page.logger.log(Status.PASS, "user click packet");

			Movii_Core_Page.driver.findElement(comprar).click();
			System.out.println("user click comprar");
			Movii_Core_Page.logger.log(Status.PASS, "user click comprar");

			Movii_Core_Page.driver.findElement(recargar).click();
			System.out.println("user click recargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click recargar");
			
			Movii_Core_Page.driver.findElement(confirmarecargar).click();
			System.out.println("user click confirmarecargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click confirmarecargar");

			actmsg = Movii_Core_Page.driver.findElement(Recargaexitosa).getText();

			if (actmsg.contains(expectedrecharge)) {
				System.out.println(" Recharge Successful transaction test case pass");
				Movii_Core_Page.logger.log(Status.PASS,
						" verified Recharge Successful transaction with message = : " + actmsg);

				Movii_Core_Page.driver.findElement(finalizar).click();
				System.out.println("user click finalizar");
				Movii_Core_Page.logger.log(Status.PASS, "user click finalizar");
			} else {
				System.out.println("Recharge_Successful transaction test case fail");
				Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction not verified");
				Assert.assertTrue(false);
			}
		}

		catch (Exception e) {
			System.out.println(" Recharge_Successful Transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction verification fail");
			e.printStackTrace();
			Assert.fail("Recharge Successful transaction verification fail");
		}
	}

	public void Recharge_Paquetes_Datos() {
		try {
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Movii_Core_Page.wait = new WebDriverWait(Movii_Core_Page.driver, 60);

			Movii_Core_Page.driver.findElement(Recargarcelular).click();
			System.out.println("user clicked on Recargar celular");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on Recargar celularo");

			Movii_Core_Page.driver.findElement(paquetes).click();
			System.out.println("user clicked on paquetes");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on paquetes");

			Movii_Core_Page.driver.findElement(paquetesVozNumero)
					.sendKeys(Movii_Core_Page.config.getProperty("movii_user"));
			System.out.println("user input number to be recharge");
			Movii_Core_Page.logger.log(Status.PASS, "user input number to be recharge");

			Movii_Core_Page.driver.findElement(paquetesVozContinue).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continue");

			Movii_Core_Page.driver.findElement(tigo).click();
			System.out.println("user click tigo");
			Movii_Core_Page.logger.log(Status.PASS, "user click tigo");

			Movii_Core_Page.driver.findElement(datos).click();
			System.out.println("user click datos");
			Movii_Core_Page.logger.log(Status.PASS, "user click datos");

			Movii_Core_Page.driver.findElement(paquetesVozContinue).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continue");

			Movii_Core_Page.driver.findElement(packet).click();
			System.out.println("user click packet");
			Movii_Core_Page.logger.log(Status.PASS, "user click packet");

			Movii_Core_Page.driver.findElement(comprar).click();
			System.out.println("user click comprar");
			Movii_Core_Page.logger.log(Status.PASS, "user click comprar");
			
			Movii_Core_Page.driver.findElement(recargar).click();
			System.out.println("user click recargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click recargar");

			Movii_Core_Page.driver.findElement(confirmarecargar).click();
			System.out.println("user click confirmarecargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click confirmarecargar");

			actmsg = Movii_Core_Page.driver.findElement(Recargaexitosa).getText();

			if (actmsg.contains(expectedrecharge)) {
				System.out.println(" Recharge Successful transaction test case pass");
				Movii_Core_Page.logger.log(Status.PASS,
						" verified Recharge Successful transaction with message = : " + actmsg);

				Movii_Core_Page.driver.findElement(finalizar).click();
				System.out.println("user click finalizar");
				Movii_Core_Page.logger.log(Status.PASS, "user click finalizar");
			} else {
				System.out.println("Recharge_Successful transaction test case fail");
				Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction not verified");
				Assert.assertTrue(false);
			}
		}

		catch (Exception e) {
			System.out.println(" Recharge_Successful Transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction verification fail");
			e.printStackTrace();
			Assert.fail("Recharge Successful transaction verification fail");
		}
	}
	
	public void Recharge_Paquetes_Voz_Datos() {
		try {
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Movii_Core_Page.wait = new WebDriverWait(Movii_Core_Page.driver, 60);

			Movii_Core_Page.driver.findElement(Recargarcelular).click();
			System.out.println("user clicked on Recargar celular");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on Recargar celularo");

			Movii_Core_Page.driver.findElement(paquetes).click();
			System.out.println("user clicked on paquetes");
			Movii_Core_Page.logger.log(Status.PASS, "user clicked on paquetes");

			Movii_Core_Page.driver.findElement(paquetesVozNumero)
					.sendKeys(Movii_Core_Page.config.getProperty("movii_user"));
			System.out.println("user input number to be recharge");
			Movii_Core_Page.logger.log(Status.PASS, "user input number to be recharge");

			Movii_Core_Page.driver.findElement(paquetesVozContinue).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continue");

			Movii_Core_Page.driver.findElement(tigo).click();
			System.out.println("user click tigo");
			Movii_Core_Page.logger.log(Status.PASS, "user click tigo");

			Movii_Core_Page.driver.findElement(vozDatos).click();
			System.out.println("user click vozDatos");
			Movii_Core_Page.logger.log(Status.PASS, "user click vozDatos");

			Movii_Core_Page.driver.findElement(paquetesVozContinue).click();
			System.out.println("user click continu");
			Movii_Core_Page.logger.log(Status.PASS, "user click continue");

			Movii_Core_Page.driver.findElement(packet).click();
			System.out.println("user click packet");
			Movii_Core_Page.logger.log(Status.PASS, "user click packet");

			Movii_Core_Page.driver.findElement(comprar).click();
			System.out.println("user click comprar");
			Movii_Core_Page.logger.log(Status.PASS, "user click comprar");
			
			Movii_Core_Page.driver.findElement(recargar).click();
			System.out.println("user click recargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click recargar");

			Movii_Core_Page.driver.findElement(confirmarecargar).click();
			System.out.println("user click confirmarecargar");
			Movii_Core_Page.logger.log(Status.PASS, "user click confirmarecargar");

			actmsg = Movii_Core_Page.driver.findElement(Recargaexitosa).getText();

			if (actmsg.contains(expectedrecharge)) {
				System.out.println(" Recharge Successful transaction test case pass");
				Movii_Core_Page.logger.log(Status.PASS,
						" verified Recharge Successful transaction with message = : " + actmsg);

				Movii_Core_Page.driver.findElement(finalizar).click();
				System.out.println("user click finalizar");
				Movii_Core_Page.logger.log(Status.PASS, "user click finalizar");
			} else {
				System.out.println("Recharge_Successful transaction test case fail");
				Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction not verified");
				Assert.assertTrue(false);
			}
		}

		catch (Exception e) {
			System.out.println(" Recharge_Successful Transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "Recharge Successful transaction verification fail");
			e.printStackTrace();
			Assert.fail("Recharge Successful transaction verification fail");
		}
	}
}
