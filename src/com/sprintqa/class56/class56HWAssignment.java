package com.sprintqa.class56;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class class56HWAssignment {
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
			 * 
			 * 1. Locate the Locator for user name input and enter "Admin" text
			 * 2. Locate the Locator for the password input and enter "admin123"
			 * 3. Locate the locator for the login button and click it.
			 * 4. Preparing the explicit wait.
			 * 5. Wait for the presence Of the "User Management" option on the menu bar to
			 * 	  be Located.
			 * 6. Click the "User Management" option on the menu bar.
			 * 7. Wait for the presence Of the "User Role" drop down to be Located.
			 * 8. Wait for the "User Role" drop down to be clickable.
			 * 9. In the "System Users" section Select "ESS" from the "User Role" drop down.
			 * 10. In the "System Users" section click the "Search" button
			 * 11. Wait for the presence Of the "Users Table" to be Located.
			 * 12. Locate all the row data in the table and write our the number of rows to
			 * 	   the System.out console.
			 * 13. Locate the column data in the table and write our the number of columns
			 * 	   to the System.out console.
			 * 14. Write out all the row data to the System.out console
			 * 15. Click the check box for each row in the table
			 * 16 In the "System Users" section Select "Admin" from the "User Role" drop
			 * 	  down.
			 * 17. In the "System Users" section click the "Search" button
			 * 18. Wait for the presence Of the "Users Table" to be Located.
			 * 19. Locate all the row data in the table and write our the number of rows to
			 *     the System.out console.
			 * 20. Locate the column data in the table and write our the number of columns
			 *     to the System.out console.
			 * 21. Write out all the row data to the System.out console 21. If the row has a
			 *     check box click it
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
