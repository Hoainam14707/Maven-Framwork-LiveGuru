package com.liveguru.product;

import common.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@Test(retryAnalyzer = Retry.class)
	public void test() {

		String a = driver.getTitle();
		Assert.assertEquals(a, "google");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
