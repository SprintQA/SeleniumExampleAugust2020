package com.sprintqa.class56;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWaitsDemo {

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
			 * Go to http://uitestpractice.com.
			 * 1. Preparing the explicit wait.
			 * 2. Wait until a WebElement is available and clickable
			 * 3. Locate the Locator for the link "AjaxCall" and click it
			 * 4. Locate the Locator for the link "This is a Ajax link" and click it
			 * 5. Wait for the presence Of the "ContactUs" Div Element to be Located.
			 * 6. Wait for the Element "ContactUs" Div Element to be visible
			 * 7. Get the "ContactUs" div text and write it to the System.out console.
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
