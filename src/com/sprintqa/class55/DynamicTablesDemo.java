package com.sprintqa.class55;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
			 * 1. Using the Actions class log into OrangHRM - Locate the Username, Password,
			 * Login button - Pause 1 sec after clicking login to give the browser time to
			 * load the new page 2. Click the "User Management" option on the menu under
			 * Admin 3. Read the Dynamic table - Write the number of cols and rows 4. Create
			 * a String with the text "ESS" 5. Create a String placeholder to store our row
			 * data as we loop through the table rows. 6. Loop through rows - Get the text
			 * of the current row and store it in our string row data - Write the current
			 * Row Data to the System.out console. - Now check to see if the current row
			 * data contains the text in our String variable expected Text i. If true click
			 * on the cell. Pause for 1 sec to show click. ii. Else go to the next row.
			 */
			Actions actions = new Actions(driver);

			WebElement txtUsername = driver.findElement(By.id("txtUsername"));
			WebElement txtPassword = driver.findElement(By.id("txtPassword"));
			WebElement btnLogin = driver.findElement(By.id("btnLogin"));

			actions.sendKeys(txtUsername, "Admin").sendKeys(txtPassword, "admin123").click(btnLogin).pause(1000).build()
					.perform();

			WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
			actions.click(adminMenu).pause(1000).build().perform();

			List<WebElement> cols = driver.findElements(By.xpath("//table[@id='resultTable']//thead//tr//th"));
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr"));

			System.out.println("Number of cols: " + cols.size());
			System.out.println("Number of rows: " + rows.size());

			String expectedValue = "ESS";
			String placeholder = "";

			for (WebElement row : rows) {

				
				
				//				System.out.println(row.getText());
//				if (row.getText().contains(expectedValue)) {
//					row.findElement(By.xpath("//td//input")).click();
//					Thread.sleep(1000);
//				}
			}
			
//			String rowLocatorString = "//table[@id='resultTable']//tbody//tr";
//
//			for (int x = 1; x <= rows.size(); x++) {
//				placeholder = driver.findElement(By.xpath(rowLocatorString+"[" + x + "]")).getText();
//				System.out.println(placeholder);
//				if (placeholder.contains(expectedValue)) {
//					driver.findElement(By.xpath(rowLocatorString + "[" + x + "]//td//input")).click();
//					Thread.sleep(1000);
//				}
//			}

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
