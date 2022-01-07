package com.laubang.crawler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.laubang.base.crawler.BaseCrawler;

@Service
public class BaiduCrawler extends BaseCrawler {


	public String testSelenium() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		
		// Applied wait time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize window
		driver.get("http://www.baidu.com/");
		// driver.manage().window().maximize();
		String titile = driver.getTitle();

		System.out.println("title is => " + titile);

		// Click on the search text box and send value
		driver.findElement(By.id("kw")).sendKeys("易百教學");

		// Click on the search button
		driver.findElement(By.id("su")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.quit();

		return null;
	}
}
