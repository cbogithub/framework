package com_movii_framework;

import org.openqa.selenium.By;

public class CommonFunctions {

	public static boolean isDisplayed(By element) {
		try {
			Movii_Core_Page.driver.findElement(element).isDisplayed();
			System.out.println("Displayed");
			return true;
		} catch (Exception e) {
			System.out.println("Not Displayed");
			return false;
		}
	}
}
