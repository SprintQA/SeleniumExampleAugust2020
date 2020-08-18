package com.sprintqa.class52;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseClickActionsDemo {
	
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Actions";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Example 1a: Using the Action class click() method.
			 * 1. Click the "Click Me!" button.
			 */
			
			
			
			/* Example 1b. Build a complex set of action commands to:
			 * 1. Loop through the numbered Elements 
			 * 2. Click the current number
			 * 3. Pause 1 second between clicks
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	

}
