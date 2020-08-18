package com.sprintqa.class52;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InClassKeyboardActionsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			// NOTE: there is a bug with MAC OSX and the Chrome Driver with Command not working
			// So, for this example we will be using Firefox instead.
			
			System.setProperty("webdriver.gecko.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/geckodriver");

			driver = new FirefoxDriver();

			String url = "https://omayo.blogspot.com/";
			driver.get(url);
			driver.manage().window().maximize();
			
			/*
			 * Using Keyboard Actions to Copy and Paste 
			 * 1. Copy the text from Text Area Field Two. 
			 * 2. Past the text into Text Area Field 
			 */

		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			try {
				driver.quit();
			}catch(Exception e) {
				
			}
		}

	}
	
}
