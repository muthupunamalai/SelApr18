package week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		Select dd = new Select(country);
		//dd.selectByIndex(5);
		//dd.selectByValue("240");
		dd.selectByVisibleText("Angola");
		List<WebElement> allOptions = dd.getOptions();
		/*for (WebElement eachOption : allOptions) {
			String text = eachOption.getText();
			System.out.println(text);
		}*/
		int size = allOptions.size();
		dd.selectByIndex(size-1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
