package com.packt.webdriver.chapter1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NavigateToAUrl {
	public static void main(String[] args) {
		WebDriver driver;
		int driverToChoose = 0;
		switch (driverToChoose) {
		case 0:
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 1:
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver();
			break;
		case 3:
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			driver = new FirefoxDriver();
		}

		// WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement el = driver.findElement(By.name("q"));
		el.sendKeys("Microsoft");
		el.sendKeys(Keys.RETURN);
		driver.findElement(By.linkText("Microsoft - Wikipedia"));
		driver.quit();
	}
}