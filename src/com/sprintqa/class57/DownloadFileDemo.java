package com.sprintqa.class57;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

			driver = new ChromeDriver();

			String url = "https://www.thinkbroadband.com/download";
			driver.get(url);
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 *  Go to: https://www.thinkbroadband.com/download
			 *  1. Locate the download links
			 *  
			 *  2. Click the last one to download 5MB file :)			
			 *  
			 *  3. Set Explicit wait time to 25s
			 *  
			 *  4. Wait until the extraSmallFileImgLink is visible and click it.
			 *  
			 *  5. Click extra small file link
			 *  
			 *  6. When we clicked the extraSmallFileImgLink a file
			 *     5MB.zip should be down loaded to the specified output folder.
			 *  
			 *  7. Create a File object with user path and expected file name.
			 *  
			 *  8. Wait for the file to download:
			 *  	- Set wait time 30s
			 *  	- Check until condition every second
			 *  
			 *  9. Use Java lambda to wait until file.exists
			 *     or we reach out timeout limit.
			 *     
			 * 10. if file is not present – fail test
			 * 	   else, delete file to be sure that next time new file will be downloaded
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
