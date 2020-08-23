package com.sprintqa.class56;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitsDemo {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://cnn.com";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: https://cnn.com
			 * 1. Set the web driver's implicit wait timeout to 30s
			 * 2. Set the amount of time to wait for a page load to complete before throwing
			 *    an error.
			 * 3. Find and click on the World Link
			 * 4. Get the World Header tag
			 * 5. Verify that the world header is displayed.
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
