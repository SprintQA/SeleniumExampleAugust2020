package com.sprintqa.class48;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkBasics {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get( "https://www.seleniumeasy.com/");
		driver.manage().window().maximize();

		/* 
		 * 1. Goto Url https://www.seleniumeasy.com/
		 * 2. Write the current page url and title to console.
		 * 3. Click the Selenium Tutorial link at the bottom of the page.
		 * 4. Write the current page url and title to console.
		 * 5. Click the Selenium Easy icon at the top left corner of the page.
		 * 6. Write the current page url and title to console.
		 */
		By linksLocator = By.xpath("//a[@title='selenium tutorials']");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> links = driver.findElements(linksLocator);
		Thread.sleep(4000);
		links.get(1).click();
		Thread.sleep(4000);

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	
		By homeLocator = By.xpath("//a[@title='Home']");
		List<WebElement> home = driver.findElements(homeLocator);
		home.get(0).click();
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}

}
