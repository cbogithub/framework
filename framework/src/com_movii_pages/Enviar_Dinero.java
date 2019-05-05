package com_movii_pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;

public class Enviar_Dinero {
	
	public By Enviardinero=By.xpath("(//*[@id='list_options2']/*/*/*[@id='opt_image'])[1]");
	public By  Ingresa_el_celular=By.id("com.movilred.subscriber:id/txt_number");
	String value="900";
	public By Enviar=By.id("com.movilred.subscriber:id/btn_continue");
	public By  error_msg=By.id("com.movilred.subscriber:id/dialog_body");
	String expt_error_msg="El número celular no es válido.";
	public By ok_button=By.id("com.movilred.subscriber:id/neutral_btn");
	
	
	public void send_money_below_minimum_1000_COP() throws IOException
	{
		try {
		Movii_Core_Page.driver.findElement(Enviardinero).click();
		Movii_Core_Page.driver.findElement(Ingresa_el_celular).sendKeys(value);
		Movii_Core_Page.driver.findElement(Enviar).click();
		String  act_msg= Movii_Core_Page.driver.findElement(error_msg).getText();
		
	
		if(act_msg.contains(expt_error_msg))
		{
			System.out.println(" Error message verified sucessfully in case user send money < 1000");
            TestUtil.logAndCaptureScreenshot("Logged In Successfully", "Pass");
        	Movii_Core_Page.driver.findElement(ok_button).click();
		}
		
		else
		{
			System.out.println("Login Test fail");
			Assert.fail("User Login fails");
		}
		}
		catch(Exception e)
		{
			e.getMessage();
			
		}
	}
	
	public void send_money_value_more_or_equal_1000_COP()
	
	{
		try {
			Movii_Core_Page.driver.findElement(Enviardinero).click();
			Movii_Core_Page.driver.findElement(Ingresa_el_celular).sendKeys("2000");
			Movii_Core_Page.driver.findElement(Enviar).click();
			String  act_msg= Movii_Core_Page.driver.findElement(error_msg).getText();
			String expt_msg="";
			By ok_button=By.id("com.movilred.subscriber:id/neutral_btn");
	
		
			if(act_msg.contains(expt_msg))
			{
				System.out.println("  message verified sucessfully in case user send money > 1000");
	            TestUtil.logAndCaptureScreenshot("Logged In Successfully", "Pass");
	        	Movii_Core_Page.driver.findElement(ok_button).click();
			}
			
			else
			{
				System.out.println("Login Test fail");
				Assert.fail("User Login fails");
			}
			}
			catch(Exception e)
			{
				e.getMessage();
				
			}
	}
}
