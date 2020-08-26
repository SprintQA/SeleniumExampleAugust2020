package com.sprintqa.class57;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassJavaScriptExecutorAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://www.aa.com/homePage.do";
			driver.get(url);
			driver.manage().window().fullscreen();

			/*
			 * Go to: https://www.aa.com/homePage.do
			 * 1. Load JSExecutor class so we can execute JS
			 * 2. Use JS to scroll down 1000 bytes
			 * 3. Look for Trip insurance link and click it
			 */
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");

			Thread.sleep(2000);

			driver.findElement(By.linkText("Trip insurance")).click();
			
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
	}

}
