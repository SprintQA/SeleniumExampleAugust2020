package com.sprintqa.class52;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class InClassKeyboardActionsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			// NOTE: there is a bug with MAC OSX and the Chrome Driver with Command not working
			// So, for this example we will be using Firefox instead.
			
			System.setProperty("webdriver.gecko.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/geckodriver");

			driver = new FirefoxDriver();

			String url = "https://omayo.blogspot.com/";
			driver.get(url);
			driver.manage().window().maximize();
			
			/*
			 * Using Keyboard Actions to Copy and Paste 
			 * 1. Copy the text from Text Area Field Two. 
			 * 2. Past the text into Text Area Field 
			 */

			// Find web elements
			WebElement textArea1 = driver.findElement(By.id("ta1"));
			WebElement textArea2 = driver.findElement(By.xpath("//textarea[starts-with(text(),'The')]"));
			
			//List<WebElement> textAreaFields = driver.findElements(By.tagName("textarea"));
			//textArea1 = textAreaFields.get(0);
			//textArea2 = textAreaFields.get(1);
			
			// Instantiate Actions class
			Actions actions = new Actions(driver);

			// Copy the text from Text Area Field Two
			actions.keyDown(textArea2, Keys.COMMAND ).sendKeys( "a" ).keyUp( Keys.COMMAND ).build().perform();
			actions.keyDown( Keys.COMMAND ).sendKeys( "c" ).keyUp( Keys.COMMAND ).build().perform();
			 
			Thread.sleep(2000);

			// Paste the copied text into Text Area Field
			actions.click(textArea1).keyDown( Keys.COMMAND ).sendKeys( "v" ).keyUp( Keys.COMMAND ).build().perform();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			try {
				driver.quit();
			}catch(Exception e) {
				
			}
		}

	}
	
}
