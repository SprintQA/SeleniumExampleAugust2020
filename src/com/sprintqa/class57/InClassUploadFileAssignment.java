package com.sprintqa.class57;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InClassUploadFileAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			String userDir = System.getProperty("user.dir");
			
			// Configure Chrome
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", userDir);
			
			System.out.println(userDir);
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			
			driver = new ChromeDriver(options);
	
			String url = "http://uitestpractice.com/Students/Widgets";
			driver.get(url);
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 * Go to: http://uitestpractice.com/Students/Widgets
			 * 1. Click the "download a image" button 
			 * 
			 * 2. Verify the file is downloaded
			 * 
			 * 3. Find upload file button
			 * 
			 * 4. Send downloaded file path
			 * 
			 * 5. Click upload file
			 * 
			 * 6. Set explicit wait 30 sec
			 * 
			 * 7. Wait until contact us is loaded
			 * 
			 * 8. Locate file uploaded window
			 * 
			 * 9. Verify file upload window is displayed
			 */

			
			String targetFile = "images.png";
			
			WebElement downloadLink = driver.findElement(By.linkText("Download a image"));
			downloadLink.click();
			downloadFile(driver, targetFile);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			targetFile = userDir + "/files/placeholder.txt";
			
			WebElement chooseFileButton = driver.findElement(By.id("image_file"));
			chooseFileButton.sendKeys(targetFile);

			WebElement uploadForm = driver.findElement(By.xpath("//input[@value='Upload']"));
			uploadForm.click();

			By contactUsDivLocator = By.cssSelector("div.ContactUs");

			wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsDivLocator));
			WebElement fileUploadedWindow = driver.findElement(contactUsDivLocator);

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
	
	public static void downloadFile(WebDriver driver, String fileName) {
		File targetFile = new File(fileName);
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofSeconds(1))
				.withTimeout(Duration.ofSeconds(30));
		
		/*
		 * "A lambda (->) expression" is a short block of code which takes 
		 *	in parameters and returns a value. Lambda expressions are 
		 *  similar to methods, but they do not need a name and they 
		 *  can be implemented right in the body of a method.
		 */     
		fluentWait.until(fileExists -> targetFile.exists());
		
		if (!targetFile.exists()) {
			System.out.println("File is not present");
		}else {
			System.out.println("File is downloaded");
			// delete file to be sure that next time new file will be downloaded
			targetFile.delete();
		}
		
	}
	
}
