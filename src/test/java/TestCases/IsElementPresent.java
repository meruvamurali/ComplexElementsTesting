package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsElementPresent {
	
	public static WebDriver driver;
	
	public static boolean isElementPresentXpath(String xPath) {
		
		try {
			driver.findElement(By.xpath(xPath));
			return true;
		}catch(Throwable t) {
			return false;
		}
		
	}
	
	public static boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}
		
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.wikipedia.org/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println(isElementPresentXpath("//*[@id=\"searchInput\"]"));
		
		System.out.println(isElementPresent(By.id("searchInput1")));

		driver.quit();

	}

}
