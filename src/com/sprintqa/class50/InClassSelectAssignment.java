package com.sprintqa.class50;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InClassSelectAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://stqatools.com/demo/index.php";
			driver.get(url);
			driver.manage().window().fullscreen();

			WebElement cityElement = driver.findElement(By.name("City"));
			WebElement courseElement = driver.findElement(By.name("Course"));
			WebElement districtElement = driver.findElement(By.name("District"));
			WebElement stateElement = driver.findElement(By.name("State"));

			List<WebElement> selects = driver.findElements(By.xpath("//select"));
			
			//Check the req. is the "select.." text preselected
			// 1. is an option selected
			// 2. is the selected options text = "select.."
			Select citySelect = new Select(cityElement);			
			List<WebElement> cityOptions = citySelect.getOptions();
			for(WebElement cityOption: cityOptions) {
				if(cityOption.isSelected()
						&& cityOption.getText().equals("select..")) {
					System.out.println("Requirements met");
				}
			}
			
			Select selectElement;
			for(WebElement select: selects) {
				selectElement = new Select(select);
				selectElement.selectByIndex(1);
				Thread.sleep(2000);
			}
			
			Select courseSelect = new Select(courseElement);
			Select districtSelect = new Select(districtElement);
			Select stateSelect = new Select(stateElement);

			citySelect.selectByIndex(2);
			Thread.sleep(2000);
			
			courseSelect.selectByIndex(2);
			Thread.sleep(2000);
			
			districtSelect.selectByIndex(2);
			Thread.sleep(2000);
			
			stateSelect.selectByIndex(2);
			Thread.sleep(2000);

			stateSelect.selectByVisibleText("GOA");
			Thread.sleep(2000);
			
			stateSelect.selectByValue("Bihar");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	
}
