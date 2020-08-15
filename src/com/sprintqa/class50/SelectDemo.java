package com.sprintqa.class50;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
			driver.get(url);
			driver.manage().window().fullscreen();

			By selectLocator = By.id("select-demo");
			WebElement selectElement = driver.findElement(selectLocator);

			// Convert WebElement into Select Class Obj
			Select daysOfWeekSelect = new Select(selectElement);

			daysOfWeekSelect.selectByIndex(1);
			// daysOfWeekSelect.selectByVisibleText("Sunday");

			// Gives us a List of WebElements containing our select options
			List<WebElement> daysOfWeekOptions = daysOfWeekSelect.getOptions();

			if (daysOfWeekOptions.get(0).isDisplayed()) {
				System.out.println("Option 0 is disabled.");
			}

			for (WebElement dayOfWeekOption : daysOfWeekOptions) {
				if (dayOfWeekOption.isSelected()) {
					System.out.println("Option " 
							+ dayOfWeekOption.getText() + " is selected");
				}

			}

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
