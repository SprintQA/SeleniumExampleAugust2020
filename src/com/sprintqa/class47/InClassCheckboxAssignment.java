package com.sprintqa.class47;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassCheckboxAssignment {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		// Open the url and test the Single Checkbox Demo section of the webpage.
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		// Maximize the Chrome browser to fill the screen.
		driver.manage().window().maximize();

		/*
		 * 1. Find the Locators for the: 
		 * 		- all the checkboxs in Multiple Checkbox Demo section
		 * 		- Button ("check1")
		 */ 
			By multipleCheckboxLocator = By.cssSelector("input.cb1-element");
			By checkButtonLocator = By.id("check1");
		
		/* 2. Lookup the WebElements using the findElement(s) method
		 */ 
			List<WebElement> multipleCheckbox = driver.findElements(multipleCheckboxLocator); 
			WebElement checkButton = driver.findElement(checkButtonLocator);
		
		/* 3. Loop through the checkboxes Multiple Checkbox Demo section and click each one.
		 */ 
//			multipleCheckbox.get(0);
//			multipleCheckbox.get(1);
//			multipleCheckbox.get(2);
			
			for (WebElement checkBox : multipleCheckbox) {
				checkBox.click();
				Thread.sleep(2000);
			}
		
		/* 4. Click the "Uncheck All" Button
		 */
			checkButton.click();
			Thread.sleep(2000);
			
		
		driver.close();
		driver.quit();

	}	
}
