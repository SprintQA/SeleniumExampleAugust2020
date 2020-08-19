package com.sprintqa.class52;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClickActionsDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Actions";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Example 1a: Using the Action class click() method. 1. Click the "Click Me!"
			 * button.
			 */
			WebElement singleClickButton = driver.findElement(By.name("click"));
			// clickButton.click();

			Actions actions = new Actions(driver);
			actions.click(singleClickButton).perform();

			Thread.sleep(2000);

			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());

			Thread.sleep(2000);
			alert.accept();
			driver.switchTo().defaultContent();

			Thread.sleep(2000);
			/*
			 * Example 1b. Build a complex set of action commands to: 1. Loop through the
			 * numbered Elements 2. Click the current number 3. Pause 1 second between
			 * clicks
			 */
			WebElement selectableButtonList = driver.findElement(By.id("selectable"));

			/*
			 * Because the numbered boxes are a list we need to get list items. Since this
			 * is not a Select we cannot use the Select class. Instead we have to do an
			 * additional findElements() call on the <ul> tag "selectable" for <li> tags.
			 * This will return a List of line Item Webelements.
			 */
			List<WebElement> numberListItems = selectableButtonList.findElements(By.tagName("li"));

			for (WebElement numberListItem : numberListItems) {
				actions.click(numberListItem).pause(1000);
			}
			actions.build().perform();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
