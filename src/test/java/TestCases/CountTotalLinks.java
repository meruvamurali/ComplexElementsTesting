package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountTotalLinks {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.wikipedia.org/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total No of Links on the page : " + links.size());
		/*
		for(WebElement link : links) {
			
			System.out.println("URL : " + link.getAttribute("href"));
			
		}
		*/
		//findout the links under specific block
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		
		List<WebElement> blockLinks = block.findElements(By.tagName("a"));
		
		System.out.println("Total No of Links under the block : " +blockLinks.size());
		
		for(WebElement link : blockLinks) {
			System.out.println(link.getText() + "\t URL : " + link.getAttribute("href"));
		}
		
		driver.quit();
		
	}

}
