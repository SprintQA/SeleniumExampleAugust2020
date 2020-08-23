package com.sprintqa.class55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://www.orbitz.com/";
			driver.get(url);
			driver.manage().window().maximize();

			/*
			 * 	Go to: https://www.orbitz.com/
			 * 1. Locate the check in input box and click it to 
			 *    bring up the DataPicker
			 * 2. Locate the left calendars Date Picker Calendar 
			 *    Month Caption and store it in a By variable.
			 * 3. Get the displayed text from the the left calendars 
			 *    Date Picker Calendar Month Caption and store it in 
			 *    a String variable calendarDisplayedMonth.
			 * 4. Write the String variable calendarDisplayedMonth 
			 *    to the System.out console.
			 * 5. Check the String variable calendarDisplayedMonth 
			 *    to see if it is currently Jan 2021
			 * 6. Create a do/while loop to loop until the left 
			 *    calendars Date Picker Calendar Month Caption is Jan 2021
			 * 7. Locate the Date Picker Calendar next button and click it
			 * 8. Pause for 1 sec between clocks to give the calendar time to refresh
			 * 9. Click on Jan 31 2021
			 */
			
			WebElement hotelCheckin = driver.findElement(By.id("hotel-checkin-hp-hotel"));
			hotelCheckin.click();
			
			By datepickerCalMonthCaptionLocator = By.cssSelector("div.datepicker-cal-month > table > caption");
			
			// Get the displayed text from the the left calendars Date Picker Calendar Month
			// Caption and store it in a String variable calendarDisplayedMonth.
			String calendarDisplayedMonth = driver.findElement(datepickerCalMonthCaptionLocator).getText();

			System.out.println(calendarDisplayedMonth);
			
			if (!calendarDisplayedMonth.equals("Jan 2021")) {
				// If calendarDisplayedMonth does not equal "Jan 2021"
				do {
					
					// Locate the Date Picker Calendar next button and click it
					driver.findElement(By.cssSelector("button.next")).click();
					Thread.sleep(2000);
					
				}while(!driver.findElement(datepickerCalMonthCaptionLocator).getText().equals("Jan 2021"));
				
			}
			
			// Click on Jan 31 2021
			driver.findElement(By.xpath("//button[@data-year='2021'][@data-month='0'][@data-day='31']")).click();

			
			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
