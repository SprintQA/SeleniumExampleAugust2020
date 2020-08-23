package com.sprintqa.class56;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitsDemo {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com";
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 * Go to: http://uitestpractice.com
			 * 1. Locate the Locator for the link "AjaxCall" and click it
			 * 2. Locate the Locator for the link "This is a Ajax link" and click it
			 * 3. Preparing the fluent wait to:
			 * 		- set timeout for 30s
			 * 		- poll every 5 sec (recheck the condition)
			 * 		- ignore NoSuchElementException
			 * 4. Wait for the presence Of the "ContactUs" Div Element to be Located.
			 * 5. Wait for the Element "ContactUs" Div Element to be visible
			 * 6. Wait until we find the Element "ContactUs" Div Element and return it.
			 * 		- If the element is not found before the timeout is reached the inner
			 * 		  function will return a null WebElement;
			 * 7. Check that contact us is displayed and write out it text to the console
			 */

			By ajaxCallMenuLinkLocator = By.linkText("AjaxCall");
			By ajaxLinkLocator = By.linkText("This is a Ajax link");					
			By contactUsLocator = By.xpath("//div[@class='ContactUs']");
			
			driver.findElement(ajaxCallMenuLinkLocator).click();
			driver.findElement(ajaxLinkLocator).click();

			/*
			 * FluentWait instance defines the maximum amount 
			 * of time to wait for a condition, as well as the 
			 * frequency with which to check the condition.
			 * 
			 * Users may configure the wait to ignore specific 
			 * types of exceptions whilst waiting, such as 
			 * NoSuchElementException when searching for an 
			 * element on the page.
			 */
			
			//Explicit
			//WebDriverWait waits = new WebDriverWait(driver, 30);
			//waits.until()
			
			// Preparing the explicit wait (FluentWait).
			Wait<WebDriver> wait = 
					new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(60))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);
						
			// Wait for the presence Of the "ContactUs" Div Element to be Located.
			wait
				.until(
						ExpectedConditions.presenceOfElementLocated(contactUsLocator));
					
			// Wait for the Element "ContactUs" Div Element to be visible
			wait
				.until(
						ExpectedConditions.visibilityOfElementLocated(contactUsLocator));

			
			WebElement contactUs = driver.findElement(contactUsLocator);
			String elText = contactUs.getText();
			System.out.println(elText);

			
			
			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
