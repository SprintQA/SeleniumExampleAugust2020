package com.sprintqa.class52;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClickActionsDemo {
	
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
			 * Example 2: Using the Action class doubleClick() method.
			 * 1. Click the "Double Click Me!" button
			 */			
			WebElement dblClick = driver.findElement(By.name("dblClick"));
			
			Actions actions = new Actions(driver);
			//actions.click(dblClick).click();
			actions.doubleClick(dblClick).build().perform();
			
			Thread.sleep(2000);
			
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			
			Thread.sleep(2000);
			alert.accept();
			driver.switchTo().defaultContent();
			
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	

}
