package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOne {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("way2automation");
		driver.findElement(By.xpath("//div[2]/div[1]/div[3]/center/input[1]")).click();
		
				
		WebElement block = driver.findElement(By.xpath("//div[@class='eqAnXb']"));
		
		List<WebElement> blockLinks = block.findElements(By.tagName("a"));
		
		System.out.println("Total No of Links under the block : " +blockLinks.size());
		
		blockLinks.get(0).click();
		
		//WebElement link = blockLinks.get(0);
		
		//link.click();
		
		//driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[8]/a")).click();
		
		//As Resource is a mouse over menu, we need to move this element using Actions class
		WebElement menu = driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[8]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
					
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[8]/ul/li[2]/a")))).click();
		
		driver.findElement(By.linkText("Practice site 1")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='load_box']/form/fieldset[1]/input[@type='text']")))).sendKeys("Murali Krishna");
		driver.findElement(By.xpath("//div[@id='load_box']/form/div/div[@class='span_1_of_4']/input[@type='submit']")).click();
			
		//driver.quit();

	}

}
