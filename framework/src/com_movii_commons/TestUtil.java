package com_movii_commons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com_movii_framework.Movii_Core_Page;



public class TestUtil extends Movii_Core_Page {
	
	
	
public static String mailscreenshotpath;
	
	public static String getCurrentTime()
	{
		Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //3
		  int year = cal.get(Calendar.YEAR); //2014
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  
		  String current = year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec;
		  return current;
	}
	public static void CaptureScreenshot(String name, Throwable throwable) throws IOException{
		File scrFile=null;
		  mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+ getCurrentTime() +".jpeg";
			if(driver==null)
			{
				scrFile = ((TakesScreenshot)Movii_Core_Page.w_driver).getScreenshotAs(OutputType.FILE);
			}
			else
			{
				scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			}
			
		   
		   FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		   Movii_Core_Page.logger.log(Status.FAIL, ExceptionUtils.getStackTrace(throwable));
		   Movii_Core_Page.logger.addScreenCaptureFromPath(mailscreenshotpath);
	}
	//android app
	public static void logAndCaptureScreenshot(String details,String status) throws IOException{
		  mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+details+"_"+ getCurrentTime() +".jpeg";
		   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		   
		   if (status.equalsIgnoreCase("fail")) {
			   Movii_Core_Page.logger.fail(details, MediaEntityBuilder.createScreenCaptureFromPath(mailscreenshotpath).build());
		} else if(status.equalsIgnoreCase("pass")){
			Movii_Core_Page.logger.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(mailscreenshotpath).build());
		} else
			Movii_Core_Page.logger.info(details, MediaEntityBuilder.createScreenCaptureFromPath(mailscreenshotpath).build());
	}
	
	public static void Web_logAndCaptureScreenshot(String details,String status) throws IOException{
		  mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+details+"_"+ getCurrentTime() +".jpeg";
		   File scrFile = ((TakesScreenshot)w_driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		   
		   if (status.equalsIgnoreCase("fail")) {
			   Movii_Core_Page.logger.fail(details, MediaEntityBuilder.createScreenCaptureFromPath(mailscreenshotpath).build());
		} else if(status.equalsIgnoreCase("pass")){
			Movii_Core_Page.logger.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(mailscreenshotpath).build());
		} else
			Movii_Core_Page.logger.info(details, MediaEntityBuilder.createScreenCaptureFromPath(mailscreenshotpath).build());
	}
	
	public static boolean isExecutable(String tcid)
	{
		
		for(int rowNum=2; rowNum<=excel.getRowCount("TEST_SUITE"); rowNum++){
			
			if(excel.getCellData("TEST_SUITE", "TCID", rowNum).equals(tcid)){
				if(excel.getCellData("TEST_SUITE", "RUNMODE", rowNum).equalsIgnoreCase("Y")){
					
					return true;
					
				}else{
					
					return false;
				}
			
			}
		
		}
		
		return false;
		
	}
	
	
	
	
	
	public static Object[][] getData(String sheetName){
		
		
		
		int rows = excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
		
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
			}
		}
		
		return data;
	
	}
	
	public static void zip(String filepath){
	 	try
	 	{
	 		File inFolder=new File(filepath);
	 		File outFolder=new File("Reports.zip");
	 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	 		BufferedInputStream in = null;
	 		byte[] data  = new byte[1000];
	 		String files[] = inFolder.list();
	 		for (int i=0; i<files.length; i++)
	 		{
	 			in = new BufferedInputStream(new FileInputStream
	 			(inFolder.getPath() + "/" + files[i]), 1000);  
	 			out.putNextEntry(new ZipEntry(files[i])); 
	 			int count;
	 			while((count = in.read(data,0,1000)) != -1)
	 			{
	 				out.write(data, 0, count);
	 			}
	 			out.closeEntry();
  }
	 		out.flush();
	 		out.close();
	 	
}
  catch(Exception e)
  {
	  e.printStackTrace();
  } 
 }	
	
	
	

}
