package com.Testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.Wrapper;

public class Ts1 extends Wrapper {
	Locators loc = new Locators();

	/*********************************************************************
	 * Before function to run driver creation and loading properties file
	 *********************************************************************/
	public void BeforeTestcaseRun(String x) throws FileNotFoundException, IOException {
		loaddata_From_Prop_File(".\\testData\\input.properties");
		multiBrowserLaunch(x);
	}

	/*********************************************************************
	 * After function to run driver creation and loading properties file
	 * 
	 * @throws InterruptedException
	 *********************************************************************/
	public void AfterTestcaseRun() throws FileNotFoundException, IOException, InterruptedException {
		browserClosing();
	}

	/************************************************************
	 * Test case to check project home page is opening or not
	 **************************************************************/
	public void mainPage(String x) throws Exception {
		BeforeTestcaseRun(getdata_from_prop("ChooseBrowser"));
		UrlPageOpening(x);
		implicitWait(10);
	}

	/************************************************************
	 * Test case to check project home page is opening or not
	 **************************************************************/
	@Test
	public void tc001() throws Exception {
		mainPage(getdata_from_prop("HomePageURL"));
		implicitWait(10);
		}

	/************************************************************
	 * Test case to check check-in tab is available or not
	 * 
	 * @throws Exception
	 **************************************************************/
	@Test
	public void tc002() throws Exception {
		mainPage(getdata_from_prop("HomePageURL"));
		clickByLocator(loc.check_in_tab);
		AfterTestcaseRun();
	}

}
