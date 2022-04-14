package com.Testcases;

import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class Ts1 extends Wrapper
{
Locators loc = new Locators();


@Test
public void tc001() throws Exception 
  {
	chromeBrowserLaunch();
	
	loaddata_From_Prop_File(".\\testData\\input.properties");
	openingLangingPage(getdata_from_prop("HomePageURL"));
	browserClosing();
  }

}
