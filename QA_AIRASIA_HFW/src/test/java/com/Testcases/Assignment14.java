package com.Testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;
import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class Assignment14 extends Wrapper
{
	Locators loc = new Locators();
	@Test
  private void Tc0001() throws FileNotFoundException, IOException, InterruptedException
   {
	  multiBrowserLaunch("chrome");
	  loaddata_From_Prop_File(".\\testData\\input.properties");
	  UrlPageOpening(getdata_from_prop("Assignment15URL"));
	  implicitWait(10);
	  String mainWindow = driver.getWindowHandle();
	  System.out.println(mainWindow);
	  //clicking "click to open new window"
	  clickByLocator(loc.stqatools_newWindow);
	  // get the main window and child window
	  Set<String> allWindowNames = driver.getWindowHandles();
	  // Split the values in a array
	  Iterator<String> abc = allWindowNames.iterator();
	  // print all multiple window names
	  while(abc.hasNext()) 
	   { 
		  String xyz = abc.next();
		  System.out.println(xyz);
		  if(!mainWindow.equalsIgnoreCase(xyz)) 
		    {
			  //Switching to child window
			  driver.switchTo().window(xyz);
			  implicitWait(10);
			  driver.close();
		    }
	   }
	  implicitWait(10);
	  // Switching window to parent window
	  driver.switchTo().window(mainWindow);
	  implicitWait(10);
	 
	  
	  browserClosing();
   }	

}
