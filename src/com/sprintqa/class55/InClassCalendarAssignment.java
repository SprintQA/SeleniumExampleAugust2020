package com.sprintqa.class55;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassCalendarAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://jqueryui.com/datepicker/";
			driver.get(url);
			driver.manage().window().maximize();

			/* Go to: http://jqueryui.com/datepicker/
			 * 1. Locate the Locator for iFrame that Date input field resides
			 * 2. Switch to the iFrame
			 * 3. Locate the Date input field and click it 
			 * 4. Locate the Locator to get all calendar dates inside the ui-datepicker-calendar table
			 * 5. Loop through the columns of table data
			 * 6. Get the column displayed text and store it in a Sting variable
			 * 7. Write the displayed text to the System.out console.
			 * 8. If the column text equals 22 click the cell where the class equals ui-state-highlight. 
			 * 9. click todays date.
			 */
			
			// Locate the Locator for iFrame that Date input field resides
			WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));
												  //By.xpath("//iframe[@class='demo-frame']")

			// Switch to the iFrame
			driver.switchTo().frame(frame);

			// Locate the Date input field and click it
			driver.findElement(By.id("datepicker")).click();

			// Wait for page to refresh
			Thread.sleep(1000);

			// Locate the Locator to get all calendar dates inside the
			// ui-datepicker-calendar table
			List<WebElement> dates = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

			String text = "";
			// Loop through the columns of table data
			for (WebElement day : dates) {

				// Get the column displayed text and store it in a Sting variable
				text = day.getText();

				// Write the displayed text to the System.out console.
				System.out.println(text);

				// If the column text equals 30 click the cell.
				if (text.equals("22")) {
					day.click();
					break;
				}
				
			}
			
			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	
}
