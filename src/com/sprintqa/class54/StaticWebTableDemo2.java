package com.sprintqa.class54;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableDemo2 {

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
			 * Go to: https://www.seleniumeasy.com/test/table-pagination-demo.html 
			 * 1. Locate the WebElements for Static Web Table 
			 * 2. Locate the Locator you need to use to find the table headers. 
			 * 		- You must use Xpath Axes: child and descendant 
			 * 3. Write out the number of columns using the Collector size() method. 
			 * 4. Loop through the TH tags in Row 1 
			 * 5. Write out the number of table rows 
			 * 6. Loop through Collection of rows and write out the row text 
			 * 7. Click the >> link to go to the next table 
			 * REPEAT STEPS 1-7
			 */
			
			By tableHeaderLocator = By.xpath("//table//child::thead//child::tr//descendant::th");
			By tableRowLocator = By.xpath("//table//child::tbody//descendant::tr[@style='display: table-row;']");
			By pageLinkLocator = By.cssSelector("a.page_link");
			
			List<WebElement> tableHeaders;
			List<WebElement> tableRows;
			
			List<WebElement> pageLinks = driver.findElements(pageLinkLocator);
			for(WebElement pageLink:pageLinks) {
				pageLink.click();
				
				tableHeaders = driver.findElements(tableHeaderLocator);
				getTableHeaders(tableHeaders);			
				
				tableRows = driver.findElements(tableRowLocator);
				getTableRowText(tableRows);
				
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}
	
	public static void getTableHeaders(List<WebElement> cols) {
		System.out.println("=======================");
		System.out.println("Number of columns is=" + cols.size());
		System.out.println("=======================");
		System.out.println("Printing column headers");
		System.out.println("=======================");
		for (WebElement col : cols) {
			System.out.println(col.getText());
		}
	}
	
	public static void getTableRowText(List<WebElement> rows) {
		System.out.println("=======================");
		System.out.println("Number of rows is=" + rows.size());
		System.out.println("=======================");
		System.out.println("  Printing row data    ");
		System.out.println("=======================");
		for (WebElement element : rows) {
			System.out.println(element.getText());
		}
	}

	
}
