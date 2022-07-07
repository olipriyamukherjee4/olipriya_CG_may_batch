package com.magicbricks.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import com.magicbricks_config.BrowserInit;

public class SetupDriver {

	public static WebDriver driver;
	
	public static WebDriver getBrowserName() {
		
		String browser=BrowserInit.getBrowserName();
		if(browser.equalsIgnoreCase("chrome"))
			return chromeDriver();
//		if(browser.equalsIgnoreCase("edge"))
//			return edgeDriver();
//		if(browser.equalsIgnoreCase("firefox"))
//			return firefoxDriver();
		return null;
		
	}

	public static WebDriver chromeDriver() {

		String userProfile= "C:\\Users\\OLIMUKHE\\AppData\\Local\\Google\\Chrome\\User Data";
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Software\\Browser driver\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		options.addArguments("--user-data-dir="+userProfile);
		options.addArguments("--profile-directory=Default");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		driver.manage().window().maximize();
		return driver;
	}

//	public static WebDriver edgeDriver() {

//		String userProfile= "C:\\Users\\OLIMUKHE\\AppData\\Local\\Microsoft\\Edge\\User Data";
//		System.setProperty("webdriver.edge.driver", "C:\\Selenium_Software\\Browser driver\\edgedriver\\msedgedriver.exe");
//		EdgeOptions options = new EdgeOptions();
//		driver = new EdgeDriver(options);
//		options.setCapability(userProfile, options);
//		options.setCapability(userProfile, false);
//		options.addArguments("--disable-notifications");
//		options.addArguments("--start-maximized");
//		driver.manage().window().maximize();
//
//		return driver;
//	}
	
//	public static WebDriver firefoxDriver() {
//
////		String userProfile= "C:\\Users\\adeedv\\AppData\\Local\\Microsoft\\Edge\\User Data";
//		System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
//		//FireFoxOptions options = new FireFoxOptions();
//		driver=new FirefoxDriver();
////		options.addArguments("--user-data-dir="+userProfile);
////		options.addArguments("--profile-directory=Default");
////		options.addArguments("--disable-notifications");
////		options.addArguments("--start-maximized");
//		driver.manage().window().maximize();
//
//		return driver;
//
//	}

	public static void teardown() {
		
		driver.close();
        driver.quit();
		
	}

}
