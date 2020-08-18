package com.sprintqa.class52;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyboardActionsDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			// NOTE: there is a bug with MAC OSX and the Chrome Driver with Command not
			// working So, for this example we will be using Firefox instead.

			System.setProperty("webdriver.gecko.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/geckodriver");

			driver = new FirefoxDriver();

			String url = "https://demoqa.com/text-box";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Using Keyboard Actions to populate a User's Application Form 
			 * 1. Enter the user name: Bill Gates 
			 * 2. Enter Current Address: 
			 * 		Microsoft Corporation One
			 * 		Microsoft Way Redmond, WA 98052-6399 USA 
			 * 3. Enter Permanent Address: 
			 * 		This is the same as the Current Address in our case. 
			 * 		So, it is easy to copy text from the current address 
			 * 		field and paste it in the permanent address field. 
			 * 4. Click Submit button
			 */

		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			try {
				driver.quit();
			} catch (Exception e) {

			}
		}

	}

}
