package com.sprintqa.class49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://opensource-demo.orangehrmlive.com/";
			driver.get(url);
			// driver.navigate().to(url);
			driver.manage().window().fullscreen();

			// Part 1
			WebElement userName = driver.findElement(By.name("txtUsername"));
			WebElement password = driver.findElement(By.name("txtPassword"));
			WebElement login = driver.findElement(By.id("frmLogin"));

			userName.sendKeys("Admin");
			password.sendKeys("admin123");
			Thread.sleep(2000);
			
			login.submit();
			Thread.sleep(2000);
		
			// Part 2
			WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
			adminMenu.click();
			Thread.sleep(2000);
			
			WebElement addButton = driver.findElement(By.name("btnAdd"));
			addButton.click();
			Thread.sleep(2000);
			
			WebElement empName = driver.findElement(By.id("systemUser_employeeName_empName"));
			userName = driver.findElement(By.id("systemUser_userName"));
			password = driver.findElement(By.id("systemUser_password"));
			WebElement confirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
			WebElement saveButton = driver.findElement(By.id("btnSave"));
			
			empName.sendKeys("Aaaa Bbb Ccc");
			userName.sendKeys("testaccount14555");
			password.sendKeys("password");
			confirmPassword.sendKeys("password");
			Thread.sleep(2000);
			saveButton.click();
			Thread.sleep(2000);
			
			// Part 3
			WebElement jobTitleListMenu = driver.findElement(By.xpath("//a[text()='Job Titles']"));
			driver.navigate().to(jobTitleListMenu.getAttribute("href"));
			//driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList");
			Thread.sleep(5000);

			addButton = driver.findElement(By.name("btnAdd"));
			addButton.click();
			Thread.sleep(2000);
			
			WebElement jobTitle = driver.findElement(By.id("jobTitle_jobTitle"));
			WebElement jobDescription = driver.findElement(By.id("jobTitle_jobDescription"));
			WebElement note = driver.findElement(By.id("jobTitle_note"));
			saveButton = driver.findElement(By.id("btnSave"));

			jobTitle.sendKeys("QA Position 42");
			jobDescription.sendKeys("To be the text editor for Doglas Adams.");
			note.sendKeys("What is the answer to\nlife the universe and everything?");
			Thread.sleep(2000);
			saveButton.click();
			Thread.sleep(2000);
		
			//Part 4
			WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
			//WebElement logout = driver.findElement(By.linkText("Logout"));
			//WebElement logout = driver.findElement(By.partialLinkText("out");
			
			driver.navigate().to(logout.getAttribute("href"));
			Thread.sleep(2000);

			userName = driver.findElement(By.name("txtUsername"));
			password = driver.findElement(By.name("txtPassword"));
			login = driver.findElement(By.id("frmLogin"));

			userName.sendKeys("testaccount14555");
			password.sendKeys("password");
			Thread.sleep(2000);
			login.submit();
			Thread.sleep(2000);

			
			WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
			myInfo.click();
			Thread.sleep(2000);

			
			saveButton = driver.findElement(By.id("btnSave"));
			saveButton.click();
			Thread.sleep(2000);
			
			WebElement gender = driver.findElement(By.id("personal_optGender_1"));
			gender.click();
			
			Thread.sleep(2000);
			saveButton = driver.findElement(By.id("btnSave"));
			saveButton.click();
			Thread.sleep(2000);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			driver.close();
			driver.quit();
		}

	}

}
