package com_movii_pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com_movii_commons.TestUtil;
import com_movii_framework.CommonFunctions;
import com_movii_framework.Movii_Core_Page;

public class Movii_Login_Page {
	public By field_username = By.id("txt_username");
	public By field_pwd = By.id("txt_pass");
	public By signin = By.id("btn_signIn");
	public By closeButton = By.id("com.movilred.subscriber:id/iconClose");
	// public By tuDinero = By.id("com.movilred.subscriber:id/opt_title");
	public By tuDinero = By.xpath("//*[@text='Tu\ndinero']");
	public By continueButton = By.id("com.movilred.subscriber:id/btn_continue");
	public static By hamburger = By.className("android.widget.ImageButton");
	
	String message = "dinero";

	// User should be able to login into the application successfully.

	public void success_login() {
		

	/*	try 
		{
			System.out.println("Welcome to Movii application for successfull login method ");
		Movii_Core_Page.driver.findElement(field_username).sendKeys(Movii_Core_Page.config.getProperty("movii_user"));
		Movii_Core_Page.logger.log(Status.PASS, "Entered Username Successfully");
	
		Movii_Core_Page.driver.findElement(field_pwd).sendKeys(Movii_Core_Page.config.getProperty("movii_pwd"));
		Movii_Core_Page.logger.log(Status.PASS, "Entered Password Successfully");
		
		Movii_Core_Page.driver.findElement(signin).click();
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on Sign In Successfully");
	//	Movii_Core_Page.logs.debug("user entered username and password");
		
		Thread.sleep(3000);
		if(Movii_Core_Page.driver.findElement(continueButton).isDisplayed() && Movii_Core_Page.driver.findElement(continueButton).isEnabled())
		{
			Movii_Core_Page.driver.findElement(continueButton).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on continue Button");
			
			if(Movii_Core_Page.driver.findElement(closeButton).isDisplayed() && Movii_Core_Page.driver.findElement(closeButton).isEnabled())
			{
			Movii_Core_Page.driver.findElement(closeButton).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Close Button");
			}
			
		}

		else if(Movii_Core_Page.driver.findElement(closeButton).isDisplayed() && Movii_Core_Page.driver.findElement(closeButton).isEnabled())
		{
		Movii_Core_Page.driver.findElement(closeButton).click();
		Movii_Core_Page.logger.log(Status.PASS, "Clicked on Close Button");
		
		if(Movii_Core_Page.driver.findElement(continueButton).isDisplayed() && Movii_Core_Page.driver.findElement(continueButton).isEnabled() )
		{
			Movii_Core_Page.driver.findElement(continueButton).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on continue Button");
		}
		}
		
		
		if(Movii_Core_Page.driver.findElement(tuDinero).getText().contains(message))
		{
			System.out.println("user: " + Movii_Core_Page.config.getProperty("movii_user") + " logged im sucessfully");
            TestUtil.logAndCaptureScreenshot("Logged In Successfully", "Pass");
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
		*/
		
		try {
			System.out.println("Welcome to Movii application for successfull login method ");
			Movii_Core_Page.driver.findElement(field_username)
					.sendKeys(Movii_Core_Page.config.getProperty("movii_user"));
			Movii_Core_Page.logger.log(Status.PASS, "Entered Username Successfully");

			Movii_Core_Page.driver.findElement(field_pwd).sendKeys(Movii_Core_Page.config.getProperty("movii_pwd"));
			Movii_Core_Page.logger.log(Status.PASS, "Entered Password Successfully");

			Movii_Core_Page.driver.findElement(signin).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Sign In Successfully");
			// Movii_Core_Page.logs.debug("user entered username and password");
			String abc ="";
			Thread.sleep(6000L);
			if (CommonFunctions.isDisplayed(closeButton)) {
				Movii_Core_Page.driver.findElement(closeButton).click();
				Movii_Core_Page.logger.log(Status.PASS, "Clicked on Close Button");
				abc = abc +"close";
			}

			if (CommonFunctions.isDisplayed(continueButton)) {
				Movii_Core_Page.driver.findElement(continueButton).click();
				Movii_Core_Page.logger.log(Status.PASS, "Clicked on continue Button");
				abc = abc + "continue";
			}
			
			if(!abc.contains("close"))
			{
				if (CommonFunctions.isDisplayed(closeButton)) {
					Movii_Core_Page.driver.findElement(closeButton).click();
					Movii_Core_Page.logger.log(Status.PASS, "Clicked on Close Button");
				}
			} else if(!abc.contains("continue"))
			{
				if (CommonFunctions.isDisplayed(continueButton)) {
					Movii_Core_Page.driver.findElement(continueButton).click();
					Movii_Core_Page.logger.log(Status.PASS, "Clicked on continue Button");
				}
			}
				
			if (Movii_Core_Page.driver.findElement(tuDinero).getText().contains(message)) {
				System.out.println(
						"user: " + Movii_Core_Page.config.getProperty("movii_user") + " logged im sucessfully");
				TestUtil.logAndCaptureScreenshot("Logged In Successfully", "Pass");
			} else {
				System.out.println("Login Test fail");
				Assert.fail("User Login fails");
			}

		} catch (Exception e) {
			Movii_Core_Page.logger.log(Status.FAIL, "Fail login");
			e.printStackTrace();
			Assert.fail("User Login fails");
		}
	}

	// User should not be able to login into the application successfully.
	String unsucessfull_Expected_message = "Su conexión a internet no está disponible, Por favor, verifíquela.";
	public By unsucessfull_actual_message_locator = By.id("com.movilred.subscriber:id/dialog_body");
	public By ok_button = By.id("com.movilred.subscriber:id/neutral_btn");

	public void user_unsuccessfull_login() {
		try {
			// invalid user and invalid password

			System.out.println("Welcome to Movii unsuccessfull login application");
			Movii_Core_Page.driver.findElement(field_username)
					.sendKeys(Movii_Core_Page.test.getProperty("movii_invalid_uname"));
			Movii_Core_Page.logger.log(Status.PASS, "user enterd invalid Username Successfully");

			Movii_Core_Page.driver.findElement(field_pwd)
					.sendKeys(Movii_Core_Page.test.getProperty("movii_invalid_pwd"));
			Movii_Core_Page.logger.log(Status.PASS, "user enterd  invalid Password Successfully");

			Movii_Core_Page.driver.findElement(signin).click();
			Movii_Core_Page.logger.log(Status.PASS, "Clicked on Sign In Successfully");

			Movii_Core_Page.P_element = Movii_Core_Page.driver.findElement(unsucessfull_actual_message_locator);

			String actual_message = Movii_Core_Page.P_element.getText();

			if (actual_message.contains(unsucessfull_Expected_message)) {
				System.out.println(" verified invalid user: "
						+ Movii_Core_Page.test.getProperty("" + "movii_invalid_uname") + " not able to loggedin ");

				TestUtil.logAndCaptureScreenshot("User is not able to login with invalid credentials", "Pass");

				Movii_Core_Page.driver.findElement(ok_button).click();
			} else {
				System.out.println("unsucessfull Login Test fail");
				Assert.fail("unsucessfull Login Test fail");
			}

		} catch (Exception e) {
			Movii_Core_Page.logger.log(Status.FAIL, "Fail user_unsuccessfull_login");
			e.printStackTrace();
			Assert.fail("user_unsuccessfull_login user Login fails");
		}
	}

	// User should be blocked after 3 unsuccessfull login.
	public void user_block_login() {

		try

		{
			int count = 0;
			while (count < 3) {
				Movii_Core_Page.driver.findElement(field_username).clear();
				Movii_Core_Page.driver.findElement(field_username).sendKeys(Movii_Core_Page.test.getProperty("movii_valid_uname"));
				Movii_Core_Page.logger.log(Status.PASS, "user enterd valid Username Successfully");
				Movii_Core_Page.driver.findElement(field_pwd).clear();
				Movii_Core_Page.driver.findElement(field_pwd).sendKeys(Movii_Core_Page.test.getProperty("movii_invalid_pwd"));
				Movii_Core_Page.logger.log(Status.PASS, "user enterd  invalid Password Successfully");
				Movii_Core_Page.driver.findElement(signin).click();
				Movii_Core_Page.logger.log(Status.PASS, "Clicked on Sign In Successfully");

				if(count<2)
				Movii_Core_Page.driver.findElement(ok_button).click();
				count++;
			}
			Movii_Core_Page.P_element = Movii_Core_Page.driver.findElement(unsucessfull_actual_message_locator);
			String actual_message = Movii_Core_Page.P_element.getText();

			if (actual_message.contains(unsucessfull_Expected_message)) {
				System.out.println(" verified invalid user: "
						+ Movii_Core_Page.test.getProperty("" + "movii_invalid_uname") + " not able to loggedin ");

				TestUtil.logAndCaptureScreenshot("User is not able to login with invalid credentials", "Pass");

				Movii_Core_Page.driver.findElement(ok_button).click();
			} else {
				Assert.fail("unsucessfull Login Test fail");
			}

		} catch (

		Exception e) {
			Movii_Core_Page.logger.log(Status.FAIL, "Fail user_unsuccessfull_login");
			e.printStackTrace();
			Assert.fail("user_unsuccessfull_login user Login fails");
		}
	}

	// User should be able to see the Popup message in case of inactive session and
	// when click on the Iniciar session option then should be navigated to login
	// screen again.
	public By inactive_popup_title=By.id("com.movilred.subscriber:id/dialog_title");
	public By inactive_popup_text=By.id("com.movilred.subscriber:id/dialog_body");
	public By inactive_popup_ok=By.id("com.movilred.subscriber:id/action_btn");
	
	public void inactive_session() 
	{
		try {
		System.out.println("user keeps session idle");
		//success_login();
		Thread.sleep(185000);
		
		String popup_title= Movii_Core_Page.driver.findElement(inactive_popup_title).getText();
		System.out.println("Inactive popup title " + popup_title);
		
		String popup_text=Movii_Core_Page.driver.findElement(inactive_popup_text).getText();
		System.out.println("Inactive popup description " + popup_text);
		
		Movii_Core_Page.logger.log(Status.PASS, "inactive popup appeard");
		
		Movii_Core_Page.driver.findElement(inactive_popup_ok).click();
		Movii_Core_Page.logger.log(Status.PASS, "user click on ok button at inactive popup");
		}
		catch(Exception e)
		{
			Movii_Core_Page.logger.log(Status.FAIL, "Inactive session test fails");
			e.printStackTrace();
			Assert.fail("inactive_session test fails");
		}
		
	}
	// User should be able to reset the password using password reset link available
	// on login page.

	
	public By logout = By.id("com.movilred.subscriber:id/design_menu_item_text");

	// User should be able to logout of the application successfully.
	
	public By cerrar_sesion=By.id("com.movilred.subscriber:id/design_menu_item_text");
	
	//User should be able to logout of the application successfully.
	public void user_logout()
	{
		By hamburger= By.className("android.widget.ImageButton");
		By si_text=By.id("com.movilred.subscriber:id/dialog_body");
		By si_ok= By.id("com.movilred.subscriber:id/action_btn");
		
	try 
	{
		System.out.println("user click on humberger ");
		//user click on humberger
	Movii_Core_Page.driver.findElement(hamburger).click();
	Movii_Core_Page.logger.log(Status.PASS, "Clicked on humberger icon Successfully");
	
	System.out.println("user clicked on cerrar_sesion");
	
	//user click on session out
   //Movii_Core_Page.driver.findElement(cerrar_sesion).click();
	Movii_Core_Page.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout[2]/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[7]/android.widget.CheckedTextView")).click();
	Movii_Core_Page.logger.log(Status.PASS, "Clicked on cerrar_sesion icon Successfully");
	
	System.out.println("Message displayed on logout popup" + Movii_Core_Page.driver.findElement(si_text).getText());
	
	//user click on ok
	Movii_Core_Page.driver.findElement(si_ok).click();
	Movii_Core_Page.logger.log(Status.PASS, "Clicked on logout ok");
	
	}
		
	catch (Exception e) {
			// TODO: handle exception
		Movii_Core_Page.logger.log(Status.FAIL, "Fail user_logout");
		e.printStackTrace();
		Assert.fail("user_logout user Login fails");
		}
	
	}
}
