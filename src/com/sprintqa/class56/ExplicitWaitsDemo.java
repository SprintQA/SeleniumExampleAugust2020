package com.sprintqa.class56;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitsDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Contact";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to http://uitestpractice.com.
			 * 1. Preparing the explicit wait.
			 * 2. Wait until a WebElement is available and clickable
			 * 3. Locate the Locator for the link "AjaxCall" and click it
			 * 4. Locate the Locator for the link "This is a Ajax link" and click it
			 * 5. Wait for the presence Of the "ContactUs" Div Element to be Located.
			 * 6. Wait for the Element "ContactUs" Div Element to be visible
			 * 7. Get the "ContactUs" div text and write it to the System.out console.
			 */
			
			// Defines the wait time
			WebDriverWait waits = new WebDriverWait(driver, 5);

			waits
				.until(
						ExpectedConditions
							.elementToBeClickable(By.linkText("This is a Ajax link")));
			
			WebElement ajaxLink = driver.findElement(By.linkText("This is a Ajax link"));
			ajaxLink.click();
			
			By contactUsLocator = By.xpath("//div[@class='ContactUs']");
			
			waits
				.until(
						ExpectedConditions
							.presenceOfElementLocated(
									contactUsLocator));
			
			waits
				.until(
					ExpectedConditions
						.visibilityOfAllElementsLocatedBy(
								contactUsLocator));
		
			// If we try to call this with out wait
			// org.openqa.selenium.NoSuchElementException: no such element: 
			// Unable to locate element: {"method":"xpath","selector":"//div[@class='ContactUs']"}
			//  (Session info: chrome=84.0.4147.135
			WebElement contactUs = driver.findElement(contactUsLocator);
			
			String elText = contactUs.getText();
			System.out.println(elText);

			
			/*
			 * If we fail to meet tiemout condition
			 * org.openqa.selenium.TimeoutException: Expected condition failed: 
			 * 	waiting for presence of element located by: 
			 * 	By.xpath: //div[@class='ContactUs'] (tried for 5 second(s) with 500 milliseconds interval)
				at org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)
				at org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)
				at com.sprintqa.class56.ExplicitWaitsDemo.main(ExplicitWaitsDemo.java:50)

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
