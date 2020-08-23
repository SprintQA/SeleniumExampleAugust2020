package com.sprintqa.class56;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitsDemo {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();
			//Implicit
			// Sets the wait time for all the elements on the page
			// Good the whole test / session
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			String url = "https://cnn.com";
			
			// Sets the amount of time to wait for a page load to complete before throwing an error. 
			// If the timeout is negative, page loads can be indefinite.
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();

			/*
			 * Go to: https://cnn.com
			 * 1. Set the web driver's implicit wait timeout to 30s
			 * 2. Set the amount of time to wait for a page load to complete before throwing
			 *    an error.
			 * 3. Find and click on the World Link
			 * 4. Get the World Header tag
			 * 5. Verify that the world header is displayed.
			 */ 

			WebElement worldLink = driver.findElement(By.xpath("//a[@name='world']"));
			worldLink.click();
			
			WebElement worldTitle = driver.findElement(By.xpath("//h1[text()='World']"));
			
			if(worldTitle.isDisplayed()) {
				System.out.println("Passed");
			}else {
				System.out.println("Failed");
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
