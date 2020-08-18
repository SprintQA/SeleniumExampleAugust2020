package com.sprintqa.class51;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			String url = "http://uitestpractice.com/Students/Switchto";
			
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();

			// Using WebDriver to interact with a frame.
			//
			// Iframes allow the insertion of a document from an entirely different domain,
			// and are still commonly used.
			//
			WebElement iframe = driver.findElement(By.name("iframe_a"));
									
			// 1. Use switchTo() method returns a TargetLocator Class.
			// 2. Use the TargetLocator frame() method to switch to the frame window.
			driver.switchTo().frame(iframe);
			
			// 3. Locate the name Element inside the frame
			WebElement nameField = driver.findElement(By.id("name"));
			
			// 4. populate input with your name
			nameField.sendKeys("Mike");
			
			// 5. Switch back to main window
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			// 6. Verify you are back in main window by clicking alert button
			WebElement alertButton = driver.findElement(By.id("alert"));
			alertButton.click();
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
