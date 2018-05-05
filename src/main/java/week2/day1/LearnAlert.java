package week3.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException, IOException  {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.findElementById("userRegistrationForm:checkavail").click();
		
		Alert myAlert = driver.switchTo().alert();
		
		String text = myAlert.getText();
		System.out.println(text);
		myAlert.sendKeys("hello");
		
		myAlert.accept();
		driver.findElementById("userRegistrationForm:userName").sendKeys("username");
		












	}

}
