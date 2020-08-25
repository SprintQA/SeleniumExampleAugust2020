package com.sprintqa.class57;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		try {

			System.setProperty("webdriver.chrome.driver",
					"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

			driver = new ChromeDriver();

			String url = "http://uitestpractice.com/Students/Index";
			driver.get(url);
			driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			/*
			 * Go to: http://uitestpractice.com/Students/Index
			 * 1. Get the Location of "Create New" Button
			 * 
			 * 2. Create a local variables of types:
			 * 		String, URL, and HttpURLConnection
			 * 
			 * 		- "URL" represents a Uniform Resource Locator, a pointer 
			 * 		   to a "resource" on the World Wide Web
			 * 
			 * 		- Each HttpURLConnection instance is used to make a single 
			 *  	  request but the underlying network connection to the HTTP 
			 *  	  server may be transparently shared by other instances.
			 * 
			 * 3. Get the href attribute value from our WebElement.
			 * 
			 * 4. Creates a URL object from the String representation.
			 * 
			 * 5. Returns a URLConnection instance that represents a 
			 *    connection to the remote object referred to by the URL.
			 * 
			 * 6. Gets the status code from an HTTP response message.
			 * 	  For example, in the case of the following status lines:
			 *		- HTTP/1.0 200 OK
			 *		- HTTP/1.0 401 Unauthorized
			 *
			 *	  It will return 200 and 401 respectively. 
			 *	  Returns -1 if no code can be discerned from the response 
			 *		- i.e., the response is not valid
			 *	
			 *	  see https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
			 *
			 * 7. Verify we received HTTP/1.0 200 OK
			 */
			
			
			
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
