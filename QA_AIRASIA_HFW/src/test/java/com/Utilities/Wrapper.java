package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrapper {
	
	public static WebDriver driver;
	Properties prop = new Properties();
	
	/******************************************
	 *  Driver created for Chrome Browser and maximize the browser 
	 * ***************************************/
	public void chromeBrowserLaunch() 
	  {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	  }
	
	/***************************************
	 *  Driver created for edge Browser and maximize the browser
	 ****************************************/
	public void edgeBrowserLaunch() 
	  {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
	  }
	
	/*********************************************************************
	 *  Muilti browser Launch based on user selection chrome/firefox/edge
	 *********************************************************************/
	public void multiBrowserLaunch(String browserName) 
	  {
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
		// kills the driver
		driver.quit();
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
	public void openingLangingPage(String x) 
	  {
		driver.get(x);
	  }

}
