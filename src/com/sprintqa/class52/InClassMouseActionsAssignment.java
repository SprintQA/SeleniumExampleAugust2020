package com.sprintqa.class52;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InClassMouseActionsAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/";

			// Open up your Chrome browser to the starting web page.
			driver.get(url);

			// Maximize the Chrome browser to fill the screen.
			driver.manage().window().maximize();

			/*
			 * Perform the following Actions on: http://uitestpractice.com/
			 * 1. Drag the “Drag me to my target” box to the “Drop here” box”. 
			 * 2. Double click the “Double Click Me!” Button.
			 * 3. Get text from alert box and write it to the console.
			 * 4. Click OK on alert box. 
			 * 5. Move to the “Toggle icons” button, pause 2 sec, click it, pause 3 sec.
			 */
			Actions actions = new Actions(driver);

			// Find our drag and drop elements by id
			WebElement dragItem = driver.findElement(By.id("draggable"));
			WebElement dropItem = driver.findElement(By.id("droppable"));
			Thread.sleep(2000);
			
			// drags dragItem onto dropItem
			actions.dragAndDrop(dragItem, dropItem).build().perform();
			Thread.sleep(2000);
			
			// Find our drag and drop elements
			WebElement doubleClickButton = driver.findElement(By.name("dblClick"));

			// perform double click on button
			actions.moveToElement(doubleClickButton).doubleClick().build().perform();

			Thread.sleep(2000);
			// Switch to the alert box and click ok
			Alert alert = driver.switchTo().alert();
			
			System.out.println(alert.getText());
			alert.accept();
			Thread.sleep(2000);
			
			// Switch to the default open window
			driver.switchTo().defaultContent();

			// Locate toggle button by id
			WebElement toggleClickButton = driver.findElement(By.id("toggle"));

			// click toggle button
			actions.moveToElement(toggleClickButton).pause(2000).click().pause(3000).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
}
