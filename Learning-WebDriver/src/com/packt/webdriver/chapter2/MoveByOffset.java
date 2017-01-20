package com.packt.webdriver.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveByOffset {
	public static void main(String... args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file://D:/Dropbox/Books/Selenium/Selenium WebDriver Practical Guide/Chapter 2/HTML/selectable.html");
		WebElement three = driver.findElement(By.name("three"));
		System.out.println("X coordinate: " + three.getLocation().getX() + " Y coordinate: " + three.getLocation().getY());
		Actions builder = new Actions(driver);
		builder.moveByOffset(three.getLocation().getX() + 1, three.getLocation().getY() + 1);
		builder.perform();
		driver.quit();
	}

}
