package com.magicbricks.utils;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.events.EventFiringWebDriver;


	public class Screenshot {
		static WebDriver driver=SetupDriver.getBrowserName();
		public static void screenshot() throws IOException
	    {
	         
	       EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	       File srcImg=edriver.getScreenshotAs(OutputType.FILE);
	       
	       //File destImg=new File("./screenshot/priya.jpg");
	       File destImg=new File("C:\\Users\\OLIMUKHE\\Desktop\\MagicBricks_ScreenShot\\"+timestamp()+" "+ "MagicBricks_Olipriya.png");
	       FileUtils.copyFile(srcImg, destImg);  
	    }
		
		 public static String timestamp() {
		        //yyyy-MM-dd HH-mm-ss
		        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

		        //return new SimpleDateFormat("MM-dd-yyyy").format(new Date());

		    } 
		 }


	
	
	
	
