package com.packt.webdriver.chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBetweenFrames {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("file://D:/Dropbox/Books/Selenium/Selenium WebDriver Practical Guide/Chapter 3/HTML/Frames.html");

			driver.switchTo().frame("frameOne");
			WebElement txt = driver.findElement(By.name("1"));
			txt.sendKeys("I'm frame one");

			 driver.switchTo().defaultContent();

			driver.switchTo().frame("frameTwo");
			txt = driver.findElement(By.name("2"));
			txt.sendKeys("Im' frame two");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			driver.quit();
		}
	}
}
