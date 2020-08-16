package com.sprintqa.class52;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InClassWindowHandlerAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "https://omayo.blogspot.com/";
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(2000);

			// Using WebDriver to interact with a window/tab.
			//
			// WebDriver does not make the distinction between windows and tabs. If your
			// site opens a new tab or window, Selenium will let you work with it using a
			// window handle. Each window has a unique identifier which remains persistent
			// in a single session.
			//
			// 1. Start by using the getWindowHandle() method to get the window handle of
			//    the current window.
			String currentWindow = driver.getWindowHandle();
			System.out.println(currentWindow);
			
			// 2. Check we don't have other windows open already
			if(driver.getWindowHandles().size() == 1) { //or < 2
			
				// 3. Use the WebDriver to search the web page using the "linkText" locator.
				WebElement newWindowLink = driver.findElement(By.linkText("Open a popup window"));
				Thread.sleep(2000);
				
				// 4. Clicking this link will open a new window/tab
				newWindowLink.click();
			
				// 5. Wait for the new window or tab
				while (driver.getWindowHandles().size() < 2) {
					Thread.sleep(2000);
				}
				
				// 6. Loop through until we find a new window handle
				for(String window:driver.getWindowHandles()) {
					if(!currentWindow.equals(window)) {
						driver.switchTo().window(window);
						break;
					}
				}
				
				// 7. Verify we are on the new window by checking for a viable web element on
				//   the page.
				WebElement para1 = driver.findElement(By.id("para1"));
				if(para1.isDisplayed()) {
					System.out.println("para1 is displayed");
					System.out.println("para1 text is: " + para1.getText());	
				}
				Thread.sleep(2000);
				// 8. Close the tab or window
				driver.close();
				
				// 9. Switch back to the old tab or window
				driver.switchTo().window(currentWindow);
				
				// 10. Verify we are on the new window by checking for a visible 
				//     web element on the page.
				WebElement textArea1 = driver.findElement(By.id("ta1"));
				if(textArea1.isDisplayed())
					System.out.println("TextArea 1 is displayed");
				
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}
	
}