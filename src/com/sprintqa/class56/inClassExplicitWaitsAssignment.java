package com.sprintqa.class56;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class inClassExplicitWaitsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			driver.get(url);
			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			/*
			 * Go to: https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers
			 * 1. Set the amount of time to wait for a page load to complete before throwing
			 *    an error to 30s.
			 * 2. Locate the Locator for user name input and enter "Admin" text
			 * 3. Locate the locator for the login button and click it.
			 * 4. Preparing the explicit wait 30s.
			 * 5. Wait for the presence Of the "Admin" Menu Element to be Located.
			 * 6. Locate the locator for the "USer Management" menu button and click it.
			 * 7. Wait for the Element "System User" Element to be visible
			 * 8. Declare our Strings to store Expected String value
			 * 9. Verify that expected text System Users is displayed.
			 */
			

			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("frmLogin")).submit();

			//4
			WebDriverWait wait = new WebDriverWait(driver, 30);

			By adminMenuLocator = By.id("menu_admin_viewAdminModule");
			By userManagementLocator = By.id("menu_admin_UserManagement");
			
			wait
				.until(
						ExpectedConditions
								.presenceOfElementLocated(adminMenuLocator));

			driver.findElement(adminMenuLocator).click();
			
			wait
				.until(
					ExpectedConditions
							.elementToBeClickable(userManagementLocator));
			
			driver.findElement(userManagementLocator).click();

			By systemUserTitle = By.cssSelector("div#systemUser-information>div.head>h1");
			
			wait
				.until(
						ExpectedConditions
							.visibilityOfElementLocated(systemUserTitle));

			String expectedText = "System Users";

			String actualText = driver.findElement(systemUserTitle).getText();

			if (expectedText.contentEquals(actualText)) {
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
