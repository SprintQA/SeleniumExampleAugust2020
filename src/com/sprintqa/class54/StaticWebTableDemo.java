package com.sprintqa.class54;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://www.seleniumeasy.com/test/table-pagination-demo.html";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to:https://www.seleniumeasy.com/test/table-pagination-demo.html
			 * 1. Locate the WebElements for Static Web Table
			 * 2. Locate the Locator you need to use to find the table headers.
			 * 3. Write out the number of columns using the Collector size() method.
			 * 4. Loop through the TH tags in Row 1
			 * 5. Write out the number of table rows
			 * 6. Loop through Collection of rows and write out the row text
			 */
			
			//1.
			WebElement table = driver.findElement(By.xpath("//table"));
			//2.
			List<WebElement> tableHeaders = driver.findElements(By.xpath("//table//thead//tr//th"));
			//3.
			// Console line spacer to make it easier to read output
			System.out.println("=======================");
			System.out.println("Printing column headers");
			System.out.println("=======================");
			System.out.println("Number of Columns: "+tableHeaders.size());
			//4.
			for(WebElement header:tableHeaders) {
				System.out.println(header.getText());
			}
			//5.
			System.out.println("=======================");
			System.out.println("Printing Row Data");
			System.out.println("=======================");
			List<WebElement> tableRows = driver.findElements(By.xpath("//table//tbody//tr"));
			System.out.println("Number of Rows: "+tableRows.size());
			//6.
			for(WebElement rows:tableRows) {
				System.out.println(rows.getText());
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
