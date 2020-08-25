package com.sprintqa.class57;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://www.aa.com/homePage.do";
			driver.get(url);
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 * Go to: https://www.aa.com/homePage.do
			 * 1. Take a screen shot of the AA home page
			 *    and save it to a file. 
			 * 
			 * 2. Create a takeScreenShot method for our Take Screenshot code.
			 */
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
	}

	public static void takeScreenShot(WebDriver driver, String fileName) {
		/*
		 * TakesScreenshot - is an interface that indicates a driver that can 
		 * capture a screenshot and store it in different ways.
		 * 
		 * To Capture a screen shot we must do the following: 
		 * 
		 * 1. Instantiate it by casting WebDriver to TakeScreenshot
		 * 
		 * 2. Since we will be dealing with files we need to 
		 *    create a try/catch to handle a possible IOException.
		 * 
		 * 3. Use the getScreenshotAs method to Capture the screenshot and 
		 *    store it in the specified location. In this case File.
		 * 
		 * 4. Use the class FileInputStream to opening a connection to an actual file.
		 * 
		 * 5. Create an output file setting the file directory to our project screenshots
		 *    folder.  
		 * 
		 * 6. Use the Java java.nio.file.Files Class to copy the inputStream to the file. 
		 * 
		 * 7. When your done make sure to close your input stream.  
		 */
		
		
	}
	
}
