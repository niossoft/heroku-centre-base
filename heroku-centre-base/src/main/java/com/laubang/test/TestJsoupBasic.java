package com.laubang.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class TestJsoupBasic {

	public String testJsoup() throws IOException {
		
		Gson gson = new Gson();
		List<String> jsonStr = new ArrayList<>();
		
		Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
		System.out.println(doc.title());
		jsonStr.add(doc.title());
		
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
			
			jsonStr.add(String.format("%s\n\t%s", headline.attr("title"), headline.absUrl("href")));
		}
		
		return gson.toJson(jsonStr);
	}
	
	public String testSelenium() throws IOException {
		
		// Initiating your chromedriver
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
			e.printStackTrace();
		}
		// driver.quit();

		return null;
	}
}
