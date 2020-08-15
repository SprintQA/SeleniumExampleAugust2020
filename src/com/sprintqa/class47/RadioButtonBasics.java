package com.sprintqa.class47;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonBasics {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mpmeloche/development/eclipse-workspace/SeleniumProject/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		// Open the url and test the Radio Button Demo section of the webpage.
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

		// Maximize the Chrome browser to fill the screen.
		driver.manage().window().maximize();

		/*
		 * 1. Find the By Locators for the: 
		 * 		- Radio button ("Male") 
		 * 		- Radio button ("Female") 
		 * 		- Button ("Get Checked Value") 
		 * 		- Paragraph for output text from clicking button
		 */ 
		By maleRadioLocator = By.xpath("//input[@name='optradio'][@value='Male']");
		By femaleRadioLocator = By.xpath("//input[@name='optradio'][@value='Female']");
		By checkButtonLocator = By.id("buttoncheck");
		By checkButtonTextLocator = By.cssSelector("p.radiobutton");
		
		/* 2. Lookup the WebElements using the findElement method 
		 */
		WebElement maleRadioButton = driver.findElement(maleRadioLocator);
		WebElement femaleRadioButton = driver.findElement(femaleRadioLocator);
		WebElement checkButton = driver.findElement(checkButtonLocator);
		WebElement checkButtonText = driver.findElement(checkButtonTextLocator);
		
		/* 3. Validate that the text for the paragraph is "" when page loads
		 */ 
		if (checkButtonText.getText().equals("")) {
			System.out.println("Pass: Radio button pragraph text is blank on page load.");
		} else {
			System.out.println("Fail: Radio button pragraph text is not blank on page load.");
		}
		Thread.sleep(2000);
		
		/* 4. Validate the following: 
		 * 		- if no radio button is selected and the 
		 *        "Get Checked Value" button is clicked 
		 * 		
		 * 		- Paragraph text should equal "Radio 
		 * 		  button is Not checked"
		 */
		checkButton.click();
		System.out.println(checkButtonText.getText());
		Thread.sleep(2000);
		
		/* 5. Validate the following: 
		 * 		- If the "Male" radio button is clicked and 
		 * 		  the "Get Checked Value" button is clicked 
		 * 
		 * 		- Paragraph text should equal "Radio button 
		 * 		  'Male' is checked".
		 */
		maleRadioButton.click();
		checkButton.click();
		System.out.println(checkButtonText.getText());
		Thread.sleep(2000);
		
		/* 6. Validate the following: 
		 * 		- If the "Female" radio button is clicked and the
		 * 		  "Get Checked Value" button is clicked 
		 * 
		 * 		- Paragraph text should equal 
		 * 		  "Radio button 'Female' is checked".
		 */
		femaleRadioButton.click();
		checkButton.click();
		System.out.println(checkButtonText.getText());
		Thread.sleep(2000);
		
		/* 7. Get all radio button WebElements as a group
		 *    using the findElements method. 
		 */
		By genderRadioButtonsLocator = By.name("optradio");
		List<WebElement> genderRadioButtons = driver.findElements(genderRadioButtonsLocator);
		
		/* 8. Loop through the radio buttons clicking each one
		 *    and write out the text displayed in the Paragraph
		 *    text.
		 */
		for (WebElement radioButton : genderRadioButtons) {
			radioButton.click();
			checkButton.click();
			System.out.println(checkButtonText.getText());
			Thread.sleep(2000);
		}
		
		driver.close();
		driver.quit();
	}

}
