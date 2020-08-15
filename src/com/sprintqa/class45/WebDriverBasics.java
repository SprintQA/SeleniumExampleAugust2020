package com.sprintqa.class45;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		// Set env property
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");
		// System.setProperty("webdriver.firefox.driver", "/path/to/gecko");
		// System.setProperty("webdriver.ie.driver", "/path/to/ie");

		// Assigning our WebDriver to Chrome binary
		WebDriver webDriver = new ChromeDriver();
		// WebDriver webDriver2 = new FirefoxDriver();

		// Open up the browser and redirect to the url
		webDriver.get("https://amazon.com/");

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.navigate().to("https://selenium.dev");

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Get current URL
		System.out.println(webDriver.getCurrentUrl());

		// Back
		webDriver.navigate().back();

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Forward
		webDriver.navigate().forward();

		// Title
		System.out.println(webDriver.getTitle());

		// Close the browser
		webDriver.close();

		// Quit, kill the application
		webDriver.quit();

	}

}
