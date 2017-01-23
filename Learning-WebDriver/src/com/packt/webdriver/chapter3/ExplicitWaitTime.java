package com.packt.webdriver.chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTime {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			/*WebElement element = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver d) {
					return d.findElement(By.name("q"));
				}
			});*/
			driver.get("http://www.google.com/ncr");
			WebDriverWait w = new WebDriverWait(driver, 40);
			WebElement el = w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
			el.sendKeys("Hello");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			driver.quit();
		}
	}
}
