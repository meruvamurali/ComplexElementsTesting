package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownListTesting {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.wikipedia.org/");
		
		//driver.findElement(By.id("searchLanguage")).sendKeys("Deutsch");
		
		Select drpLan = new Select(driver.findElement(By.id("searchLanguage")));
		//drpLan.selectByVisibleText("Deutsch");
		
		drpLan.selectByValue("hi");
		
		List<WebElement> optionList = driver.findElements(By.tagName("option"));
		
		System.out.println("Total number of options in the Languages dropdownn is : " +optionList.size());
		
		System.out.println("Language \t Text");
		
		for(int i=0; i<optionList.size();i++) {
			System.out.print(optionList.get(i).getAttribute("lang"));
			System.out.print("\t");
			System.out.print(optionList.get(i).getText());
			System.out.println();
		}
		
		//driver.quit();
		

	}

}
