package com_movii_pages;

import org.openqa.selenium.By;

import com_movii_framework.Movii_Core_Page;

public class Moviired_Web_Home_Page extends Movii_Core_Page {

	public By reset_link=By.partialLinkText("Olvidé mi contraseña");
	public By validate_others=By.id("validate_others");
	String exptmsg="";
	
	public void reset_pwd()
	{
        
		Movii_Core_Page.w_driver.findElement(reset_link).click();
		String ph=Movii_Core_Page.config.getProperty("moviired_user");
		
		for(int i=1;i<=ph.length();i++)
		{
		Movii_Core_Page.w_driver.findElement(By.id("phone" + i)).sendKeys(""+i);
		}
		Movii_Core_Page.w_driver.findElement(validate_others).click();
		
		if(Movii_Core_Page.w_driver.findElement(By.xpath("")).equals(""))
		{
			System.out.println("Reset passsword test case pass");
		}
	}
	
}
