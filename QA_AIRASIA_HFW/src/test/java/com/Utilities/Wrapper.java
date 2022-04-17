package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrapper {
	
	public static WebDriver driver;
	
	public Wrapper() 
	{
	File screenShotPath = new File(".\\ScreenShots");
	if(screenShotPath.exists()) 
		{
		System.out.println("ScreenShots folder is avilable");
		}
	else 
		{
		screenShotPath.mkdir();
		System.out.println("ScreenShot folder is created");
		}
	}
	
	
	Properties prop = new Properties();
	
	/******************************************
	 *  Driver created for Chrome Browser and maximize the browser 
	 * ***************************************/
	public void chromeBrowserLaunch() 
	  {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome Browser launched and maximized");
	  }
	
	/****************************************
	 *  Driver created for firefox Browser and maximize the browser
	 * 
	 * ***************************************/
	public void firefoxBrowserLaunch() 
	  {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("FireFox Browser launched and maximized");
	  }
	
	/***************************************
	 *  Driver created for edge Browser and maximize the browser
	 ****************************************/
	public void edgeBrowserLaunch() 
	  {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		System.out.println("Edge Browser launched and maximized");
	  }
	
	/*********************************************************************
	 *  Muilti browser Launch based on user selection chrome/firefox/edge
	 *********************************************************************/
	public void multiBrowserLaunch(String browserName) 
	  {
		System.out.println("Choosing One in multibrowser");
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			chromeBrowserLaunch();
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			firefoxBrowserLaunch();
		}
		else if(browserName.equalsIgnoreCase("edge")) 
		{
			edgeBrowserLaunch();
		}
		else {
			System.out.println("******Please check the browerName******");
		}
	  }
	
	/************************************************************
	 * Browser Closing with time delay of 3 sec
	 * @throws InterruptedException 
	 * **********************************************************/
	public void browserClosing() throws InterruptedException 
	 {
		Thread.sleep(3000);
		//close - closes the current tab if it is the only tab it closes the browser
		driver.close();
		System.out.println("Browser closed and quit the driver");
	 }

	/************************************************************
	 *  to get read the data from Property file
	 ************************************************************/
	public void loaddata_From_Prop_File(String path) throws FileNotFoundException,IOException 
	{
		File file = new File(path);
		FileInputStream fileInput = null;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		System.out.println("loading properties file");
	}
	
	/***********************************************************
	 * get data from input stream file
	 ***********************************************************/
	public String getdata_from_prop(String key) throws IOException
	{
		String keyvalue = null;
		keyvalue = prop.getProperty(key);
		return keyvalue;
		
	}
	/***********************************************************
	 * get data from input stream file
	 * @return 
	 ***********************************************************/
	public void UrlPageOpening(String x) 
	  {
		implicitWait(10);
		driver.get(x);
	  }
		
	
	/***********************************************************
	 ClickByLocator 
	 * @throws InterruptedException 
	 ***********************************************************/
	public void clickByLocator(By locat) throws InterruptedException 
	{
		WebElement element = driver.findElement(locat);
		if(element.isDisplayed()) 
		  {
			System.out.println(locat+" : element is enabled"); 
			if(element.isEnabled()) 
			{
				driver.findElement(locat).click();	
				implicitWait(10);
				System.out.println(locat+" : element clicked"); 
			}
			else 
			{
			System.out.println(locat+" : element is not enabled"); 
			}
		  }
		else 
		{
		System.out.println(locat+" : element is not displayed"); 
		}
	}
	
	
	/****************************************************************
	 * Implicity wait
	 * **************************************************************/
	public void implicitWait(int time) 
	 {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("******ImplicitWait method used ******");
	 }

}
