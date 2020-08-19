package com.sprintqa.class52;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragDropActionsDemo {
	
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Actions";
			driver.get(url);
			driver.manage().window().maximize();

			/* Example 3: Using the Action class to simulate a drag and drop.
			 * 1. Identify the element to drag from
			 * 2. Identify the element to drag to
			 * 3. Call the dragAndDrop() method, passing in the item 
			 *    to drag and where to drop the item.
			 */ 
			WebElement draggable = driver.findElement(By.id("draggable"));
			WebElement droppable = driver.findElement(By.id("droppable"));
			Thread.sleep(2000);
			
			Actions actions = new Actions(driver);
			actions.dragAndDrop(draggable, droppable).build().perform();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	

}
