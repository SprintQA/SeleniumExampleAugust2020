package com.sprintqa.class57;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/";
			driver.get(url);
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 * Go to: http://uitestpractice.com/
			 * 1. Locate the effectTypes drop down at the bottom of the page
			 * 2. Instantiate a JavascriptExecutor object and pass it the reference to driver.
			 * 	  - JavaScriptExecutor is an Interface that helps to execute JavaScript through
			 * 	    Selenium WebDriver. JavaScriptExecutor provides two methods "executescript" &
			 * 	    "executeAsyncScript" to run javascript on the selected window or current
			 * 	    page.
			 * 3. Use window.scrollBy(X,Y) to:
			 * 	  - Vertical scroll down by 1000 pixels
			 * 	  - Vertical scroll up by 400 pixels
			 * 	  - Scroll effect types drop down it into view
			 * 
			 * 	  X = Horizontal scrolling 
			 *    Y = Vertical Scrolling
			 *    
			 *    Positive numbers equate to: 
			 *    		X = Scroll right 
			 *    		Y = Scroll Down
			 *    Negative numbers equate to: 
			 *    		X = Scroll Left 
			 *    		Y = Scroll Up
			 *
			 * 4. Select the "Size" text from the drop down
			 * 5. Locate the "Run Effect" Button
			 * 6. use the JavascriptExecutor click() method to click the button 
			 * 7. Use the JavascriptExecutor alert('text');  to generate Alert window. 
			 * 8. Accept the alert.
			 * 9. Use the JavascriptExecutor history.go(0) to refresh the page.
			 * 10. Use the JavascriptExecutor return document.title; to get the title of a web page
			 */
			
			WebElement effectTypes = driver.findElement(By.id("effectTypes"));
		
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0, -400)");
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView(true);", effectTypes);
			Thread.sleep(2000);
			
			Select dropDown = new Select(effectTypes);
			dropDown.selectByVisibleText("Size");
			Thread.sleep(2000);
			WebElement runEffectButton = driver.findElement(By.xpath("//button[text()='Run Effect']"));
			//runEffectButton.click();
			js.executeScript("arguments[0].click();", runEffectButton);
			Thread.sleep(2000);
			
			js.executeScript("alert('You Clicked Class Demo');");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();

			js.executeScript("history.go(0)");

			System.out.println(js.executeScript("return document.title;").toString());

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
		
	}

}
