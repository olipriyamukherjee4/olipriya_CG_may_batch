package com.magicbrics_step_definitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.TakesScreenshot;


import com.magicbricks_runner.Magicbrickspagefactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Test_Steps 
{
	private WebDriver driver;
	private Magicbrickspagefactory magicbricks;
	FileInputStream FRead;	
	FileOutputStream FWrite;
	XSSFWorkbook wb;
	XSSFSheet sh;
	String pass="Test case is Passed";
	String fail="Test case is Failed";
	int rowval, rowcount;
	String screenShotfilename =  new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

	@Before
	public void openBrowser() throws Exception{
		//launching web browser....
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Software\\Browser driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		 WebDriver driver= SetupDriver.getBrowserName();

		magicbricks= new Magicbrickspagefactory(driver);
		driver.manage().window().maximize();

		//using pagefactory file as reference....
		magicbricks=PageFactory.initElements(driver, Magicbrickspagefactory .class);

		//reading file from excel....
		FRead= new FileInputStream("./Excel_Data/magicbricks_data_sheet.xlsx");
		wb=new XSSFWorkbook(FRead);
		
	}

	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("User is on home page");
		driver.navigate().to("https://www.magicbricks.com/");			
	}

	@When("user do not select location")
	public void user_do_not_select_location() throws Exception {
		Actions act1 = new Actions(driver); 
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getLocation()).click()
		.moveToElement(magicbricks.getClose_location()).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user do not select property type")
	public void user_do_not_select_property_type() throws Exception {
		Actions act1 = new Actions(driver); 
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getPropertyType()).click().moveToElement(magicbricks.getPropFlat()).click()
		.moveToElement(magicbricks.getPropHouseVilla()).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user do not select budget")
	public void user_do_not_select_budget() {
		System.out.println("Property Type not selected");
	}

	@When("click on search")
	public void click_on_search() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.className("mb-search__btn")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@Then("Alert please enter a valid Location or Project")
	public void alert_please_enter_a_valid_Location_or_Project() throws Exception {
		Thread.sleep(2000);
		System.out.println("Alert ===>  Please enter a valid Location or Project");
	}

	@Then("close")
	public void close() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("Closing the Browser");
		driver.close();
	}

	@When("user select resedential property type")
	public void user_select_resedential_property_type() throws Exception {
		Thread.sleep(1500);
		Actions act1 = new Actions(driver); 
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getPropertyType111()).click().build().perform();	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select only budget")
	public void user_select_only_budget() throws Exception {
		Thread.sleep(1500);
		Actions act1 = new Actions(driver); 
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getBudget()).click().moveToElement(magicbricks.getMin_Budget()).click()
		.moveToElement(magicbricks.getMax_Budget()).click().build().perform();	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select only valid location")
	public void user_select_only_valid_location() throws Exception {
		sh= wb.getSheet("User_Prefernce");
		String City =sh.getRow(1).getCell(0).getStringCellValue(); 
		Actions act1 = new Actions(driver); 
		Thread.sleep(1500);
		act1.moveToElement(magicbricks.getTxtLocation()).click().moveToElement(magicbricks.getClose_location()).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("keyword")).sendKeys(City);
		Thread.sleep(1500);
		act1.moveToElement(magicbricks.getCityName()).click().moveToElement(magicbricks.getTxtLocation()).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@Then("navigate user to buy page")
	public void navigate_user_to_buy_page() throws Exception {
		System.out.println("User is on buy page");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select valid location")
	public void user_select_valid_location() throws Exception {
		sh= wb.getSheet("User_Prefernce");
		String City =sh.getRow(1).getCell(0).getStringCellValue(); 
		Actions act1 = new Actions(driver); 
		Thread.sleep(1500);
		act1.moveToElement(magicbricks.getTxtLocation()).click().moveToElement(magicbricks.getClose_location()).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.id("keyword")).sendKeys(City);
		Thread.sleep(1500);
		act1.moveToElement(magicbricks.getCityName()).click().moveToElement(magicbricks.getTxtLocation()).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select budget")
	public void user_select_budget() throws Exception {
		Thread.sleep(1500);
		Actions act1 = new Actions(driver); 
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getBudget()).click().moveToElement(magicbricks.getMin_Budget()).click()
		.moveToElement(magicbricks.getMax_Budget()).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user enter invalid location")
	public void user_enter_invalid_location() throws Exception {
		sh= wb.getSheet("Search_Invalid_Data");
		String InvLocation =sh.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(1500);
		driver.findElement(By.id("keyword")).sendKeys(InvLocation);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select property type")
	public void user_select_property_type() throws Exception {
		Thread.sleep(1500);
		Actions act1 = new Actions(driver); // action class used object name given act
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getPropertyType111()).click().build().perform();	 
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select valid budget")
	public void user_select_valid_budget() throws Exception {
		Thread.sleep(1500);
		Actions act1 = new Actions(driver); // action class used object name given act
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getBudget()).click().moveToElement(magicbricks.getTxtMinBudget()).click().moveToElement(magicbricks.getTxtMinBudget()).sendKeys("500000")
		.moveToElement(magicbricks.getTxtMaxBudget()).click().moveToElement(magicbricks.getTxtMaxBudget()).sendKeys("4000000").build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select invalid budget")
	public void user_select_invalid_budget() throws Exception {
		Thread.sleep(1500);
		Actions act1 = new Actions(driver); // action class used object name given act
		Thread.sleep(1000);
		act1.moveToElement(magicbricks.getBudget()).click().moveToElement(magicbricks.getTxtMinBudget()).click().moveToElement(magicbricks.getTxtMinBudget()).sendKeys("12000")
		.moveToElement(magicbricks.getTxtMaxBudget()).click().moveToElement(magicbricks.getTxtMaxBudget()).sendKeys("30000").build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@Then("Alert We couldn't find matching Properties!")
	public void alert_We_couldn_t_find_matching_Properties() {
		System.out.println("Alert======> We couldn't find matching Properties!");
	}

	@When("user select Home Loans")
	public void user_select_Home_Loans() throws Exception {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
	    jse.executeScript("window,scrollBy(0,2000);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(0,2000);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(0,2000);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(0,2000);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(2000,0);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(2000,0);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(2000,0);");
	    Thread.sleep(1500);
	    jse.executeScript("window,scrollBy(2000,0);");
		Thread.sleep(4000);
		Actions act= new Actions(driver);
		act.moveToElement(magicbricks.getHomeloan()).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("click on Home Loan")
	public void click_on_Home_Loan() throws Exception {
		driver.get("https://www.magicbricks.com/homeloan/home");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));

	}

	@Then("navigate user to home loan page")
	public void navigate_user_to_home_loan_page() {
		System.out.println("User is in home lone page");

	}

	@When("user enter valid loan amount")
	public void user_enter_valid_loan_amount() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("loanAmount")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("loanAmount")).sendKeys("10000000");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user enter valid Mobile number")
	public void user_enter_valid_Mobile_number() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("mobileNumber")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("mobileNumber")).sendKeys("8637829478");	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user select checkbox to agree privacy policy")
	public void user_select_checkbox_to_agree_privacy_policy() throws Exception {
		Thread.sleep(6000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("click on Get Started")
	public void click_on_Get_Started() throws Exception {
		driver.findElement(By.id("generate-otp")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));

	}

	@Then("navigate to Application done succesfully page")
	public void navigate_to_Application_done_succesfully_page() {
		System.out.println("Sucessfully Navigate to verification page");
	}

	@When("user enter invalid loan amount")
	public void user_enter_invalid_loan_amount() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("loanAmount")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("loanAmount")).sendKeys("35000");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@Then("Alert Loan amount can not be less")
	public void alert_Loan_amount_can_not_be_less_than(){
		System.out.println("Alert====> Loan amount can not be less than 100000");
	}

	@When("user enter invalid Mobile number")
	public void user_enter_invalid_Mobile_number() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("mobileNumber")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("mobileNumber")).sendKeys("1637@#");	
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@Then("Mobile number is not valid")
	public void mobile_number_is_not_valid() {
		System.out.println("Alert====>Mobile number is not valid");
	}

	@When("user do not select checkbox to agree privacy policy")
	public void user_do_not_select_checkbox_to_agree_privacy_policy() {
		//Skip
	}

	@Then("Alert agree privacy policy")
	public void alert_agree_privacy_policy() {
		System.out.println("Alert====>Alert agree privacy policy");	
	}

	@When("user select My Activity")
	public void user_select_My_Activity() throws Exception {
		Thread.sleep(4000);
		WebElement loginhead = driver.findElement(By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[7]/a"));
		Actions act= new Actions(driver);
		act.moveToElement(loginhead).click().build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("click on Manage Properties")
	public void click_on_Manage_Properties() {
		driver.navigate().to("https://accounts.magicbricks.com/userauth/login");
		//driver.get("https://accounts.magicbricks.com/userauth/login");	
	}

	@When("user is in login page")
	public void navigate_to_user_login_page() throws Exception {
		Thread.sleep(3000);
		WebElement loginmob = driver.findElement(By.xpath("//*[@id=\"emailOrMobile\"]"));
		Actions act= new Actions(driver);
		act.moveToElement(loginmob).click().build().perform();
		Thread.sleep(1500);
		act.moveToElement(loginmob).sendKeys("8637829478").build().perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("click on Next")
	public void click_on_Next() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.id("btnStep1")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
	}

	@When("user put otp")
	public void user_put_otp() throws Exception {
		Thread.sleep(50000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(2000);
//		System.out.println("User put otp");
	}

	@When("click on Continue")
	public void click_on_continue() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"verifyOtpDiv\"]/div[2]/div[3]/button")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User click on Continue");
	}

	@Then("navigate from add to main page")
	public void navigate_from_add_page() throws Exception {
		Thread.sleep(3000);
		driver.navigate().back();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User navigate from add to main page");
	}

	@Then("click buy for assitance")
	public void click_buy_for_assitance() throws Exception {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/header/div/div[3]/div[1]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/header/div/div[3]/div[1]/ul/li[1]/div/div[2]/div/div/div[4]/ul/li[3]/span")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User click buy for assitance");
	}

	@Then("navigate to Property Alert page")
	public void navigate_to_Property_Alert_page() {
		System.out.println("User is in Property Alert Page");
	}

	@When("user select Buy")
	public void user_select_Buy() {
		System.out.println("By Default Buy Selected");
	}
	@When("user select buy property type")
	public void user_select_buy_property_type() throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.id("textPropertySell")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("propertyTypeSell_10001")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select buy property type");
	}

	@When("user select buy budget")
	public void user_select_buy_budget() throws Exception {
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("bedroom")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("budgetBuyDDList")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("budgetBuy_11802-11803")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select buy budget");
	}


	@When("user select bedroom")
	public void user_select_bedroom() throws Exception {
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("bedroom")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("textBedRoom")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("bedrooms_11700")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select bedroom");
	}

	@When("user select Construction Status")
	public void user_select_Construction_Status() throws Exception {
		System.out.println("Construction status selected");
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("constructionStatus")).click();
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("possStatus_10080")).click();
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("possStatus_10081")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select Construction Status");
	}

	@When("user select area")
	public void user_select_area() throws Exception {
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("area")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("coveredAreaDDList")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"coveredArea\"]/div[2]/div[2]/div[2]/ul/li[4]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"coveredArea\"]/div[2]/div[2]/div[3]/ul/li[7]")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select area");

	}

	@When("user select city")
	public void user_select_city() throws Exception {
		//		Thread.sleep(1500);
		//		driver.findElement(By.id("formElement")).click();
		Thread.sleep(1500);
		driver.findElement(By.name("keyword")).click();
		sh= wb.getSheet("User_Prefernce");
		String City =sh.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(1500);
		driver.findElement(By.name("keyword")).sendKeys(City);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"keyword_suggest\"]/div[2]")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select city");
	}
	

	@When("user select locality or project")
	public void user_select_locality_or_project() throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.name("keywordLoc")).click();
		Thread.sleep(1500);
		driver.findElement(By.name("keywordLoc")).sendKeys("New");
		Thread.sleep(1500);
		driver.findElement(By.id("//*[@id=\"keyword_suggest_Loc\"]/div[2]")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select locality or project");
	}

	@When("user select Recieve Alert For")
	public void user_select_Recieve_Alert_For() {
		System.out.println("User selected alert received");
	}

	@When("user select Alert Frequency")
	public void user_select_Alert_Frequency() throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.id("alertFrequency_1203433")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select Alert Frequency");
	}

	@When("user select I agree to privacy policy")
	public void user_select_I_agree_to_privacy_policy() throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.id("tnc")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User select I agree to privacy policy");
	}

	@When("click on Share Your Requirement")
	public void click_on_Share_Your_Requirement() throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.id("postReqSubmit")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User click on Share Your Requirement");
	}

	@Then("navigate to Alert saved successfully page")
	public void navigate_to_Alert_saved_successfully_page() {
		System.out.println("User navigated to Saved sucessfully page");
	}

	@Then("user do not select buy property type")
	public void user_do_not_select_buy_property_type() {
		//skip
		
	}

	@Then("user do not select buy budget")
	public void user_do_not_select_buy_budget() {
		//skip
		
	}

	@Then("Alert Select atleast one Property Type")
	public void alert_Select_atleast_one_Property_Type() {
		System.out.println("Alert===> Select Atleast one Property Type");

	}

	@Then("Alert Select budget range.")
	public void alert_Select_budget_range() {
		System.out.println("Alert===> Select budget range");

	}

	@When("user do not select bedroom")
	public void user_do_not_select_bedroom() {
		// skip

	}

	@Then("Alert Select number of bedrooms.")
	public void alert_Select_number_of_bedrooms() {
		System.out.println("Alert===> Select number of bedrooms");
		
	}

	@When("user do not select Construction Status")
	public void user_do_not_select_Construction_Status() throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.id("constructionStatus")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("possStatus_10080")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("possStatus_10081")).click();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenShotfilename+"_Olipriya.png"));
//		Thread.sleep(3000);
//		System.out.println("User do not select Construction Status");

	}

	@Then("Alert Select atleast one construction status")
	public void alert_Select_atleast_one_construction_status() {
		System.out.println("Alert====> Select atleast one construction status");	

	}



}
