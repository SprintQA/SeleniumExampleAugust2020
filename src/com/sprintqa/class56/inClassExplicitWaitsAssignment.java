package com.sprintqa.class56;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class inClassExplicitWaitsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers
			 * 1. Set the amount of time to wait for a page load to complete before throwing
			 *    an error to 30s.
			 * 2. Locate the Locator for user name input and enter "Admin" text
			 * 3. Locate the locator for the login button and click it.
			 * 4. Preparing the explicit wait 30s.
			 * 5. Wait for the presence Of the "ContactUs" Div Element to be Located.
			 * 6. Locate the locator for the "USer Management" menu button and click it.
			 * 7. Wait for the Element "ContactUs" Div Element to be visible
			 * 8. Declare our Strings to store Expected String value
			 * 9. Locate the locator for the page title "System Users"
			 * 10. Verify that expected text System Users is displayed.
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
