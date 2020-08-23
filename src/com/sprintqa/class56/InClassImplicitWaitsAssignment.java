package com.sprintqa.class56;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassImplicitWaitsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			/*
			 * An implicit wait tells the WebDriver to poll the DOM for a certain amount of
			 * time when trying to find an element or elements if they are not immediately
			 * available.
			 * 
			 * The default setting is 0, meaning disabled. Once set, the implicit wait is
			 * set for the life of the session.
			 * 
			 * Once this time is set, WebDriver will wait for the element before the
			 * exception occurs.
			 */
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers
			 * 1. Set the web driver's implicit wait timeout to 30s
			 * 2. Set the amount of time to wait for a page load to complete before throwing
			 *    an error 30s.
			 * 3. Locate the Locator for user name input and enter "Admin" text
			 * 4. Locate the Locator for the password input and enter "admin123"
			 * 5. Locate the locator for the login button and click it.
			 * 6. Locate the locator for the "Admin" menu button and click it.
			 * 7. Declare our Strings to store Expected String value
			 * 8. Verify that expected text System Users is displayed.
			 */ 
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			By userNameLocator = By.id("txtUsername");
			By passwordLocator = By.id("txtPassword");
			By loginLocator = By.id("frmLogin");
			
			WebElement userName = driver.findElement(userNameLocator);
			WebElement password = driver.findElement(passwordLocator);
			WebElement login = driver.findElement(loginLocator);
			
			userName.sendKeys("Admin");
			password.sendKeys("admin123");
			login.submit();

			By adminLocator = By.id("menu_admin_viewAdminModule");
			WebElement adminMenu = driver.findElement(adminLocator);
			adminMenu.click();

			By pageTitleLocator = By.xpath("//div[@id='systemUser-information']//div//h1");
			WebElement pageTitle = driver.findElement(pageTitleLocator);
			
			String expectedText = "System Users";
			if (expectedText.equals(pageTitle.getText())) {
				System.out.println("Test Passed.");
			} else {
				System.out.println("Test Failed.");
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
