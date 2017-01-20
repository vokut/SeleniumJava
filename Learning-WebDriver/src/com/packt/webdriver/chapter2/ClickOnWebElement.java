package com.packt.webdriver.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickOnWebElement {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file://D:/Dropbox/Books/Selenium/Selenium WebDriver Practical Guide/Chapter 2/HTML/selectable.html");
		WebElement one = driver.findElement(By.name("one"));
		WebElement eleven = driver.findElement(By.name("eleven"));
		WebElement five = driver.findElement(By.name("five"));
		
		Actions builder = new Actions(driver);
		//Click on One
		/*builder.click(one);
		builder.build().perform();
		// Click on Eleven
		builder.click(eleven);
		builder.build().perform();
		//Click on Five
		builder.click(five); */
		builder.click(one).click(eleven).click(five);
		builder.perform();

		driver.quit();
	}

}
