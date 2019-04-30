package com.rocketmiles.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rocketmiles.search.BaseClass;
import com.rocketmiles.search.LandingPage;
import com.rocketmiles.search.ResultsPage;

public class SearchTest extends BaseClass
{
	
	
	
	@Test(priority=10)
	public void locationRequired() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		
		Reporter.log("===== Test: Location Required Started =====", true);
		
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		lp.searchButton.click();
		
		String locationRequiredError = lp.locationRequiredError.getText();
		Assert.assertEquals(locationRequiredError, prop.getProperty("locationRequiredError"));		
	
		
		Reporter.log("===== Test: Location Required Complete =====", true);
				
	}

	@Test(priority=20)
	public void locationVerification() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		Reporter.log("===== Test: Location Search Started =====", true);
		
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		lp.searchButton.click();
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("pageTitle"));		
		
		Assert.assertEquals(true, rp.searchResultsList.isDisplayed());
		
		Reporter.log("===== Test: Location Search Complete =====", true);
				
	}
	
	@Test(priority=30)
	public void rewardProgramRequired() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		
		Reporter.log("===== Test: Reward Program Required Started =====", true);
		
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);	
		lp.searchButton.click();
		
		String locationRequiredError = lp.locationRequiredError.getText();
		Assert.assertEquals(locationRequiredError, prop.getProperty("locationRequiredError"));		
	
		
		Reporter.log("===== Test: Reward Program Required Complete =====", true);
				
	}
	
	@Test(priority=40)
	public void RewardProgramVerification() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		Reporter.log("===== Test: Reward Program Search Started =====", true);
		
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		lp.searchButton.click();
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("pageTitle"));		
		Assert.assertEquals(true, rp.searchResultsList.isDisplayed());
		Assert.assertEquals(true, rp.unitedMileagePlusLogo().isDisplayed());
		
		Reporter.log("===== Test: Reward Program Search Complete =====", true);
				
	}
	
	@Test(priority=50)
	public void checkinVerification() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		Reporter.log("===== Test: Checkin Verification Started =====", true);
		
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		
		
		lp.checkInDate.click();
		lp.currentDate.click();
		lp.searchButton.click();
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("pageTitle"));		
		Assert.assertEquals(true, rp.searchResultsList.isDisplayed());
				
		Reporter.log("===== Test: Checkin Verification Complete =====", true);
				
	}
	
	@Test(priority=60)
	public void checkoutVerification() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		Reporter.log("===== Test: Checkout Verification Started =====", true);
		
	    
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		
		
		lp.checkOutDate.click();
		
		lp.futureDate.click();
		Thread.sleep(100L);
		lp.searchButton.click();
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("pageTitle"));		
		Assert.assertEquals(true, rp.searchResultsList.isDisplayed());
				
		Reporter.log("===== Test: Checkout Verification Complete =====", true);
				
	}
	
	@Test(priority=70)
	public void guestsVerification() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		Reporter.log("===== Test: Guests Verification Started =====", true);
		
	    
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		
		
		lp.guestsDropdown.click();
		lp.setGuests().click();
		lp.searchButton.click();
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("pageTitle"));		
		Assert.assertEquals(true, rp.searchResultsList.isDisplayed());
		rp.searchResultsGuests.isDisplayed();
				
		Reporter.log("===== Test: Guests Verification Complete =====", true);
				
	}
	
	
	
	@Test(priority=80)
	public void roomVerification() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		LandingPage lp = new LandingPage(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		Reporter.log("===== Test: Room Verification Started =====", true);
		
	    
		lp.closeSignupModal().sendKeys(Keys.ESCAPE);
		lp.agreeToCookies().click();
		
		lp.locationBox.sendKeys(prop.getProperty("location"));
		Thread.sleep(500L);
		lp.locationBox.sendKeys(Keys.ARROW_DOWN, Keys.TAB);
		
		lp.setReward().sendKeys(prop.getProperty("rewardProgram"), Keys.ARROW_DOWN, Keys.TAB);		
		
		lp.roomsDropdown.click();
		lp.roomsDropdown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.TAB);
		lp.searchButton.click();
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, prop.getProperty("pageTitle"));		
		Assert.assertEquals(true, rp.searchResultsList.isDisplayed());
		rp.searchResultsRooms.isDisplayed();
				
		Reporter.log("===== Test: Room Verification Complete =====", true);
				
	}
	
	
	
	
	

	
}
