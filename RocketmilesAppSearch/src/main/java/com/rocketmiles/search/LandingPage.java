package com.rocketmiles.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage 
{

	
	public WebDriver driver;
	
	
	
	@FindBy(tagName="body")
    WebElement signupModal;
	
	@FindBy(xpath="//button[@class='btn cookie-banner-button ng-scope']")
    WebElement cookiesBanner;
	
	@FindBy(xpath="//input[@placeholder='Where do you need a hotel?']")
    WebElement locationBox;
	
	@FindBy(xpath="//div[@class='popover-content']")
    WebElement locationRequiredError;
		
	@FindBy(xpath="//input[@placeholder='Select reward program']")
    WebElement rewardDropdown;
	
	@FindBy(xpath="//div[@class='checkin booking-date']")
    WebElement checkInDate;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")
    WebElement currentDate;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-active ui-state-hover']")
    WebElement futureDate;
	
	@FindBy(xpath="//div[@class='checkout booking-date']")
    WebElement checkOutDate;
	
	@FindBy(xpath="//div[@class='adults col-sm-3 search-field']//button[@class='btn dropdown-toggle form-control']")
    WebElement guestsDropdown;
	
	@FindBy(xpath="//a[contains(text(),'5 Guests')]")
    WebElement guestsPicker;

	@FindBy(xpath="//div[@class='rooms col-sm-3 search-field ng-scope']//button[@class='btn dropdown-toggle form-control']")
    WebElement roomsDropdown;
	
	@FindBy(xpath="//button[@class='rm-btn-orange search-submit-btn']")
    WebElement searchButton;
	
	
	
	
	
	public LandingPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement closeSignupModal()
	{
		return signupModal;
	}
	
	public WebElement agreeToCookies()
	{
		return cookiesBanner;
	}
	
	public WebElement setLocation()
	{
		return locationBox;
	}
	
	public WebElement setReward()
	{
		return rewardDropdown;
	}

	public WebElement setCheckIn()
	{
		return checkInDate;
	}
	
	public WebElement setCheckOut()
	{
		return checkOutDate;
	}
	
	public WebElement displayGuests()
	{
		return guestsDropdown;
	}
	
	public WebElement setRooms()
	{
		return roomsDropdown;
	}
	
	public WebElement setGuests()
	{
		return guestsPicker;
	}
	
	
	
	
	
	
	
}
