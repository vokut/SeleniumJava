package com.packt.webdriver.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file://D:/Dropbox/Books/Selenium/Selenium WebDriver Practical Guide/Chapter 2/HTML/sortable.html");
		WebElement three = driver.findElement(By.name("three"));
		WebElement two = driver.findElement(By.name("two"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(three).clickAndHold(three).moveToElement(two).release(two).perform();

		driver.quit();
	}

}
