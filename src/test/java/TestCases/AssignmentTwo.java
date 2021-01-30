package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://timesofindia.indiatimes.com/india/poll.cms");
		
		WebElement mathQues = driver.findElement(By.xpath("//*[@id='mathq2']"));
		
		String ques = mathQues.getText();
		
		System.out.println(ques);
		
		String[] str = ques.split(" ");
			
		int firstNum = Integer.parseInt(str[0]);
		int secondNum = Integer.parseInt(str[2]);
		
		System.out.println(firstNum);
		System.out.println(secondNum);
		System.out.println(str[1]);
		
		Integer cal=0;
		
		if(str[1].equals("+")) {
			cal = firstNum + secondNum;
			System.out.println("Addition");
		}
		else if(str[1].equals("-")) {
			cal = firstNum - secondNum;
			System.out.println("Subtraction");
		}
		else if(str[1].equals("*")) {
			cal = firstNum * secondNum;
			System.out.println("Multiplication");
		}
		else if(str[1].equals("/")) {
			cal = firstNum / secondNum;
			System.out.println("Division");
		}
		
		driver.findElement(By.xpath("//*[@id='mathuserans2']")).sendKeys(cal.toString());
		
		System.out.println(cal.toString());
		
		//driver.quit();

	}

}
