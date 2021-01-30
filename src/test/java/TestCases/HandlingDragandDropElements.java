package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDragandDropElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println("No of Frames : " + frames.size());
		
		for(WebElement frame: frames) {
			
			if(frame.getAttribute("src").equals("https://jqueryui.com/resources/demos/droppable/default.html")) {
				
				driver.switchTo().frame(frame);
				
			}
		}
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
			
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		
		driver.switchTo().defaultContent();
		
		
		
		

	}

}
