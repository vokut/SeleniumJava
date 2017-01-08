package com.packt.webdriver.chapter1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateToAUrl {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		driver.quit();
	}
}