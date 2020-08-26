package com.sprintqa.class57;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassScreenShotAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			driver.get(url);
			driver.manage().window().fullscreen();

			/*
			 * Go to: https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers
			 * 1. Take a screen shot of the login page before you enter any data
			 * 2. Populate Username and Password
			 * 3. Take a screen shot of the login page after you enter data
			 * 4. Click the login button
			 * 5. Take a screen shot of the OrangeHRM dash board.
			 */
			
			takeScreenShot(driver, "screenshots/orangehrmlive_Login_page.png");
			
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");

			takeScreenShot(driver, "screenshots/orangehrmlive_PopulatedLogin_page.png");
			driver.findElement(By.id("frmLogin")).click();;

			takeScreenShot(driver, "screenshots/orangehrmlive_Main_page.png");
			Thread.sleep(3000);

			
			Thread.sleep(3000);
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
		 * 1. Instantiate it by casting WebDriver to TakeScreenshot
		 * 2. Since we will be dealing with files we need to 
		 *    create a try/catch to handle a possible IOException.
		 * 3. Use the getScreenshotAs method to Capture the screenshot and 
		 *    store it in the specified location. In this case File.
		 * 4. Use the class FileInputStream to opening a connection to an actual file.
		 * 5. Create an output file setting the file directory to our project screenshots
		 *    folder.  
		 * 6. Use the Java java.nio.file.Files Class to copy the inputStream to the file. 
		 * 7. When your done make sure to close your input stream.  
		 */
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		try {
			File screenShot = ts.getScreenshotAs(OutputType.FILE);

			InputStream inputStream = new FileInputStream(screenShot);

			File outputFile = new File(fileName);

			Files.copy(inputStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screenshot");
		}
	}

}
