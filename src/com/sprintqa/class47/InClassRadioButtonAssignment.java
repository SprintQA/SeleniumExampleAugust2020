package com.sprintqa.class47;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassRadioButtonAssignment {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		// Open the url and test the Single Checkbox Demo section of the webpage.
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

		// Maximize the Chrome browser to fill the screen.
		driver.manage().window().maximize();

		/*
		 * 1. Find the Locators for the: 
		 * 		- All the RadioButtons for Sex
		 * 		- All the radio buttons for age groups
		 * 		- Button ("Get Values")
		 *  
		 * 2. Lookup the WebElements using the findElement(s) method
		 * 
		 * 3. Loop through the Radio Buttons for Sex and Click the one that applies to you.
		 * 
		 * 4. Loop through the Radio Buttons for Age Groups and Click the one that applies to you.
		 *
		 * 5. Click the Values Button
		 * 
		 * 6. Write the displayed values to the console using sysout
		 */
		
		//1 & 2
		// Look up page elements using WebDriver findElement() method.
		List<WebElement> optRadioButtons = driver.findElements(By.xpath("//input[@name='gender']"));
		List<WebElement> ageGroupRadioButtons = driver.findElements(By.xpath("//input[@name='ageGroup']"));
		WebElement getValuesButton = driver.findElement(By.xpath("//button[text()='Get values']"));
		WebElement valuesText = driver.findElement(By.cssSelector("p.groupradiobutton"));
		
		//3
		for(WebElement optRadio:optRadioButtons) {
			if(optRadio.getAttribute("value").equals("Male"))
				optRadio.click();
		}
		Thread.sleep(2000);
		
		//4
		for(WebElement ageGroup:ageGroupRadioButtons) {
			if(ageGroup.getAttribute("value").equals("15 - 50"))
					ageGroup.click();
		}
		Thread.sleep(2000);
		
		//5
		getValuesButton.click();
		Thread.sleep(2000);
		
		//6
		System.out.println(valuesText.getText());
		
		
		driver.close();
		driver.quit();

	}	
}
