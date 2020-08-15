package com.sprintqa.class50;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataListDemo {
//ice-cream-choice
	
	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://developer.mozilla.org/en-US/docs/Web/HTML/Element/datalist";
			driver.get(url);
			driver.manage().window().fullscreen();

			WebElement iceCreamChoiceInput = driver.findElement(By.id("ice-cream-choice"));
			WebElement iceCreamFlavorsSelectElement = driver.findElement(By.id("ice-cream-flavors"));
			
			Select iceCreamFlavorsSelect = new Select(iceCreamFlavorsSelectElement);

			printAllOptions(iceCreamFlavorsSelect);
			
			iceCreamChoiceInput.sendKeys("Chocolate");
			
			for(WebElement iceCreamFlavor: iceCreamFlavorsSelect.getOptions()) {
				if(iceCreamFlavor.getAttribute("value").equals("Chocolate"))
					iceCreamFlavor.click();
			}
			

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	
	public static void printAllOptions(Select select) {
		for (WebElement option : select.getOptions()) {
			System.out.println("Option: " + option.getText());
		}
	}
	
}
