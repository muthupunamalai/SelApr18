package week2.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException, IOException  {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
	    driver.findElementById("username").sendKeys("DemoSalesManager");
	    driver.findElementById("password").sendKeys("crmsfa");
	    driver.findElementByClassName("decorativeSubmit").click();
	    Thread.sleep(3000);
	    driver.findElementByClassName("decorativeSubmit").click();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img.png");
		FileUtils.copyFile(src, desc);
		
		
		
	}

}
