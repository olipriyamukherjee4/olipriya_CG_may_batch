package com.magicbricks_runner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Magicbrickspagefactory {
	// pom with page factory 
    WebDriver driver;
	@FindBy(id="keyword")
	@CacheLookup
	WebElement location;

	@FindBy(className="mb-search__tag-close")
	@CacheLookup
	WebElement close_location;
 

	@FindBy(className="mb-search__title")
	@CacheLookup
	WebElement PropertyType;
	 

	@FindBy(id="10002_10003_10021_10022")
	@CacheLookup
	WebElement propFlat;
	

	@FindBy(id="10001_10017")
	@CacheLookup
	WebElement propHouseVilla;
	

	@FindBy(id="buy_proertyTypeDefault")
	@CacheLookup
	WebElement PropertyType111;


	@FindBy(id="rent_budget_lbl")
	@CacheLookup
	WebElement Budget;

	

	@FindBy(xpath="//*[@id=\"minBudjet\"]/div[2]")
	@CacheLookup
	WebElement Min_Budget;


	@FindBy(xpath="//*[@id=\"maxBhkIndex_4\"]")
	@CacheLookup
	WebElement Max_Budget;


	@FindBy(id="keyword")
	@CacheLookup
	WebElement txtLocation;


	@FindBy(xpath="//*[@id='serachSuggest']/div[2]")
	@CacheLookup
	WebElement CityName;

//	======================================================>

	@FindBy(id="budgetMin")
	@CacheLookup
	WebElement TxtMinBudget;


	@FindBy(id="budgetMax")
	@CacheLookup
	WebElement TxtMaxBudget;

	@FindBy(xpath="//*[@id=\"propertysrp\"]/div[1]/div/div/div[5]/a")
	@CacheLookup
	WebElement Homeloan;


	@FindBy(xpath="//*[@id=\"propertysrp\"]/div[1]/div/div/div[7]/a")
	@CacheLookup
	WebElement loginhead;

	@FindBy(xpath="//*[@id=\"emailOrMobile\"]")
	@CacheLookup
	WebElement loginmob;

	public Magicbrickspagefactory (WebDriver driver) {
	this.driver = driver;
	//PageFactory.initElements(driver, this);
	}

	public WebElement getLocation(){
	return location;
	}

	public void setLocation(String locationname)
	{
	this.location.sendKeys(locationname);
	}

	public WebElement getClose_location(){
	return close_location;
	}

	public void setClose_location()//String close_location
	{
	this.close_location.click();    //sendKeys(close_location);
	}

	public WebElement getPropertyType(){
	return PropertyType;
	}

	public void setPropertyType(String PropertyType)
	{
	this.PropertyType.sendKeys(PropertyType);
	}

	public WebElement getPropFlat(){
	return propFlat;
	}

	public void setPropFlat(String propFlat)
	{
	this.propFlat.sendKeys(propFlat);
	}

	public WebElement getPropHouseVilla()
	{
	return propHouseVilla;
	}

	public void setPropHouseVilla(String propHouseVilla)
	{
	this.propHouseVilla.sendKeys(propHouseVilla);
	}

	public WebElement getPropertyType111(){
	return PropertyType111;
	}

	public void setPropertyType111(String PropertyType111)
	{
	this.PropertyType111.sendKeys(PropertyType111);
	}

	public WebElement getBudget(){
	return Budget;
	}

	public void setBudget(String Budget)
	{
	this.Budget.sendKeys(Budget);
	}

	public WebElement getMin_Budget()
	{
	return Min_Budget;
	}

	public void setMin_Budget(String Min_Budget)
	{
	this.Min_Budget.sendKeys(Min_Budget);
	}
	
	public WebElement getMax_Budget()
	{
	return Max_Budget;
	}

	public void setMax_Budget(String Max_Budget)
	{
	this.Max_Budget.sendKeys(Max_Budget);
	}

	public WebElement getTxtLocation(){
	return txtLocation;
	}

	public void setTxtLocation(String txtLocation)
	{
	this.txtLocation.sendKeys(txtLocation);
	}


	public WebElement getCityName()
	{
	return CityName;
	}

	public void setCityName(String CityName)
	{
	this.CityName.sendKeys(CityName);
	}

	public WebElement getTxtMinBudget()
	{
	return TxtMinBudget;
	}

	public void setTxtMinBudget(String TxtMinBudget)
	{
	this.TxtMinBudget.sendKeys(TxtMinBudget);
	}

	public WebElement getTxtMaxBudget()
	{
	return TxtMaxBudget;
	}

	public void setTxtMaxBudget(String TxtMaxBudget)
	{
	this.TxtMaxBudget.sendKeys(TxtMaxBudget);
	}
	
	public WebElement getHomeloan()
	{
		return Homeloan;
	}
	public void setHomeloan(String Homeloan)
	{
		this.Homeloan.sendKeys(Homeloan);
	}
	
	public WebElement getLoginhead()
	{
	return loginhead;
	}

	public void setLoginhead(String loginhead)
	{
	this.loginhead.sendKeys(loginhead);
	}

	public WebElement getLoginmob()
	{
	return loginmob;
	}

	public void getLoginmob(String loginmob)
	{
	this.loginmob.sendKeys(loginmob);
	}
}

