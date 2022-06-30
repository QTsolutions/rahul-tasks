package seleniumSampleTests;

import java.io.File;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class GoogleSearch {
	
	WebDriver driver;
	
    String url = "https://www.google.co.in/";
    
   
	//Method used to check the Operating system on which user will run this class
	
	public void oscheck(String browser) throws InterruptedException {

		if (System.getProperty("os.name").contains("Window")) {
			Reporter.log("Browser selected is : "+browser+" for OS : Windows",true);
			openbrowser(browser, ".exe");

		} else if (System.getProperty("os.name").contains("Mac")) {
			Reporter.log("Browser selected is : "+browser+" for OS : Mac", true);
			openbrowser(browser, "");

		} else if (System.getProperty("os.name").contains("Linux")) {
			Reporter.log("Browser selected is : "+browser+" for OS : Linux",true);
			openbrowser(browser, "");
		}
	}

	//Method used to check the browser on which user will run this class
	
	@Parameters({ "browser" })
	public void openbrowser(String browser, String extension) throws InterruptedException {

		try {
			
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("chrome browser testing started : ");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "drivers" + File.separator + "chromeDriver" + File.separator + "chromedriver" + extension);
				driver = new ChromeDriver();
			
			} if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("FireFox browser testing started : ");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "fireFoxDriver"
								+ File.separator + "geckoDriver" + File.separator + "geckodriver" + extension);
				driver = new FirefoxDriver();
			
			} if (browser.equalsIgnoreCase("Edge")) {
				System.out.println("Edge browser testing started : ");
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "edgeDriver"
								+ File.separator + "edgeDriver" + File.separator + "msedgedriver" + extension);
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	
	//Method used to call oscheck method
	
	@Parameters({ "browser" })
	@BeforeClass
	public void driverinitialisation(String browser) throws InterruptedException {
		oscheck(browser);
		
	}
	
	//method used to perform basic test through selenium
	
	@Parameters({"browser"})
	@Test
	public void basic() {
		
		//implementiong implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		Reporter.log("Browser launched is with URL : "+url, true);
		
		//implementing explicit wait(webdriverwait)
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@title='Search']")));
		WebElement googlesearch = driver.findElement(By.xpath("//input[@title='Search']"));
		googlesearch.sendKeys("airindia");
		googlesearch.sendKeys(Keys.ENTER);
		Reporter.log("User enter the keyword 'airindia' in search box of Google",true);
		
	}
	

}
