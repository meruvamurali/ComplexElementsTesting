package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorExample {
	
	public static WebDriver driver;
	
	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		String fileName = "JavaScriptExecutor_" + d.toString().replace(":", "_").replace(" ", "_")+ ".jpg";
			
		System.out.println(fileName);
			
		String folderName = "";
			
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMM_dd");
			
		folderName = sdf.format(d);
		System.out.println(folderName);
			
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+folderName+"//"+fileName));
			
		}
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");
		
	//	driver.findElement(By.xpath("/html/body/button")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("myFunction()");
		
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
		
		captureScreenshot();
		

	}

}
