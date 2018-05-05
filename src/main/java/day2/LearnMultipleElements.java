package day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnMultipleElements {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://www.crystalcruises.com/cruises/calendar?year=2018");
		
		Thread.sleep(5000);
		
		List<WebElement> allQuotes = driver.findElementsByLinkText("REQUEST A QUOTE");
		int count = allQuotes.size();
		System.out.println(count);
		
		for (WebElement eachQuote : allQuotes) {
			System.out.println(eachQuote.getText());
		}
				
		WebElement secondEle = allQuotes.get(1);
		secondEle.click();
		
		
		
		
		
		
		
		
		
	}

}



