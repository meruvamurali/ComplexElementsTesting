package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Handling Multiple check boxes under a specific section
		WebElement section1 = driver.findElement(By.xpath("//div[4]"));
		
		List<WebElement> chkBoxes1 = section1.findElements(By.name("sports"));
		
		System.out.println("No of Checkboxes under section1 : " + chkBoxes1.size());
		
		for(WebElement chkBox : chkBoxes1) {
			
			chkBox.click();
		}
		
		//Handling a specific check box under a specific section
		WebElement section2 = driver.findElement(By.xpath("//div[6]"));
		
		List<WebElement> chkBoxes2 = section2.findElements(By.name("sports"));
		
		System.out.println("No of Checkboxes under section2: " + chkBoxes2.size());
		
		for(WebElement chkBox : chkBoxes2) {
			
			if(chkBox.isSelected()) {
				System.out.println(chkBox.getAttribute("value") + " is selected");
				chkBox.click();
				System.out.println(chkBox.getAttribute("value") + " is cleared");
			}
			else {
				System.out.println(chkBox.getAttribute("value") + " is NOT selected");
				chkBox.click();
				System.out.println(chkBox.getAttribute("value") + " is selected");
			}
		}

	}

}
