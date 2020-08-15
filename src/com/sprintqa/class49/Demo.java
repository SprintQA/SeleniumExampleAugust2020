package com.sprintqa.class49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.seleniumeasy.com/test/input-form-demo.html";
		
		driver.get(url);
		//driver.navigate().to(url);
		driver.manage().window().fullscreen();
		//driver.manage().window().maximize();

		WebElement firstName = driver.findElement(By.name("first_name"));
		WebElement lastName = driver.findElement(By.name("last_name"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement address = driver.findElement(By.name("address"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement zipCode = driver.findElement(By.name("zip"));
		WebElement website = driver.findElement(By.name("website"));
		WebElement hosting = driver.findElement(By.xpath("//input[@type='radio'][@value='yes']"));
		WebElement projectDescription = driver.findElement(By.cssSelector("textarea[name=comment]"));
		WebElement form = driver.findElement(By.xpath("//form"));
		
		
		firstName.sendKeys("Mike");
		hosting.click();
		projectDescription.sendKeys("Hi there\nHow are you?");
		Thread.sleep(2000);
		
		form.submit();
		
		
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
		
		
		
	}
	
}
