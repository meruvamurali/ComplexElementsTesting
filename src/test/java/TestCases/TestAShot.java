package TestCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestAShot {
	
	public static WebDriver driver;
	public static String folderName = "";
	public static String fileName = "";
	
	public static void captureFileNamePath() {
		
		Date d = new Date();
		fileName = "AShot_" + d.toString().replace(":", "_").replace(" ", "_");
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMM_dd");
			
		folderName = sdf.format(d);
					
		}

	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Take one page screenshot
		//Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//BufferedImage image = screenshot.getImage();
		
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		BufferedImage image = screenshot.getImage();
		captureFileNamePath();
		
		ImageIO.write(image, "png", new File(".\\screenshot\\"+folderName+"//"+fileName+"_onepage.png"));
		
		//Take long page screenshot
		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		image = screenshot.getImage();
		
		captureFileNamePath();
				
		ImageIO.write(image, "png", new File(".\\screenshot\\"+folderName+"//"+fileName+"_fullpage.png"));	
		
		//Take particular element screenshot
		WebElement element = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]"));
		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);
		image = screenshot.getImage();
		
		captureFileNamePath();
				
		ImageIO.write(image, "png", new File(".\\screenshot\\"+folderName+"//"+fileName+"_element.png"));
		
		
	}

}
