package com.sprintqa.class52;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassAlertAssignment {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://only-testing-blog.blogspot.com/2014/01/textbox.html";
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			/*
			 * Goto: https://only-testing-blog.blogspot.com/2014/01/textbox.html.
			 * Click the "Show Me Alert" button. 
			 * Write the alert text to sysout.
			 */

			WebElement alertButton = driver.findElement(By.xpath("//input[@value='Show Me Alert']"));
			alertButton.click();

			// 1. Use switchTo() method returns a TargetLocator Class.
			TargetLocator targetLocator = driver.switchTo();

			// 2. Use the TargetLocator alert() method to return a Alert Class.
			Alert alert = targetLocator.alert();

			// 3. Use the Alert accept() method to click the confirmation
			// button and close the pop-up
			System.out.println(alert.getText());
			Thread.sleep(2000);

			alert.accept();
			Thread.sleep(2000);

			// 4. Return control to the main window
			targetLocator.defaultContent();
			// driver.switchTo().defaultContent();

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
