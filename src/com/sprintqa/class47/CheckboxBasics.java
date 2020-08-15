package com.sprintqa.class47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxBasics {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		// Open the url and test the Single Checkbox Demo section of the webpage.
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		// Maximize the Chrome browser to fill the screen.
		driver.manage().window().maximize();

		/*
		 * 1. Find the By Locators for the: 
		 * 		- checkbox ("isAgeSelected") 
		 * 		- div ("txtAge")
		 */
	    /* 2. Lookup the WebElements using the findElement method
		 */
		WebElement ageCheckbox = driver.findElement(By.id("isAgeSelected"));
		WebElement ageText = driver.findElement(By.id("txtAge"));
		
		 /* 3. Validate that the text for the div ("txtAge") is "" 
		 * 	  when checkbox is not clicked. 
		 */
		if (! ageCheckbox.isSelected()
				&& ageText.getText().equals("")) {
			System.out.println("Pass: Checkbox is not selected");
		} else{
			System.out.println("Fail: Checkbox is selected");		
		}
		Thread.sleep(2000);
		
		 /* 4. Click checkbox 
		  */
		ageCheckbox.click();
		Thread.sleep(2000);
		
		/* 5. Validate that the text for the 
		 *    div ("txtAge") is "Success - Check box is checked" 
		 *    when checkbox is clicked.
		 */
		System.out.println(ageText.getText());
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();

	}
}
