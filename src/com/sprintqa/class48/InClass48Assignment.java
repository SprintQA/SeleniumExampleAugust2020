package com.sprintqa.class48;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClass48Assignment {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/Students/Index");
		driver.manage().window().maximize();

		/*
		 * 1. Goto Url http://uitestpractice.com/Students/Index
		 * 2. Click the "Form" menu option
		 * 3. Write the current page title and url to the console.
		 * 4. Fill out the form field text area "About Yourself
		 * 5. Verify the test entered into the the form field text area "About Yourself
		 * 6. Click submit
		 * 7. Verify the form field text area "About Yourself is blank
		 */
		
		//2
		//By formLinkLocator = By.xpath("//a[text()='Form']");
		By formLinkLocator = By.linkText("Form");
		
		WebElement formLink = driver.findElement(formLinkLocator);
		formLink.click();
		Thread.sleep(3000);
		
		
		//3
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		//4
		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		List<WebElement> married = driver.findElements(By.xpath("//input[@name='optradio']"));
		WebElement hobby = driver.findElement(By.xpath("//input[@type='checkbox'][@value='dance']"));
		WebElement phone = driver.findElement(By.id("phonenumber"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement aboutYourself = driver.findElement(By.id("comment"));
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

		firstName.sendKeys("John");
		lastName.sendKeys("Smith");
		married.get(0).click();
		hobby.click();
		phone.sendKeys("6155555555");
		username.sendKeys("john_smith");
		email.sendKeys("john_smith@gmail.com");
		aboutYourself.sendKeys("Hello There\nJohn Smith");
		password.sendKeys("password");
		
		//5
		if (aboutYourself.getAttribute("value").equals("Hello There\nJohn Smith")) {
			System.out.println("Pass");
		} else
			System.out.println("Fail");
		
		Thread.sleep(3000);
		
		//6
		WebElement form = driver.findElement(By.xpath("//form"));
		form.submit();
		Thread.sleep(3000);
		
		//7
		aboutYourself = driver.findElement(By.id("comment"));
		if (aboutYourself.getAttribute("value").equals("")) {
			System.out.println("Pass");
		} else
			System.out.println("Fail");

		
		
		driver.close();
		driver.quit();
	}
}
