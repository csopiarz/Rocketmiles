package com.rocketmiles.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{

	public WebDriver driver;

	@BeforeMethod
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\search.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Initiating " + browserName + " Browser");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.rocketmiles.com");
			
		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	
	
}
