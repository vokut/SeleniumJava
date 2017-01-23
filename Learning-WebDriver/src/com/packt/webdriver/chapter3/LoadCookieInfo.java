package com.packt.webdriver.chapter3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadCookieInfo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
		//Date myDate = df.parse("Wed Jan 23 15:29:56 EEST 2019");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://www.facebook.com");
			try {
				File f = new File("browser.data");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					StringTokenizer str = new StringTokenizer(line, ";");
					while (str.hasMoreTokens()) {
						String name = str.nextToken();
						String value = str.nextToken();
						String domain = str.nextToken();
						String path = str.nextToken();
						Date expiry = null;
						String dt;
						if (!(dt = str.nextToken()).equals("null")) {
							expiry = df.parse(dt);
						}
						boolean isSecure = new Boolean(str.nextToken()).booleanValue();
						Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
						driver.manage().addCookie(ck);
					}
				}
				br.close();
				fr.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			driver.get("http://www.facebook.com");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			driver.quit();
		}
	}
}
