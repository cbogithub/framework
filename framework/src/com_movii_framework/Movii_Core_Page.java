
package com_movii_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com_movii_commons.TestUtil;
import com_movii_commons.Xls_Reader;
import io.appium.java_client.android.AndroidDriver;

public class Movii_Core_Page {
	public static AndroidDriver<WebElement> driver;
	public static FileInputStream config_istream;
	public static Properties config;
	public static FileInputStream config_test;
	public static Properties test;
	public static WebDriverWait wait;
	public static WebElement P_element;
	public static DesiredCapabilities capabilities;
	public static ExtentReports report;
	public static ExtentHtmlReporter reportHtml;
	public static ExtentTest logger;
	public static String baseurl;
	public static WebDriver w_driver;

	// call methods customize methods created for excel using in utility class
	public static Xls_Reader excel = new Xls_Reader(
			System.getProperty("user.dir") + "\\src\\com_movii_data\\Tests.xlsx");

	// setting movii apk path
	public static File movii_apk = new File(
			System.getProperty("user.dir") + "\\apps\\movii_apk\\app-develop-debug.apk");

	// setting moviired apk path
	public static File moviired_apk = new File(
			System.getProperty("user.dir") + "\\apps\\moviired_apk\\com.movilred.merchant-v25(0.8.25)-debug.apk");

	// initialize brwoser and connection to product url

	@BeforeSuite
	public static void init() throws IOException {
		reportHtml = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\Reports\\Report" + TestUtil.getCurrentTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(reportHtml);

		config_istream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\com_movii_data\\movii_config.properties");
		config = new Properties();
		config.load(config_istream);
		
		config_test=new FileInputStream(System.getProperty("user.dir") + "\\src\\com_movii_data\\test_data.properties");
		test= new Properties();
		test.load(config_test);
	}

	public static void movi() throws MalformedURLException, IOException {

		if (config.getProperty("Run_movii").equals("True")) {

			capabilities = new DesiredCapabilities();

			if (config.getProperty("Run_Mode_movii").equalsIgnoreCase("Actual_Device")) {
				capabilities.setCapability("deviceName", "Samsung Galaxy J3 (2016)");
				capabilities.setCapability("platformVersion", "5.1.1");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);

				System.out.println("Please wait .. Movii app .. installation is in progress");
				
				
				capabilities.setCapability("fullReset", false);
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("app", movii_apk.getAbsolutePath());
				
				capabilities.setCapability("appPackage", "com.movilred.subscriber");
				capabilities.setCapability("appActivity", "com.movilred.subscriber.LauncherActivity");
				capabilities.setCapability("newCommandTimeout", 185000);
				driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				System.out.println("Movii Appliation launch");
			}

			else {
				capabilities.setCapability("deviceName", "192.168.224.101:5555");
				capabilities.setCapability("platformVersion", "7.0");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);
				capabilities.setCapability("fullReset", true);
				capabilities.setCapability("autoGrantPermissions", true);
				capabilities.setCapability("app", movii_apk.getAbsolutePath());
				
				capabilities.setCapability("appPackage", "com.movilred.subscriber");
				capabilities.setCapability("appActivity", "com.movilred.subscriber.LauncherActivity");
				capabilities.setCapability("newCommandTimeout", 185000);
				driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				System.out.println("Appliation launch");
			}
		}
	}

	public static void moviRed() throws MalformedURLException, IOException

	{
		 if(config.getProperty("Run_moviired").equals("True"))
		{
			 capabilities = new DesiredCapabilities();
			if(config.getProperty("Moviired_Native_app").equalsIgnoreCase("True"))
			{	
				if(config.getProperty("Run_Type").equalsIgnoreCase("Actual_Device"))
				{
					capabilities.setCapability("deviceName", "Samsung Galaxy J3 (2016)");
					capabilities.setCapability("platformVersion", "5.1.1");
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("unicodeKeyboard", true);
					capabilities.setCapability("resetKeyboard", true);
					
					System.out.println("Please wait .. Movii app .. installation is in progress");
					capabilities.setCapability("newCommandTimeout", 185000);
					capabilities.setCapability("fullReset", false);
					capabilities.setCapability("autoGrantPermissions", true);
					capabilities.setCapability("app", moviired_apk.getAbsolutePath());
					
					capabilities.setCapability("appPackage", "com.movilred.merchant");
					capabilities.setCapability("appActivity", "com.movilred.merchant.LauncherActivity");		
					
					driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
					
					System.out.println("Moviired Appliation launch");
				}
				else
				{
					capabilities.setCapability("deviceName", "192.168.224.101:5555");
					capabilities.setCapability("platformVersion", "7.0");
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("unicodeKeyboard", true);
					capabilities.setCapability("resetKeyboard", true);
					capabilities.setCapability("fullReset", true);
					capabilities.setCapability("autoGrantPermissions", true);
					capabilities.setCapability("app", moviired_apk.getAbsolutePath());
					
					capabilities.setCapability("appPackage", "com.movilred.merchant");
					capabilities.setCapability("appActivity", "com.movilred.merchant.LauncherActivity");	
					driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
						
					System.out.println("Appliation launch");
				}
			
			}
			}
	}

	public static void moviRedWeb() throws MalformedURLException, IOException

	{

		if (config.getProperty("Browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\apps\\Jars\\chromedriver.exe");
			w_driver = new ChromeDriver();
			// logs.debug("loaded chrome driver ");
		}

		else if (config.getProperty("Browser").equals("Firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					System.getProperty("user.dir") + "\\apps\\Jars\\geckodriver.exe");
			w_driver = new FirefoxDriver();
			// logs.debug("loaded firefox driver ");
		}

		else if (config.getProperty("Browser").equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\apps\\Jars\\MicrosoftWebDriver.exe");
			w_driver = new EdgeDriver();
			// logs.debug("loaded IE driver ");
		}

		baseurl = config.getProperty("Moviired_url");
		System.out.println(baseurl);
		w_driver.get(baseurl);

		w_driver.manage().window().maximize();

		w_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		w_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		System.out.println("\n Home Page: " + w_driver.getCurrentUrl());

	}

}
