package com.sprintqa.class55;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UsingCelendarsWithTablesDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * Go to: https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers
			 * 1. Using the Actions class log into OrangHRM
			 * 		- Locate the Username, Password, Login button
			 * 		- Pause 1 sec after clicking login to give the 
			 * 		  browser time to load the new page 
			 * 2. Go to leave menu option
			 * 3. Go to My Leave submenu option
			 * 4. Change the search filter to only pull the days for June 2020
			 * 5. Click search
			 * 6. Read table information
			 */

			Actions actions = new Actions(driver);
			
			WebElement userName = driver.findElement(By.id("txtUsername"));
			WebElement password = driver.findElement(By.id("txtPassword"));
			WebElement loginBtn = driver.findElement(By.id("btnLogin"));
			
			actions
				.sendKeys(userName, "Admin")
				.sendKeys(password, "admin123")
				.click(loginBtn)
				.pause(1000)
				.build()
				.perform();
	
			WebElement leaveMenu = driver.findElement(By.id("menu_leave_viewLeaveModule"));
			actions.click(leaveMenu).pause(1000).build().perform();
			
			WebElement myLeaveSubMenu = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
			actions.click(myLeaveSubMenu).pause(1000).build().perform();
			
			WebElement calFromDate = driver.findElement(By.id("calFromDate"));
			calFromDate.click();
			Thread.sleep(2000);
			
			WebElement fromDate = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
			Select fromDateSelect = new Select(fromDate);
			fromDateSelect.selectByVisibleText("Jun");
			
			WebElement fromYear = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
			Select fromYearSelect = new Select(fromYear);
			fromYearSelect.selectByVisibleText("2020");
			
			List<WebElement> fromDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
			
			for(WebElement day:fromDays) {
				if(day.getText().equals("1")){
					day.click();
					break;
				}
			}
			
			WebElement calToDate = driver.findElement(By.id("calToDate"));
			calToDate.click();
			Thread.sleep(2000);
			
			WebElement toDate = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
			Select toDateSelect = new Select(toDate);
			toDateSelect.selectByVisibleText("Jun");
			
			WebElement toYear = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
			Select toYearSelect = new Select(toYear);
			toYearSelect.selectByVisibleText("2020");
			
			List<WebElement> toDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
			
			for(WebElement day:toDays) {
				if(day.getText().equals("30")){
					day.click();
					break;
				}
			}

			driver.findElement(By.id("btnSearch")).click();
			
			//Loop through table and write out row text
			
			
			
			
			
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
