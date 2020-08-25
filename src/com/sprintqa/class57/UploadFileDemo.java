package com.sprintqa.class57;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFileDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://the-internet.herokuapp.com";
			driver.get(url);
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 * Go to: http://the-internet.herokuapp.com
			 * 1. Create a String object and set its value to be the
			 *    Users current system path plus the file to upload
			 * 
			 * 2. Find the button "Choose File" and click it.
			 * 
			 * 3. Send the targetFile name and path information to the
			 *    input id="file-upload"
			 * 
			 * 4. Click the Upload button to upload out file
			 * 
			 * 5. Look for div.example Element window
			 * 
			 * 6. Define our Explicit wait timeout.
			 * 
			 * 7. ExplitWait for fileUploadedWindow to be visible.
			 * 
			 * 8. Pass if fileUploadedWindow is displayed, else fail.
			 */

			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
	}
	
}
