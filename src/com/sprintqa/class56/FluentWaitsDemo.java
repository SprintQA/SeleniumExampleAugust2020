package com.sprintqa.class56;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FluentWaitsDemo {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: http://uitestpractice.com
			 * 1. Locate the Locator for the link "AjaxCall" and click it
			 * 2. Locate the Locator for the link "This is a Ajax link" and click it
			 * 3. Preparing the fluent wait to:
			 * 		- set timeout for 30s
			 * 		- poll every 5 sec (recheck the condition)
			 * 		- ignore NoSuchElementException
			 * 4. Wait for the presence Of the "ContactUs" Div Element to be Located.
			 * 5. Wait for the Element "ContactUs" Div Element to be visible
			 * 6. Wait until we find the Element "ContactUs" Div Element and return it.
			 * 		- If the element is not found before the timeout is reached the inner
			 * 		  function will return a null WebElement;
			 * 7. Check that contact us is displayed and write out it text to the console
			 */

		
			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
