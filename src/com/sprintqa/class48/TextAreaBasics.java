package com.sprintqa.class48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextAreaBasics {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		//1
		driver.get( "https://www.seleniumeasy.com/test/input-form-demo.html");
		driver.manage().window().maximize();

		/* 
		 * 1. Goto Url https://www.seleniumeasy.com/test/input-form-demo.html
		 * 2. Locate the "Project Description" text area.
		 * 3. Populate the text area with a couple lines of text.
		 * 4. Validate the text entered into the text area.
		 */
		
		//2
		By textAreaLocator = By.cssSelector("textarea.form-control");
		WebElement textArea = driver.findElement(textAreaLocator);
		
		//3
		String text = "Hello World!\nMy name is Mike"; // \n = new line
		textArea.sendKeys(text);
		
		//4
		if(textArea.getAttribute("value").equals(text)) {
			System.out.println("Pass");
		}else
			System.out.println("Fail");

		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}

	
}
