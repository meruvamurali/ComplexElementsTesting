package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingJQuerySliders {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//slider is on the iFrame, we cannot perform any actions on slider directly
		//first we need to move to iFrame
		
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(size);
		
		driver.switchTo().frame(0);
		
		
		WebElement slider = driver.findElement(By.id("slider"));
		
		int width = slider.getSize().getWidth();
		
		width = (int) (width*0.75);
		
		WebElement sliderSpan = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDropBy(sliderSpan, width, 0).perform();
		
		driver.switchTo().defaultContent();
		
		driver.quit();

	}

}
