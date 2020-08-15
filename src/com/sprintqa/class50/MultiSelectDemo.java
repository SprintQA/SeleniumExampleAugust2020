package com.sprintqa.class50;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDemo {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
			driver.get(url);
			driver.manage().window().fullscreen();

			WebElement multiSelectElement = driver.findElement(By.id("multi-select"));
			Select multiSelect = new Select(multiSelectElement);

			if (multiSelect.isMultiple()) {
				System.out.println("This select box is a multi-select");
			}

			// Select all options in multi-select
			for (WebElement option : multiSelect.getOptions()) {
				option.click();
			}

			WebElement printMe = driver.findElement(By.id("printMe"));
			WebElement printAll = driver.findElement(By.id("printAll"));

			printMe.click();
			// print out the 1st selected option
			for (WebElement option : multiSelect.getOptions()) {
				if(option.isSelected()) {
					System.out.println("First Option Selected is: "
							+ option.getText());
					break;
				}
					
			}
			Thread.sleep(3000);

			printAll.click();
			// print out all selected option
			for (WebElement option : multiSelect.getOptions()) {
				if(option.isSelected()) {
					System.out.println("Option Selected is: "
							+ option.getText());
				}
					
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
