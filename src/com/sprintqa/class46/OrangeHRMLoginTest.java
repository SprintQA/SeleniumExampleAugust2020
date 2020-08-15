package com.sprintqa.class46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		// Set our WebDriver to Chrome
		WebDriver driver = new ChromeDriver();

		// Open browser and navigate to url
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// Test data will be
		// ( Username : Admin | Password : admin123 )
		// Locate Form Webelements and assign them to variables

		// Locator lookups using the By id/name methods
		// WebElement userNameInput = driver.findElement(By.name("txtUsername"));
		// WebElement passwordInput = driver.findElement(By.name("txtPassword"));
		// WebElement loginForm = driver.findElement(By.id("frmLogin"));

		// Locator lookups using the By xpath
		WebElement userNameInput = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement passwordInput = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		WebElement loginForm = driver.findElement(By.xpath("//form[@id='frmLogin']"));

		// Inputting our data using sendKeys
		userNameInput.sendKeys("Admin");
		passwordInput.sendKeys("admin123");

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Submitting the form to the server
		loginForm.submit();

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Assignment: Log into Orange HRM, Click the PIM Menu option, Click Add
		// Employee, Fill in First Name, Middle Name, Last Name, and click save. Use at
		// least one By locator look up by id, name, and by xpath. Take a screen shot of
		// last step in test and this section of code and put in slack.
		
		// Step 2: Click the PIM Menu option 
		WebElement pimMenuOption = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		pimMenuOption.click();
		
		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Step 3: Click the add employee submenu option
		WebElement addEmployeeMenuOption = driver.findElement(By.xpath("//a[contains(@id,'addEmployee')]"));
		addEmployeeMenuOption.click();

		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Step 4: Locate and fill in the input fields for name.
		WebElement firstNameInput = driver.findElement(By.id("firstName"));
		WebElement middleNameInput = driver.findElement(By.id("middleName"));
		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		
		firstNameInput.sendKeys("FirstNameTest");
		middleNameInput.sendKeys("MiddleNameTest");
		lastNameInput.sendKeys("LastNameTest");
		
		// This is just a pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Step 5: click save
		WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
		saveBtn.click();
		
		// This is just a pause
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		// Clean up our Browser and WebDriver
		driver.close();
		driver.quit();

	}

}
