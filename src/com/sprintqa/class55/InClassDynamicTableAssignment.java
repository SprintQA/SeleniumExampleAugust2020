package com.sprintqa.class55;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InClassDynamicTableAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx
			 * 1. Locate the Locator for the user name input and enter "Tester"
			 * 2. Locate the Locator for the password input and enter "test"
			 * 3. Locate the Locator for the login button and click it.
			 * 4. Pause for 1 sec to let the page load.
			 * 5. Locate the Locator to get the table body row data
			 * 6. Write the number of rows to the System.out console.
			 * 7. Locate the Locator to get the table header column data
			 * 8. Write the number of columns to the System.out console.	
			 * 9. Create a String with the text "US"	
			 * 10. Create a String placeholder to store our row data as we loop through the table rows.
			 * 11. Loop through rows
			 *	a. Get the text of the current row and store it in our string row data
			 *	b. Write the current Row Data to the System.out console.
			 *	c. Now check to see if the current row data contains the text in our String variable expected Text		
			 *		i. If true click on the cell. Pause for 1 sec to show click.
			 *		ii. Else go to the next row.	
			 */
			
			// Locate the Locator for the user name input and enter "Tester"
			WebElement userName = driver.findElement(By.id("ctl00_MainContent_username")); //.sendKeys("Tester");

			// Locate the Locator for the password input and enter "test"
			WebElement password = driver.findElement(By.id("ctl00_MainContent_password")); // .sendKeys("test");

			// Locate the Locator for the login button and click it.
			WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button")); //.click();
			
			Actions actions = new Actions(driver);
			actions.sendKeys(userName, "Tester")
				.sendKeys(password, "test")
				.click(login)
				.pause(1000)
				.build()
				.perform();
			
			// Locate the Locator to get the table body row data
			List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr"));

			// Write the number of rows to the System.out console.
			System.out.println("Number of rows =" + (rows.size() - 1));

			// Locate the Locator to get the table header column data
			List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[1]/th"));

			// Write the number of columns to the System.out console.
			System.out.println("Number of cols=" + cols.size());

			// Create a String with the text "US"
			String expectedValue = "US";

			// Create a String placeholder to store our row data as we loop through the
			// table rows.
			String rowData = "";

			// Loop through rows
			for (int i = 2; i <= rows.size(); i++) {

				// Get the text of the current row and store it in our string row data
				rowData = driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]"))
						.getText();

				// Write the current Row Data to the System.out console.
				System.out.println(rowData);

				// Now check to see if the current row data contains the text in our String
				// variable expected Text
				if (rowData.contains(expectedValue)) {

					// if it does click on the cell
					driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]/td[1]/input"))
							.click();

					// Pause to show click
					Thread.sleep(1000);
				}
			}

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	
	
}
