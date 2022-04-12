package com.Testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class Ts1 extends Wrapper
{
Locators loc = new Locators();



public void tc001() throws InterruptedException, FileNotFoundException, IOException 
  {
	chromeBrowserLaunch();
	loaddata_From_Prop_File(".\\testData\\input.properties");
	project_Main_Page_URL_Launch(getdata_From_Fileinputstream("HomePageURL"));
	Thread.sleep(3000);
  }

}
