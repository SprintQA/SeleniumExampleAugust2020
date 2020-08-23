package com.sprintqa.class56;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnotherTableDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Index";
			driver.get(url);
			driver.manage().window().fullscreen();

			By tableHeaderLocator = By.xpath("//table[@class='table']//tbody//tr[1]//th");
			List<WebElement> headers = driver.findElements(tableHeaderLocator);
			
			String tableRowXpath = "//table[@class='table']//tbody//tr";
			By tableRowLocator = By.xpath(tableRowXpath);
			List<WebElement> rows = driver.findElements(tableRowLocator);
			
			//table[@class='table']//tbody//tr[2]//td
			
			System.out.println("Number of Table Columns is: " + headers.size());
			System.out.println("Number of Table Rows is: " + (rows.size()-1));

			List<WebElement> rowCells;
			for (int x = 2; x <= rows.size(); x++) {
				
				rowCells = driver.findElements(By.xpath(tableRowXpath+"["+x+"]//td"));
				System.out.println(x + " Row Data");
				for(WebElement cells:rowCells) {
					System.out.println(cells.getText());
				}
			}

// Example 1			
//			for(WebElement header:headers) {
//				System.out.println(header.getText());
//			}

				Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
