package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//find the total no of rows
		List<WebElement> rowsTotal = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		
		System.out.println("Total number of rows : " +rowsTotal.size());
		
		//find the total no of cols
		List<WebElement> colsTotal = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		
		System.out.println("Total number of columns : " +colsTotal.size());
		
		for(int row=1; row<=rowsTotal.size(); row++) {
			
			for(int col=1; col<=colsTotal.size(); col++) {
				
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+row+"]/td["+col+"]")).getText() + "   ");
			}
			
			System.out.println();
		}
		
		driver.quit();

	}

}
