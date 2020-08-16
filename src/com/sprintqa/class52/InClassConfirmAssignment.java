package com.sprintqa.class52;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassConfirmAssignment {

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
			 * 1. Click the "Show Me Confirmation" button. 
			 * 2. Write the alert text to sysout 
			 * 3. Click "OK" 
			 * 4. Write the text that is displayed in "demo" 
			 *    WebElement when you click OK
			 */

			WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Show Me Confirmation']"));
			confirmButton.click();

			Thread.sleep(2000);
			TargetLocator targetLocator = driver.switchTo();

			Alert confirmPopup = targetLocator.alert();

			System.out.println(confirmPopup.getText());
			confirmPopup.accept();

			targetLocator.defaultContent();

			WebElement demoText = driver.findElement(By.id("demo"));
			System.out.println(demoText.getText());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
