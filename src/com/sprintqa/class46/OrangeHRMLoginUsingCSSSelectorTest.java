package com.sprintqa.class46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginUsingCSSSelectorTest {

	public static void main(String[] args) throws InterruptedException {

		// Set env property
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");
		// System.setProperty("webdriver.firefox.driver", "/path/to/gecko");
		// System.setProperty("webdriver.ie.driver", "/path/to/ie");

		// Assigning our WebDriver to Chrome binary
		WebDriver webDriver = new ChromeDriver();
		// WebDriver webDriver2 = new FirefoxDriver();

		// Open up the browser and redirect to the url
		webDriver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		WebElement userNameInput2 = webDriver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement userNameInput = webDriver.findElement(By.cssSelector("input#txtUsername"));
		WebElement passwordInput = webDriver.findElement(By.cssSelector("input#txtPassword"));

		userNameInput.sendKeys("admin123");

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Clear WebElement
		userNameInput.clear();

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		userNameInput.sendKeys("Admin");

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		passwordInput.sendKeys("admin123");

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement loginButton = webDriver.findElement(By.cssSelector("form#frmLogin"));
		loginButton.click();
		
			Thread.sleep(2000);

		
		// Close the browser
		webDriver.close();

		// Quit, kill the application
		webDriver.quit();

	}

}
