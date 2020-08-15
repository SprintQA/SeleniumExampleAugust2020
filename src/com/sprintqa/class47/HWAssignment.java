package com.sprintqa.class47;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 * 1. Go to https://demoqa.com/automation-practice-form/
 * 
 * 2. Create a test that fills in the following fields with your information:
 * 		First Name, Last Name, Email, Gender, Mobile, Subjects, and Hobbies
 * 
 * 3. Click submit
 * 
 * Provide test code when completed
 */

public class HWAssignment {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		// 1
		driver.get("https://demoqa.com/automation-practice-form/");
		//driver.manage().window().maximize();
		Thread.sleep(2000);
		//2
		By genderLocator = By.xpath("//label[@for='gender-radio-3']");
		By hobbieLocator = By.xpath("//label[@for='hobbies-checkbox-3']"); //many
		By submitButtonLocator = By.id("submit"); //Won't work
		By formLocator = By.id("userForm"); //Will work
		
		WebElement genderRadio = driver.findElement(genderLocator);
		WebElement hobbieCheckboxs = driver.findElement(hobbieLocator);
		WebElement form = driver.findElement(formLocator);
		
		genderRadio.click();
		Thread.sleep(2000);
		
		hobbieCheckboxs.click();
		Thread.sleep(2000);
		
		form.submit();
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}

}