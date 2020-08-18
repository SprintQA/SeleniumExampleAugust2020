package com.sprintqa.class51;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmBoxDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Switchto";
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(2000);

			// Using WebDriver to interact with the Confirm pop-up.
			//
			// A confirm box is similar to an alert, except the user can also choose
			// to cancel the message.
			//
			// 1. Use switchTo() method returns a TargetLocator Class.
			WebElement confirmButton = driver.findElement(By.id("confirm"));
			confirmButton.click();

			Thread.sleep(2000);
			TargetLocator targetLocator = driver.switchTo();

			// 2. Use the TargetLocator alert() method to return a Alert Class.
			Alert confirmPopup = targetLocator.alert();

			// 3. Use the Alert accept() method to click the confirmation
			System.out.println(confirmPopup.getText());

			confirmPopup.accept(); // OK button

			// confirmPopup.dismiss(); // Cancel button

			// button and close the pop-up
			// 4. Return control to the main window
			targetLocator.defaultContent();

			// 5. Verify the pop-up was clicked.
			// Use the WebDriver to search the web page using the "id" locator.
			// Using WebDriver to interact with the Confirm pop-up.

			WebElement demoText = driver.findElement(By.id("demo"));

			// Set String variables
			String expectedConfirmationText = "You pressed Ok in confirm window";
			String actualConfirmationText = demoText.getText();

			if (expectedConfirmationText.equals(actualConfirmationText)) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
