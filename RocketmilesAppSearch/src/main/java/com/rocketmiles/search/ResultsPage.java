package com.rocketmiles.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage 
{
	
	WebDriver driver;
	
	
	
	@FindBy(tagName="body")
    WebElement holder;
	
	
	@FindBy(xpath="//img[@ng-src='https://www.rocketmiles.com/static/hbwJ46km0YDJYMnskd9hLdogcFWLFWppqHY5S9BILmb.png']")
    WebElement unitedMileagePlusLogo;
	
	@FindBy(xpath="//div[@class='results show-list']")
    WebElement searchResultsList;
	
	@FindBy(xpath="//span[contains(text(),'5 Guests')]")
    WebElement searchResultsGuests;
	
	@FindBy(xpath="//span[contains(text(),'2 Rooms')]")
    WebElement searchResultsRooms;
	
	@FindBy(xpath="//input[@placeholder='Where do you need a hotel?']")
    WebElement locationBox;
	
	
	
	
	
	
	
	public ResultsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement unitedMileagePlusLogo()
	{
		return unitedMileagePlusLogo;
	}
	
	public WebElement searchResultsList()
	{
		return searchResultsList;
	}
	
	public WebElement searchResultsGuests()
	{
		return searchResultsGuests;
	}
	
	public WebElement searchResultsRooms()
	{
		return searchResultsRooms;
	}
	
	public WebElement setLocation()
	{
		return locationBox;
	}
	
}
