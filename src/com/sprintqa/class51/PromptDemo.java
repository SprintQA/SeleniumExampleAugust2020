package com.sprintqa.class51;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptDemo {

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
			
			// Using WebDriver to interact with the Alert pop-up.
			//
			// Prompts are similar to confirm boxes, except they also include a text input.
			// Similar to working with form elements, you can use WebDriver’s send keys to
			// fill in a response. This will completely replace the placeholder text.
			// Pressing the cancel button will not submit any text.
			//
			// 1. Use switchTo() method returns a TargetLocator Class.
			WebElement promptButton = driver.findElement(By.id("prompt"));
			promptButton.click();
			Thread.sleep(2000);
			
			// 2. Use the TargetLocator alert() method to return a Alert Class.
			TargetLocator targetLocator = driver.switchTo();
			
			// 3. Use the Alert sendkeys() method to send text to the prompt and 
			//    click the accept button and close the pop-up
			Alert prompt = targetLocator.alert();
			System.out.println(prompt.getText());
			prompt.sendKeys("Mike");
			Thread.sleep(2000);
			prompt.accept();
			
			// 4. Return control to the main window
			targetLocator.defaultContent();
			
			// 5. Verify the pop-up was clicked.
			//    Use the WebDriver to search the web page using the "id" locator
			//    to locate the "demo" WebElement and confirm the text
			//	  "Hello Michael! How are you today?" is displayed.

			WebElement demoText = driver.findElement(By.id("demo"));
			
			// Set expected string value
			String expectedPromptText = "Hello Mike! How are you today?";
			String actualPromptText = demoText.getText();

			// validate displayed text
			if (expectedPromptText.equals(actualPromptText)) {
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
