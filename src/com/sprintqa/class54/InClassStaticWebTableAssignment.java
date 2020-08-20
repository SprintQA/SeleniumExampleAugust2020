package com.sprintqa.class54;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassStaticWebTableAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://the-internet.herokuapp.com/tables";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: https://the-internet.herokuapp.com/tables
			 * 1. Locate the WebElements for Static Web Table
			 * 2. Locate the Locator you need to use to find the table headers.
			 * 3. Write out the number of columns using the Collector size() method.
			 * 4. Loop through the TH tags in Row 1
			 * 5. Write out the number of table rows
			 * 6. Loop through Collection of rows and write out the row text
			 */
			
			
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	
}
