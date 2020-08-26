package com.sprintqa.class57;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadFileDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			// Create a HashMap to store additional browser settings
			// Disable the save to folder popup
			// Change the default download directory
			// Declare ChromeOptions to enable browser settings
			// set Experimental Option "prefs" with your HashMap values.
			// Declare your webDriver class variable to a ChromeDriver WebDriver to
			// communicate with Chrome. Pass in Chrome Options.
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);

			driver = new ChromeDriver(options);
			
			String url = "https://www.thinkbroadband.com/download";
			driver.get(url);
			driver.manage().window().fullscreen();

			/*
			 *  Go to: https://www.thinkbroadband.com/download
			 *  1. Locate the download links
			 *  2. Click the last one to download 5MB file :)			
			 *  3. Set Explicit wait time to 25s
			 *  4. Wait until the extraSmallFileImgLink is visible and click it.
			 *  5. Click extra small file link
			 *  6. When we clicked the extraSmallFileImgLink a file
			 *     5MB.zip should be down loaded to the specified output folder.
			 *  7. Create a File object with user path and expected file name.
			 *  8. Wait for the file to download:
			 *  	- Set wait time 30s
			 *  	- Check until condition every second
			 *  9. Use Java lambda to wait until file.exists
			 *     or we reach out timeout limit.
			 * 10. if file is not present – fail test
			 * 	   else, delete file to be sure that next time new file will be downloaded
			*/
			
			By paragraphLinkImagesLocator = By.xpath("//div[@class='module']//p//a//img");
			List<WebElement> list = driver.findElements(paragraphLinkImagesLocator);
			
			/* 
			 * Since the 5MB.zip is the last image we can get it by grabbing the last
			 * WebElement in the collection. 
			 */
			int totalNumberOfWebElementsFound = list.size();
			WebElement extraSmallFileImgLink = list.get(totalNumberOfWebElementsFound - 1);

			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(extraSmallFileImgLink));
			extraSmallFileImgLink.click();

			String fileName = "5MB.zip";
			downloadFile(driver, fileName);

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
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1));

		/*
		 * "A lambda (->) expression" is a short block of code which takes 
		 *	in parameters and returns a value. Lambda expressions are 
		 *  similar to methods, but they do not need a name and they 
		 *  can be implemented right in the body of a method.
		 */     
		fluentWait.until(fileExists -> targetFile.exists());

		if (!targetFile.exists()) {
			System.out.println("File is not present");
		} else {
			// delete file to be sure that next time new file will be downloaded
			//targetFile.delete();
		}
	}
	
}
