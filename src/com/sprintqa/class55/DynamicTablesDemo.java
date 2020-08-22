package com.sprintqa.class55;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTablesDemo {

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
			 * 1. Using the Actions class log into OrangHRM
			 * 		- Locate the Username, Password, Login button
			 * 		- Pause 1 sec after clicking login to give the 
			 * 		  browser time to load the new page 
			 * 2. Click the "User Management" option on the menu
			 * 3. Read the Dynamic table
			 * 		- Write the number of cols and rows 
			 * 4. Create a String with the text "ESS" 
			 * 5. Create a String placeholder to store our row data 
			 * 	  as we loop through the table rows. 
			 * 6. Loop through rows
			 * 		- Get the text of the current row and store it 
			 *        in our string row data 
			 * 		- Write the current Row Data to the System.out console. 
			 * 		- Now check to see if the current row data contains the 
			 * 		  text in our String variable expected Text
			 * 			i. If true click on the cell. Pause for 1 sec to show click. 
			 * 			ii. Else go to the next row.
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
