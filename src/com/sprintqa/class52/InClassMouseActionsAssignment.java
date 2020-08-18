package com.sprintqa.class52;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassMouseActionsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/";

			// Open up your Chrome browser to the starting web page.
			driver.get(url);

			// Maximize the Chrome browser to fill the screen.
			driver.manage().window().maximize();

			/*
			 * Perform the following Actions on: http://uitestpractice.com/
			 * 1. Drag the “Drag me to my target” box to the “Drop here” box”. 
			 * 2. Double click the “Double Click ME!” Button.
			 * 3. Get text from alert box and write it to the console.
			 * 4. Click OK on alert box. 
			 * 5. Move to the “Toggle icons” button, pause 2 sec, click it, pause 3 sec.
			 */
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
