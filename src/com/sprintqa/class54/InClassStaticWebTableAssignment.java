package com.sprintqa.class54;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			
			// Use the browser to Locate the Locator you need to use to find the table
			// headers.
			List<WebElement> cols = driver.findElements(By.xpath("//*[@id='table1']/thead/tr/th"));

			// Write out the number of columns using the Collector size() method.
			System.out.println("Number of columns is=" + cols.size()); //6

			// Console line spacer to make it easier to read output
			System.out.println("=======================");
			System.out.println("Printing column headers");
			System.out.println("=======================");

			// Loop through the TH tags in Row 1
			for (WebElement col : cols) {
				// Write out the th cell data to the console.
				System.out.println(col.getText());
			}

			// getting number of rows
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));

			// Console line spacer to make it easier to read output
			System.out.println("=======================");
			System.out.println("Number of Rows is=" + rows.size());
			System.out.println("=======================");

			// Console text identifier for data about
			System.out.println("---Printing row data---");
			System.out.println("=======================");

			for (WebElement element: rows) {
				System.out.println(element.getText());
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
