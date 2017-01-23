package com.packt.webdriver.chapter3;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakeScreenshot {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com?q=hello");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 

		Date date = new Date();
		
		/*final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String s = sdf.format(date);*/
		
		Timestamp t = new Timestamp(date.getTime());
		String dateNow = t.toString().replace(":","_");
		
		String destFile = System.getProperty("user.dir") + "/Screenshots/" + dateNow.toString() + ".png";
		FileUtils.copyFile(scrFile, new File(destFile));
		
		driver.quit();
	}

}
