package com.sprintqa.class51;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Switchto";
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(1000);

			// Using WebDriver to interact with the Alert pop-up.
			//
			// The simplest of these is referred to as an alert, which shows a custom
			// message, and a single button which dismisses the alert, labeled in most
			// browsers as OK. It can also be dismissed in most browsers by pressing the
			// close button, but this will always do the same thing as the OK button.
			//
			// 1. Use switchTo() method returns a TargetLocator Class.
			WebElement alertButton = driver.findElement(By.id("alert"));
			WebElement demoText = driver.findElement(By.id("demo"));
			System.out.println(demoText.isDisplayed());

			Thread.sleep(2000);

			alertButton.click();

			TargetLocator targetLocator = driver.switchTo();

			// 2. Use the TargetLocator alert() method to return a Alert Class.
			Alert alert = targetLocator.alert();

			// 3. Use the Alert accept() method to click the confirmation
			// button and close the pop-up
			System.out.println(alert.getText());

			Thread.sleep(2000);
			alert.accept();

			Thread.sleep(2000);
			// alert.dismiss(); -- this will also close the alert

			// 4. Return control to the main window
			targetLocator.defaultContent();
			// driver.switchTo().defaultContent();

			// 5. Verify the pop-up was clicked.
			// Use the WebDriver to search the web page using the "id" locator.
			// Using WebDriver to interact with the Alert pop-up.
			demoText = driver.findElement(By.id("demo"));

			// This is the text that should be displayed in the Div "demo" if the action is
			// successful.
			String expectedDisplayedActionText = "You have clicked on ok button in alert window";

			// Store the actual text being displayed in Div "demo"
			String actualDisplayedActionText = demoText.getText();

			// Validate text is displayed
			if (expectedDisplayedActionText.equals(actualDisplayedActionText)) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
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
