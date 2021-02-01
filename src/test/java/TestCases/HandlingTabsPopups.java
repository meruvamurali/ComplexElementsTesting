package TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabsPopups {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String windowName = "";
		
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//First Window
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowIds = driver.getWindowHandles();
		
		Iterator<String> iter = windowIds.iterator();
		
		while(iter.hasNext()) {
			windowName = iter.next();
			System.out.println(windowName);
			
			driver.switchTo().window(windowName);
			if(!driver.getTitle().contains("Job Search")) {
				System.out.println(windowName);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul[1]/li[2]/a/div")).click();
		
		System.out.println("********************");
		
		windowIds = driver.getWindowHandles();
		iter = windowIds.iterator();
		
		while(iter.hasNext()) {
			windowName = iter.next();
			System.out.println(windowName);
			
			driver.switchTo().window(windowName);
			if(driver.getTitle().contains("HR Manager")) {
				System.out.println(driver.getTitle());
				break;
			}
		}
		
		driver.findElement(By.name("qp")).sendKeys("Testing");
		driver.findElement(By.id("qsbFormBtn")).click();
		driver.close();
		
		driver.switchTo().window(parentWindow);
			
		
	}

}
