package com.sprintqa.class55;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingCelendarsWithTablesDemo {

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
			 * 1. Using the Actions class log into OrangHRM
			 * 		- Locate the Username, Password, Login button
			 * 		- Pause 1 sec after clicking login to give the 
			 * 		  browser time to load the new page 
			 * 2. Go to leave menu option
			 * 3. Go to My Leave submenu option
			 * 4. Change the search filter to only pull the days for June 2020
			 * 5. Click search
			 * 6. Read table information
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
