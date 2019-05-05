package com_movii_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com_movii_framework.Movii_Core_Page;

public class Movii_TuDinero_Page {
	
	public By tuDinero_image_id=By.id("com.movilred.subscriber:id/opt_image");
	public By cargaronpse_button=By.id("com.movilred.subscriber:id/btn_pse");
	public By valoracarga_inputr=By.id("com.movilred.subscriber:id/txt_value");
	public By continuar_button=By.id("com.movilred.subscriber:id/btnContinue");
	public By cargar= By.id("com.movilred.subscriber:id/btn_continue");
	public By banca= By.id("com.movilred.subscriber:id/lbl_number");
	public String Act_sucess_message="";
	public String Exp_sucess_message="Número de cuenta";
	public String fail_message="";
	
	public void TuDinero_UnSuccessful_transaction()
	{

		try 
		{
			Movii_Core_Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			
			Movii_Core_Page.wait=new WebDriverWait(Movii_Core_Page.driver, 120);
		
		Movii_Core_Page.driver.findElement(tuDinero_image_id).click();
		System.out.println("user clicked on tu dinaro");
		Movii_Core_Page.logger.log(Status.PASS, "user clicked on tu dinaro");
		
		Movii_Core_Page.driver.findElement(cargaronpse_button).click();
		System.out.println("user clicked on cargar con pse");
		Movii_Core_Page.logger.log(Status.PASS, "user clicked on cargar con pse");
		
		Movii_Core_Page.driver.findElement(valoracarga_inputr).sendKeys("111");
		System.out.println("user enters 111 amount");
		Movii_Core_Page.logger.log(Status.PASS, "user enters 111 amount");
		
		Movii_Core_Page.driver.findElement(continuar_button).click();
		System.out.println("user clicked continuar");
		Movii_Core_Page.logger.log(Status.PASS, "user clicked continuar");
		
		System.out.println("incoorect amount alert display");
		
		Movii_Core_Page.P_element=Movii_Core_Page.driver.findElement(By.id("com.movilred.subscriber:id/dialog_body"));
		String alert_msg=Movii_Core_Page.P_element.getText();
		
		Movii_Core_Page.driver.findElement(By.id("com.movilred.subscriber:id/neutral_btn")).click();
		System.out.println("user accept alert box");
		Movii_Core_Page.logger.log(Status.PASS, "user click on ok button on invalid transcation alert");
		  
		if(alert_msg.contains("El valor debe ser un multiplo de 100"))
		{
			System.out.println(" invalid amount transaction test case pass");
			Movii_Core_Page.logger.log(Status.PASS, " verified unsucessfully transaction with message = : "+ alert_msg);
		}
		else
		{
			System.out.println("invalid amount transaction test case fail");
			Movii_Core_Page.logger.log(Status.FAIL, "unsucessfully transaction not verified");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			System.out.println("unsucessfully transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "sucessfully transaction verification fail");
			e.printStackTrace();
			Assert.fail("sucessfully transaction verification fail");
		}
	}
	
	public void TuDinero_Successful_transaction()
	{
		try 
		{
			
		Movii_Core_Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	
		Movii_Core_Page.wait=new WebDriverWait(Movii_Core_Page.driver, 120);
	
		Movii_Core_Page.driver.findElement(tuDinero_image_id).click();
		System.out.println("user clicked on tu dinaro");
		Movii_Core_Page.logger.log(Status.PASS, "user clicked on tu dinaro");
		
		Movii_Core_Page.driver.findElement(cargaronpse_button).click();
		System.out.println("user clicked on cargar con pse");
		Movii_Core_Page.logger.log(Status.PASS, "user clicked on cargar con pse");
		
		Movii_Core_Page.driver.findElement(valoracarga_inputr).sendKeys("100");
		System.out.println("user enters $100 amount");
		Movii_Core_Page.logger.log(Status.PASS, "user enters $100 amount");
		
		Movii_Core_Page.driver.findElement(continuar_button).click();
		System.out.println("user clicked continuar");
		Movii_Core_Page.logger.log(Status.PASS, "user clicked continuar and is on third party app");
		
		Act_sucess_message= Movii_Core_Page.driver.findElement(banca).getText();

		if(Act_sucess_message.contains(Exp_sucess_message))
		{
			Movii_Core_Page.logger.log(Status.PASS, "user has sucessfully clicked cargar button at confitmation screen = : "+ Act_sucess_message);
			System.out.println("verified clicked cargar button at confirmation page");
		}
		else
		{
			System.out.println("sucessfully transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "Success transaction not verified");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			System.out.println("sucessfully transaction verification fail");
			Movii_Core_Page.logger.log(Status.FAIL, "sucessfully transaction verification fail");
			e.printStackTrace();
			Assert.fail("sucessfully transaction verification fail");
		}
	}

	public static By balanceLocator = By.xpath("//*[@id='txt_balance']");
	
	public static By tuDineroIcon = By.xpath("//*[@id='opt_image' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Tu\\ndinero'] and ./parent::*[@id='main_content']]]");
	public void checkBalance() {
		try {
			Movii_Core_Page.driver.findElement(tuDineroIcon).click();
			String balance = Movii_Core_Page.driver.findElement(balanceLocator).getText();
			Movii_Core_Page.logger.log(Status.PASS, "Balance Text Read");
			if(balance.trim()!="" )
			{
				Assert.assertTrue(true);
				Movii_Core_Page.logger.log(Status.PASS, "Balance is : "+balance);
			}
			else
			{
				Movii_Core_Page.logger.log(Status.FAIL, "Balance is empty");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			Assert.fail("User Login fails");
		}
	}

}
