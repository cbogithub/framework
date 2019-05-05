	package com_movii_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com_movii_commons.TestUtil;
import com_movii_framework.Movii_Core_Page;

public class Moviired_Web_Login_Page {
	
	public By pagodefutrasloc=By.xpath("//*[@id=\"slide-out\"]/li[3]/ul/li/a");
	public By codiagodeberrasloc=By.partialLinkText("Código de barras");
	public By scanear= By.xpath("//*[@id=\"scanbtn\"]");
	
	public void Pagos_facturas_Busquedap_Categoria()
	{
		try {
		System.out.println("Pagos_facturas_Busquedap_Categoria");
		Movii_Core_Page.w_driver.findElement(hamburgerloc).click();
		Movii_Core_Page.w_driver.findElement(pagodefutrasloc).click();
		Movii_Core_Page.w_driver.findElement(codiagodeberrasloc).click();
		String url= "http://129.144.224.19/bill-payments/scan";
		if(Movii_Core_Page.w_driver.getCurrentUrl().contains(url))
		{
			System.out.println("user is going to scan barcode: Pagos_facturas_Busquedap_Categoria Test case pass ");
			Movii_Core_Page.w_driver.findElement(scanear).click();
			TestUtil.Web_logAndCaptureScreenshot("Pagos_facturas_Busquedap_Categoria", "Pass");
			
		}
		else
		{
			System.out.println(" Pagos_facturas_Busquedap_Categoria Test case fail");
			Assert.fail("Pagos_facturas_Busquedap_Categoria case fails");	
		}
		}
		catch(Exception e)
		{
			System.out.println("Test case fail due to exception : " + e);
			Assert.fail("Pagos_facturas_Busquedap_Categoria case fails");	
		}
		
	}
	
	public By Paquete= By.partialLinkText("Paquete de voz y datos");
	public By Claro= By.xpath("//*[@id=\"form\"]/div[1]/div/div[1]/label/div");
	public By voz=By.xpath("//*[@id=\"form\"]/div[2]/div/div[1]/label/div/div/h4");
	public By vozoffer=By.xpath("//*[@id=\"form\"]/div[3]/div/span/div[1]/label/div/div[2]");
	public By data=By.xpath("//*[@id=\"form\"]/div[2]/div/div[2]/label/div/div/h4");
	public By dataoffer=By.xpath("//*[@id=\"form\"]/div[3]/div/span/div[1]/label/div/div[2]/h4");
	public By vozdata=By.xpath("//*[@id=\"form\"]/div[2]/div/div[3]/label/div/div/h4");
	public By vozdataoffer=By.xpath("//*[@id=\"form\"]/div[3]/div/span/div[1]/label/div/div[2]/h4");
	public By Num_recargar= By.xpath("//*[@id=\"phonenumber\"]");
	public By voice_data_contin= By.xpath("//*[@id=\"loginbtn\"]");
	public By validate= By.xpath("//*[@id=\"validate_others\"]");
	public By finalizer= By.partialLinkText("Finalizar");
	
	public void Moviired_Web_Recargas_VoicePackets()
	{
		Movii_Core_Page.w_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	try
	{
		Movii_Core_Page.w_driver.findElement(hamburgerloc).click();
		Movii_Core_Page.w_driver.findElement(recargasloc).click();
		Movii_Core_Page.w_driver.findElement(Paquete).click();
		Movii_Core_Page.w_driver.findElement(Claro).click();
		Movii_Core_Page.w_driver.findElement(voz).click();
		Movii_Core_Page.w_driver.findElement(vozoffer).click();
		Movii_Core_Page.w_driver.findElement(Num_recargar).sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
		Movii_Core_Page.w_driver.findElement(voice_data_contin).click();
		Movii_Core_Page.w_driver.findElement(validate).click();
		
		String act_sucess_message=Movii_Core_Page.w_driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/h2")).getText();
		String expt_sucess_message="¡Recarga exitosa!";
		
		if(act_sucess_message.contains(expt_sucess_message)) 
		{
			System.out.println("Recharge sucessfull: Moviired_Web_Recargas_VoicePackets" );
			TestUtil.Web_logAndCaptureScreenshot("Moviired_Web_Recargas_VoicePackets", "Pass");
			Movii_Core_Page.w_driver.findElement(finalizer).click();
		}
		else
		{
			System.out.println("Recharge Unsucessfull : Moviired_Web_Recargas_VoicePackets" );
			Assert.fail("Moviired_Web_Recargas_VoicePackets case fails");	
		}
	}
	catch(Exception e)
	{
		System.out.println("Test case fail due to exception : " + e);
		Assert.fail("Moviired_Web_Recargas_VoicePackets case fails");	
	}
	
	}
	
	public void Moviired_Web_Recargas_DataPackets()
	{
		Movii_Core_Page.w_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try
		{
			Movii_Core_Page.w_driver.findElement(hamburgerloc).click();	
			Movii_Core_Page.w_driver.findElement(recargasloc).click();
			Movii_Core_Page.w_driver.findElement(Paquete).click();
			Movii_Core_Page.w_driver.findElement(Claro).click();
			Movii_Core_Page.w_driver.findElement(data).click();
			Movii_Core_Page.w_driver.findElement(dataoffer).click();
			Movii_Core_Page.w_driver.findElement(Num_recargar).sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
			Movii_Core_Page.w_driver.findElement(voice_data_contin).click();
			Movii_Core_Page.w_driver.findElement(validate).click();
			
			String act_sucess_message=Movii_Core_Page.w_driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/h2")).getText();
			String expt_sucess_message="¡Recarga exitosa!";
			
			
			if(act_sucess_message.contains(expt_sucess_message)) 
			{
				System.out.println("Recharge sucessfull: Moviired_Web_Recargas_DataPackets" );
				TestUtil.Web_logAndCaptureScreenshot("Moviired_Web_Recargas_DataPackets", "Pass");
				Movii_Core_Page.w_driver.findElement(finalizer).click();
			}
			else
			{
				System.out.println("Recharge Unsucessfull : Moviired_Web_Recargas_DataPackets" );
				Assert.fail("Moviired_Web_Recargas_DataPackets case fails");	
			}
		}
		catch(Exception e)
		{
			System.out.println("Test case fail due to exception : " + e);
			Assert.fail("Moviired_Web_Recargas_DataPackets case fails");	
		}	
	}
	
	public void Moviired_Web_Recargas_Voz_DataPackets()
	{
		Movii_Core_Page.w_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try
		{
			Movii_Core_Page.w_driver.findElement(hamburgerloc).click();	
			Movii_Core_Page.w_driver.findElement(recargasloc).click();
			Movii_Core_Page.w_driver.findElement(Paquete).click();
			Movii_Core_Page.w_driver.findElement(Claro).click();
			Movii_Core_Page.w_driver.findElement(vozdata).click();
			Movii_Core_Page.w_driver.findElement(vozdataoffer).click();
			Movii_Core_Page.w_driver.findElement(Num_recargar).sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
			Movii_Core_Page.w_driver.findElement(voice_data_contin).click();
			Movii_Core_Page.w_driver.findElement(validate).click();
			
			String act_sucess_message=Movii_Core_Page.w_driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/h2")).getText();
			String expt_sucess_message="¡Recarga exitosa!";
			
			if(act_sucess_message.contains(expt_sucess_message)) 
			{
				System.out.println("Recharge sucessfull: Moviired_Web_Recargas_Voz_DataPackets" );
				TestUtil.Web_logAndCaptureScreenshot("Moviired_Web_Recargas_Voz_DataPackets", "Pass");
				Movii_Core_Page.w_driver.findElement(finalizer).click();
			}
			else
			{
				System.out.println("Recharge Unsucessfull: Moviired_Web_Recargas_Voz_DataPackets" );
				Assert.fail("Moviired_Web_Recargas_Voz_DataPackets case fails");	
			}
		}
		catch(Exception e)
		{
			System.out.println("Test case fail due to exception : " + e);
			Assert.fail("Moviired_Web_Recargas_Voz_DataPackets case fails");	
		}	
	}
	
	public void Moviired_Web_UnSucessfullRecargas_cellular()
	{
		Movii_Core_Page.w_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			Movii_Core_Page.w_driver.findElement(hamburgerloc).click();
			Movii_Core_Page.w_driver.findElement(recargasloc).click();
			Movii_Core_Page.w_driver.findElement(recargarcellularloc).click();
			Movii_Core_Page.w_driver.findElement(claroloc).click();
			Movii_Core_Page.w_driver.findElement(numeroloc).sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
			Movii_Core_Page.w_driver.findElement(valorrecargarloc).sendKeys("50");
			Movii_Core_Page.w_driver.findElement(continueloc).click();
			Movii_Core_Page.w_driver.findElement(confirmloc).click();
			String act_sucess_message=Movii_Core_Page.w_driver.findElement(By.xpath("//*[@id=\"form\"]/h2")).getText();
			String expt_sucess_message="¡Carga fallida!";
			
			if(act_sucess_message.contains(expt_sucess_message)) 
			{
				System.out.println("Un sucessfull recharge test case paas" );
				TestUtil.Web_logAndCaptureScreenshot("Moviired_Web_UnSucessfullRecargas_cellular", "Pass");
				Movii_Core_Page.w_driver.findElement(finalizer).click();
			}
			else
			{
				System.out.println("Recharge Unsucessfull test case fail" );
				Assert.fail("Moviired_Web_UnSucessfullRecargas_cellular case fails");	
			}
				}
				
				
				catch(Exception e)
				{
					System.out.println("Test case fail due to exception : " + e);
					Assert.fail("Moviired_Web_UnSucessfullRecargas_cellular case fails");	
				}
	}
	
	public By hamburgerloc=By.xpath("//*[@id=\"Symbols\"]");
	public By recargasloc=By.xpath("//*[@id=\"slide-out\"]/li[1]/ul/li/a");
	public By recargarcellularloc=By.partialLinkText("Recargas a celular");
	public By claroloc=By.xpath("//*[@id=\"form\"]/div/div[1]/div/div/div/div[1]/label/div/div[1]");
	public By numeroloc=By.xpath("//*[@id=\"phoneNumber\"]");
	public By valorrecargarloc= By.xpath("//*[@id=\"labelamount\"]");
	public By continueloc=By.xpath("//*[@id=\"loginbtn\"]");
	public By confirmloc=By.xpath("//*[@id=\"validate_others\"]");
	
	
	public void Moviired_Web_SucessfullRecargas_cellular()
	{
		try {
	Movii_Core_Page.w_driver.findElement(hamburgerloc).click();
	Movii_Core_Page.w_driver.findElement(recargasloc).click();
	Movii_Core_Page.w_driver.findElement(recargarcellularloc).click();
	Movii_Core_Page.w_driver.findElement(claroloc).click();
	Movii_Core_Page.w_driver.findElement(numeroloc).sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
	Movii_Core_Page.w_driver.findElement(valorrecargarloc).sendKeys("1000");
	Movii_Core_Page.w_driver.findElement(continueloc).click();
	Movii_Core_Page.w_driver.findElement(confirmloc).click();
	String act_sucess_message=Movii_Core_Page.w_driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/h2")).getText();
	String expt_sucess_message="¡Recarga exitosa!";
	
	if(act_sucess_message.contains(expt_sucess_message)) 
	{
		System.out.println("Recharge sucessfull" );
		TestUtil.Web_logAndCaptureScreenshot("Moviired_Web_SucessfullRecargas_cellular", "Pass");
		
	}
	else
	{
		System.out.println("Recharge Unsucessfull" );
		Assert.fail("Moviired_Web_SucessfullRecargas_cellular case fails");	
	}
		}
		
		
		catch(Exception e)
		{
			System.out.println(" Moviired_Web_SucessfullRecargas_cellular : Recharge Unsucessfull due to exception "+ e );
			Assert.fail("Moviired_Web_SucessfullRecargas_cellular test case fails");	
		}
	}
	
	public By saldoloc= By.xpath("//*[@id=\"saldo\"]/div");
	public By plusloc=By.xpath("//*[@id=\"mostrar_lista\"]");
	public By cargarloc=By.xpath("//*[@id=\"sidebar_pago\"]/button[1]/span");
	public By dollor_act_msg=By.xpath("//*[@id=\"form\"]/h2");
	public By continuar_final=By.xpath("//*[@id=\"validate_others\"]/div/div[1]");
	
	public void Moviired_Web_CargarENLinea_dollor()
	{
		try
		{
			System.out.println("Moviired_Web_CargarENLinea_dollor");
			
			Movii_Core_Page.w_driver.findElement(saldoloc).click();
			Movii_Core_Page.w_driver.findElement(plusloc).click();
			Movii_Core_Page.w_driver.findElement(cargarloc).click();
			
			   Movii_Core_Page.w_driver.findElement(Valorinput).sendKeys("1000");
			     Movii_Core_Page.w_driver.findElement(CONTINUARloc).click();
			 	Movii_Core_Page.logger.log(Status.PASS, "user input valid amount and click on continue");
			 	
				String recargar_msg="Para ver tu carga reflejada automáticamente, te recomendamos hacer clic en Finalizar o Terminar en el portal de tu banco";
				
				if (Movii_Core_Page.w_driver.findElement(dollor_act_msg).getText().contains(recargar_msg))
				{
					System.out.println("Moviired_Web_CargarENLinea$ test case pass");
					 TestUtil.Web_logAndCaptureScreenshot("Moviired_Web_CargarENLinea$", "Pass");
					 Movii_Core_Page.w_driver.findElement(continuar_final).click();
					 Thread.sleep(3000);
				
				}
				else
				{
					System.out.println("Moviired_Web_CargarENLinea$ Test fail");
					Assert.fail("Moviired_Web_CargarENLineadollor test case fails");	
				}
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail Monto a recargar	");
			e.printStackTrace();
			Assert.fail("User Monto a recargar fails");
		}	
		
	}
	
	public By CargarENLinealoc= By.id("appCargarLinea");
	public By Valorinput=By.id("Pselabelamount");
	public By CONTINUARloc=By.xpath("//*[@id=\"validate_other\"]/div/div[1]");
	public By validate_othersloc= By.xpath("//*[@id=\"validate_others\"]/div/div[1]"); 
	public By Montorecargarloc=By.xpath("//*[@id=\"form\"]/center/div/table/tbody/tr[2]/td[1]/b");
	public By invalidrechargemg=By.xpath("//*[@id=\"formCpv\"]/div[2]/span/strong");
	
	public void Unsucessfull_Recharge_CargarENLinea()
	{
		try
		{	
		Movii_Core_Page.w_driver.findElement(CargarENLinealoc).click();
		
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on CargarENLinealoc In Successfully");
		 System.out.println("user is at = "  + Movii_Core_Page.w_driver.getCurrentUrl());
			
	     Movii_Core_Page.w_driver.findElement(Valorinput).sendKeys("@@@");
	     Movii_Core_Page.w_driver.findElement(CONTINUARloc).click();
	 	Movii_Core_Page.logger.log(Status.PASS, "user input invalid amount and click on continue");
	 	
	 	Movii_Core_Page.w_driver.findElement(invalidrechargemg).click();
	 	
		String recargar_msg="Por favor ingrese el valor a recargar";
		
		if (Movii_Core_Page.w_driver.findElement(invalidrechargemg).getText().contains(recargar_msg))
		{
			System.out.println("user is at Unsucessfull_Recharge_CargarENLinea	 Page");
			
			 TestUtil.Web_logAndCaptureScreenshot("Unsucessfull_Recharge_CargarENLinea", "Pass");
			 Thread.sleep(3000);
		
		}
		else
		{
			System.out.println("Unsucessfull_Recharge_CargarENLinea Test fail");
			Assert.fail("Unsucessfull_Recharge_CargarENLinea fails");	
		}
		}
		
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail Unsucessfull_Recharge_CargarENLinea	");
			e.printStackTrace();
			Assert.fail("Unsucessfull_Recharge_CargarENLinea fails");
		}		
	}
	
	public void CargarENLinea()
	{
		try
		{	
		Movii_Core_Page.w_driver.findElement(CargarENLinealoc).click();
		
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on CargarENLinealoc In Successfully");
		 System.out.println("user is at = "  + Movii_Core_Page.w_driver.getCurrentUrl());
			
	     Movii_Core_Page.w_driver.findElement(Valorinput).sendKeys("1000");
	     Movii_Core_Page.w_driver.findElement(CONTINUARloc).click();
	 	Movii_Core_Page.logger.log(Status.PASS, "user input valid amount and click on continue");
	 	
	 	Movii_Core_Page.w_driver.findElement(validate_othersloc).click();
	 	
		String recargar_msg="recargar";
		
		if (Movii_Core_Page.w_driver.findElement(Montorecargarloc).getText().contains(recargar_msg))
		{
			System.out.println("user is at Monto a recargar	 Page");
			
			Movii_Core_Page.w_driver.findElement(validate_othersloc).click();
			 TestUtil.Web_logAndCaptureScreenshot("Monto a recargar Successfully", "Pass");
			 Thread.sleep(3000);
		
		}
		else
		{
			System.out.println("Monto a recargar	 Test fail");
			Assert.fail("User Monto a recargar	 fails");	
		}
		}
		
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail Monto a recargar	");
			e.printStackTrace();
			Assert.fail("User Monto a recargar	 fails");
		}		
	}
	
	public By MisDatosloc=By.xpath("//*[@id=\"sidebar\"]/button[2]/span");
	public By MisDatos= By.partialLinkText("Información de perfil");
	
	public void Moviired_Web_MisDatos()
	{
   
		try
		{	
		actions = new Actions(Movii_Core_Page.w_driver);
		actions.moveToElement(Movii_Core_Page.w_driver.findElement(abrir));
		actions.click();
		actions.moveToElement(Movii_Core_Page.w_driver.findElement(MisDatosloc));
		actions.click();
		actions.build().perform();
		
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on MisDatosloc In Successfully");
		 System.out.println("user is at MisDatosloc");
			
	
		String Mensaje_msg="Información de perfil";
		
		if (Movii_Core_Page.w_driver.findElement(MisDatos).getText().contains(Mensaje_msg))
		{
			System.out.println("user is at MisDatos Page");
			
			System.out.println(Movii_Core_Page.w_driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div[2]/div[1]/div[1]/div/div/span[2]")).getText() + " is User property code");
			 TestUtil.Web_logAndCaptureScreenshot("MisDatos Successfully", "Pass");
			 Thread.sleep(3000);
		
		}
		else
		{
			System.out.println("MisDatos Test fail");
			Assert.fail("User MisDatos fails");	
		}
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail MisDatos");
			e.printStackTrace();
			Assert.fail("User MisDatos fails");
		}	
	}
	
	public By MiCuenta_loc = By.xpath("//*[@id=\"sidebar\"]/button[1]/span");
	public By Saldoactual_loc= By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div[2]/div[1]/div[1]/div/div/div/h4[1]");
	public By balanceloc= By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div[2]/div[1]/div[1]/div/div/div/span");
	
	public void Moviired_Web_MiCuenta()
	{
    
		System.out.println("user is at Moviired_Web_MiCuenta");
		
		try
		{	
		actions = new Actions(Movii_Core_Page.w_driver);
		actions.moveToElement(Movii_Core_Page.w_driver.findElement(abrir));
		actions.click();
		actions.moveToElement(Movii_Core_Page.w_driver.findElement(MiCuenta_loc));
		actions.click();
		actions.build().perform();
		
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on MiCuenta_loc In Successfully");

		String Saldo="Saldo actual";
		
		if (Movii_Core_Page.w_driver.findElement(Saldoactual_loc).getText().contains(Saldo))
		{
			System.out.println("user is at Status Page = " + Movii_Core_Page.w_driver.getCurrentUrl());
			
			String Mensaje_msg=Movii_Core_Page.w_driver.findElement(Saldoactual_loc).getText();
			
			System.out.println( "user balance is = " + Mensaje_msg + " " + Movii_Core_Page.w_driver.findElement(balanceloc).getText()) ;
			 TestUtil.Web_logAndCaptureScreenshot("MiCuenta_loc Successfully", "Pass");
			
		
		}
		else
		{
			System.out.println("MiCuenta_loc Test fail");
			Assert.fail("User MiCuenta_loc fails");	
		}
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail MiCuenta_loc");
			e.printStackTrace();
			Assert.fail("User MiCuenta_loc fails");
		}
		
	}	
	
	
	public By Cellphone=By.id("cellphone");
	public By Password= By.id("password");
	public By Loginbtn= By.id("loginbtn");
	public Actions actions;
	public By Sucess_element=By.id("appCargarLinea");
	
	public void Unsuccessful_Login()
	{

		Movii_Core_Page.P_element=Movii_Core_Page.w_driver.findElement(Password);
		
		try 
		{
		System.out.println("user" + Movii_Core_Page.test.getProperty("moviired_invalid_uname") + "password" + Movii_Core_Page.test.getProperty("moviired_invalid_pwd"));
			
		Movii_Core_Page.w_driver.findElement(Cellphone).sendKeys(Movii_Core_Page.test.getProperty("moviired_invalid_uname"));
		Movii_Core_Page.logger.log(Status.PASS, "Entered invalid Username Successfully");
		
		//entering password
		actions = new Actions(Movii_Core_Page.w_driver);
		actions.moveToElement(Movii_Core_Page.P_element);
		actions.click();
		actions.sendKeys(Movii_Core_Page.test.getProperty("moviired_invalid_pwd"));
		actions.build().perform();
		
		Movii_Core_Page.logger.log(Status.PASS, "Entered invalid Password Successfully");
		
		Movii_Core_Page.w_driver.findElement(Loginbtn).click();
		By Initiator =By.xpath("//*[@id=\"password\"]/span/strong");
		
		String expt_login_msg="Error: Initiator is invalid";
		String act_login_msg=Movii_Core_Page.w_driver.findElement(Initiator).getText();
		
		
		
		if(act_login_msg.contains(expt_login_msg))
		{
			System.out.println(act_login_msg + " : Unsucessfull login via invalid cred pass");
			 TestUtil.Web_logAndCaptureScreenshot("Unsucessfull login via invalid cred pass", "Pass");
			
		}
		else
		{
		    System.out.println("Login Test fail");
			Assert.fail("User Login fails");
		}
		
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			Assert.fail("User Login fails");
		}
	}
	
	
	

	public void login()  
	{
		
		Movii_Core_Page.P_element=Movii_Core_Page.w_driver.findElement(Password);
		
		try 
		{
		//System.out.println("user = " + Movii_Core_Page.config.getProperty("moviired_user") + "password" + Movii_Core_Page.config.getProperty("moviired_pwd"));
			
		Movii_Core_Page.w_driver.findElement(Cellphone).sendKeys(Movii_Core_Page.config.getProperty("moviired_user"));
		Movii_Core_Page.logger.log(Status.PASS, "Entered Username Successfully");
		
		//entering password
		actions = new Actions(Movii_Core_Page.w_driver);
		actions.moveToElement(Movii_Core_Page.P_element);
		actions.click();
		actions.sendKeys(Movii_Core_Page.config.getProperty("moviired_pwd"));
		actions.build().perform();
		
		Movii_Core_Page.logger.log(Status.PASS, "Entered Password Successfully");
		
		//Movii_Core_Page.w_driver.findElement(Password).sendKeys(Movii_Core_Page.config.getProperty("moviired_pwd"));

		Movii_Core_Page.w_driver.findElement(Loginbtn).click();
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on Sign In Successfully");
		
		System.out.println("User: "+ Movii_Core_Page.config.getProperty("moviired_user") + "Login");
		//	Movii_Core_Page.logs.debug("user entered username and password");
		
		
		if(Movii_Core_Page.w_driver.findElement(Sucess_element).getText().contains("CARGAR EN LÍNEA"))
		{
			System.out.println("user " + Movii_Core_Page.config.getProperty("moviired_user") + " logged in sucessfully");
			 TestUtil.Web_logAndCaptureScreenshot("Logged In Successfully", "Pass");
			
		}
		else
		{
		    System.out.println("Login Test fail");
			Assert.fail("User Login fails");
		}
		
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			Assert.fail("User Login fails");
		}
	}
	
	public By abrir=By.id("abrir");
	public By CerrarSes = By.xpath("//*[@id=\"sidebar\"]/button[4]/span");
	String expt_login="login";
	
	public void logout()
	{
		System.out.println("user is going to be logout");
		
		
		try
		{	
		actions = new Actions(Movii_Core_Page.w_driver);
		actions.moveToElement(Movii_Core_Page.w_driver.findElement(abrir));
		actions.click();
		actions.moveToElement(Movii_Core_Page.w_driver.findElement(CerrarSes));
		actions.click();
		
		actions.build().perform();
		
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on Logout In Successfully");
		
		if (Movii_Core_Page.w_driver.getCurrentUrl().contains(expt_login))
		{
			System.out.println("user" + Movii_Core_Page.config.getProperty("moviired_user") + " :Logout sucessfully");
			 TestUtil.Web_logAndCaptureScreenshot("Logout Successfully", "Pass");
			 Thread.sleep(3000);
		
		}
		else
		{
			System.out.println("Logout Test fail");
			Assert.fail("User Logout fails");	
		}
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			Assert.fail("User Logout fails");
		}
		
	}
	
	
}
