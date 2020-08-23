package com.sprintqa.class56;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassImplicitWaitsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			/*
			 * An implicit wait tells the WebDriver to poll the DOM for a certain amount of
			 * time when trying to find an element or elements if they are not immediately
			 * available.
			 * 
			 * The default setting is 0, meaning disabled. Once set, the implicit wait is
			 * set for the life of the session.
			 * 
			 * Once this time is set, WebDriver will wait for the element before the
			 * exception occurs.
			 */
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: https://cnn.com
			 * 1. Set the web driver's implicit wait timeout to 30s
			 * 2. Set the amount of time to wait for a page load to complete before throwing
			 *    an error 30s.
			 * 3. Locate the Locator for user name input and enter "Admin" text
			 * 4. Locate the Locator for the password input and enter "admin123"
			 * 5. Locate the locator for the login button and click it.
			 * 6. Locate the locator for the "Admin" menu button and click it.
			 * 7. Declare our Strings to store Expected String value
			 * 8. Locate the locator for the "Admin" menu button and click it.
			 * 9. Verify that expected text System Users is displayed.
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
