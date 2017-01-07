package com.packt.webdriver.chapter1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NavigateToAUrl {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}
}