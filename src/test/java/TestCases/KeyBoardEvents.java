package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class KeyBoardEvents {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement name = driver.findElement(By.name("name"));
		
		name.sendKeys("Murali Krishna");
		driver.findElement(By.name("phone")).sendKeys("787878787");
		
		WebElement email = driver.findElement(By.name("email"));
		
		name.sendKeys(Keys.CONTROL + "a");
		name.sendKeys(Keys.CONTROL + "c");
		email.sendKeys(Keys.CONTROL + "v");
			
	}

}
