package com.packt.webdriver.chapter3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreCookieInfo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.facebook.com");
			driver.findElement(By.name("email")).sendKeys("todor.tukov@abv.bg");
			driver.findElement(By.name("pass")).sendKeys("todort79");
			driver.findElement(By.name("pass")).submit();

			File f = new File("browser.data");
			try {
				f.delete();
				f.createNewFile();
				FileWriter fos = new FileWriter(f);
				BufferedWriter bos = new BufferedWriter(fos);
				for (Cookie ck : driver.manage().getCookies()) {
					bos.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
					bos.newLine();
				}
				bos.flush();
				bos.close();
				fos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
