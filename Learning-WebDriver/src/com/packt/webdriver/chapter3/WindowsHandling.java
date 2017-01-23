package com.packt.webdriver.chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file://D:/Dropbox/Books/Selenium/Selenium WebDriver Practical Guide/Chapter 3/HTML/Window.html");

		String window1 = driver.getWindowHandle();
		System.out.println("First window handle is: " + window1);

		WebElement link = driver.findElement(By.linkText("Google Search"));
//		Actions builder = new Actions(driver);
//		builder.keyDown(Keys.SHIFT).click(link).perform();
		link.click();

		String window2 = "" ;
		for (String handle: driver.getWindowHandles()) {
			window2 = handle;
		}
		
		System.out.println("Second window handle is: " + window2);
		System.out.println("Number of window handles so far: " + driver.getWindowHandles().size());
		driver.switchTo().window(window2);
		driver.switchTo().window(window1);
		driver.findElement(By.linkText("Google Search"));
		driver.quit();
	}
}
