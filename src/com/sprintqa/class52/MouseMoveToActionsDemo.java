package com.sprintqa.class52;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMoveToActionsDemo {
	
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Actions";
			driver.get(url);
			driver.manage().window().maximize();

			/* Example 4: Using Actions to control a web pages mouse interactions.
			 * The Action class is user-facing API for emulating complex user gestures.
			 * Use this class rather than using the Keyboard or Mouse directly.
			 * 
			 * 1. Use the moveToElement to move the mouse over the blue box
			 *    this will trigger the onMouseOver Event changing the box to
			 *    Green.
			 */
			WebElement div2 = driver.findElement(By.id("div2"));
			Thread.sleep(2000);
			
			Actions actions = new Actions(driver);
			actions.moveToElement(div2).perform();
			Thread.sleep(2000);
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	

}
