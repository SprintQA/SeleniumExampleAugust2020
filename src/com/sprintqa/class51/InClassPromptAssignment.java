package com.sprintqa.class51;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassPromptAssignment {

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
			 * Goto: https://only-testing-blog.blogspot.com/2014/01/textbox.html 
			 * 1. Click the "Show Me Prompt" button. 
			 * 2. Write the alert text to sysout 
			 * 3. Send text to prompt 
			 * 4. Click "OK"
			 */

			// 1. Use switchTo() method returns a TargetLocator Class.
			WebElement promptButton = driver.findElement(By.xpath("//button[text()='Show Me Prompt']"));
			promptButton.click();
			Thread.sleep(2000);

			// 2. Use the TargetLocator alert() method to return a Alert Class.
			TargetLocator targetLocator = driver.switchTo();

			// 3. Use the Alert sendkeys() method to send text to the prompt and
			// click the accept button and close the pop-up
			Alert prompt = targetLocator.alert();
			System.out.println(prompt.getText());
			prompt.sendKeys("Mike");
			Thread.sleep(2000);
			prompt.accept();

			// 4. Return control to the main window
			targetLocator.defaultContent();

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
