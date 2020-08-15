package com.sprintqa.class50;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InClassMultiSelectAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://stqatools.com/demo/Multiselect.php";
			driver.get(url);
			driver.manage().window().fullscreen();

			WebElement dateMultiSelectElement = driver.findElement(By.xpath("//select[@class='date_s']"));
			// WebElement dateMultiSelectElement =
			// driver.findElement(By.cssSelector("select.date_s"));
			// WebElement dateMultiSelectElement =
			// driver.findElement(By.className("date_s"));
			WebElement nameMultiSelectElement = driver.findElement(By.xpath("//select[@class='name_s']"));

			Thread.sleep(3000);

			Select dateMultiSelect = new Select(dateMultiSelectElement);
			Select nameMultiSelect = new Select(nameMultiSelectElement);

			dateMultiSelect.selectByIndex(0);
			nameMultiSelect.selectByIndex(0);

			// Loop through and write out the selected values of each
//			for (WebElement option : dateMultiSelect.getAllSelectedOptions()) {
//				System.out.println("DateOption Selected is: " + option.getText());
//			}
			printSelectedOptions(dateMultiSelect);

			// Loop through and write out the selected values of each
//			for (WebElement option : nameMultiSelect.getAllSelectedOptions()) {
//				System.out.println("Name Option Selected is: " + option.getText());
//			}
			printSelectedOptions(nameMultiSelect);

			Thread.sleep(3000);

			// Don't forget to deselect the values before selecting them
			dateMultiSelect.deselectAll();

			// Select all the date options
//			for (WebElement option : dateMultiSelect.getOptions()) {
//				option.click();
//			}
			selectAllOption(dateMultiSelect);
			//selectAllOption(nameMultiSelect);
			
			// Call a new method that sysout all the selected options text
			System.out.println("Date Multi-Select Values:");
			printSelectedOptions(dateMultiSelect);

			Thread.sleep(3000);

			// Don't forget to deselect the values before selecting them
			nameMultiSelect.deselectAll();

			// Get the number of options in the Multi-Select
			int numberOfNameOptions = nameMultiSelect.getOptions().size();

			// Select the 1st option in the list at index 0
			nameMultiSelect.selectByIndex(0);

			// Select the last option in the list (Total options - 1)
			nameMultiSelect.selectByIndex(numberOfNameOptions - 1);

			System.out.println("Selected Multi-Select Values:");
			printSelectedOptions(nameMultiSelect);

			Thread.sleep(3000);

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

	public static void selectAllOption(Select select) {
		// Select all the date options
		for (WebElement option : select.getOptions()) {
			option.click();
		}
	}

	public static void printSelectedOptions(Select select) {
		// Loop through and write out the selected values of each
		for (WebElement option : select.getAllSelectedOptions()) {
			System.out.println("Option Selected is: " + option.getText());
		}
	}

}
