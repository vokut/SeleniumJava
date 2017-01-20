package com.packt.webdriver.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file://D:/Dropbox/Books/Selenium/Selenium WebDriver Practical Guide/Chapter 2/HTML/DoubleClick.html");
		WebElement dblClick = driver.findElement(By.name("dblClick"));
		Actions builder = new Actions(driver);
		builder.doubleClick(dblClick).perform();

		driver.quit();
	}

}
