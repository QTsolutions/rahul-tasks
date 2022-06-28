package seleniumSampleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {
		
		//Setting the property for invoking selenium WebDriver
		System.setProperty("webdriver.chrome.driver",
				"/Users/luv/Desktop/Rahul/Automation/chromedrivers/chromedriver 3");
		WebDriver driver = new ChromeDriver();
		
		//maximising the window
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		WebElement googlesearch = driver.findElement(By.xpath("//input[@title='Search']"));
		googlesearch.sendKeys("airindia");
		googlesearch.sendKeys(Keys.ENTER);
		driver.close();
		
		//Selenium WebDriver has closed the chromebrowser

	}

}
