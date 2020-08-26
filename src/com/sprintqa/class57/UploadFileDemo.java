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
			 */
			/*
			 * System.getProperty("user.dir") 
			 * Gets the directory where java was run from, where you started the JVM.
			 */
			System.out.println(System.getProperty("user.dir"));
			String targetFile = System.getProperty("user.dir") + "/files/placeholder.txt";

			 /* 2. Find the button "Choose File" and click it.
			 */
			// Locate out locators
			By fileUploadLinkLocator = By.linkText("File Upload");
			By fileUploadInputLocator = By.id("file-upload");
			By fileSubmitButtonLocator = By.id("file-submit");
			By exampleDivLocator = By.cssSelector("div.example");
					
			// Get our WebElements
			WebElement fileUploadLink = driver.findElement(fileUploadLinkLocator);
			fileUploadLink.click();
			Thread.sleep(2000);
			
			 /* 3. Send the targetFile name and path information to the
			 *    input id="file-upload"
			 */
			WebElement fileUploadInput = driver.findElement(fileUploadInputLocator);
			WebElement fileSubmitButton = driver.findElement(fileSubmitButtonLocator);
			fileUploadInput.sendKeys(targetFile);
			Thread.sleep(2000);
			 /* 
			  * 4. Click the Upload button to upload out file
			  */
			fileSubmitButton.click();

			/* 
			 * 5. Look for div.example Element window
			 * 6. Define our Explicit wait timeout.
			 * 7. ExplitWait for fileUploadedWindow to be visible.
			 */
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(exampleDivLocator));

			 /* 
			 * 8. Pass if fileUploadedWindow is displayed, else fail.
			 */
			WebElement fileUploadedWindow = driver.findElement(exampleDivLocator);
			if (fileUploadedWindow.isDisplayed()) {
				System.out.println("File is uploaded");
			} else {
				System.out.println("File is not uploaded");
			}
			
			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
	}
	
}
