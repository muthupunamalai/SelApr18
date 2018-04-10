package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");		
		ChromeDriver driver = new ChromeDriver();	
		driver.get("https://erail.in/");		
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MAS", Keys.TAB);

		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("SBC", Keys.TAB);

		boolean selected = driver.findElementById("chkSelectDateOnly").isSelected();
		
		if(selected) {
			driver.findElementById("chkSelectDateOnly").click();			
		}
		
		WebElement table = driver.findElementByXPath("//table[@class='DataTable TrainList']");
		
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		
		int rowsCount = allRows.size();
		System.out.println(rowsCount);
		
		//Go to the First row
		WebElement firstRow = allRows.get(0);
		List<WebElement> columns = firstRow.findElements(By.tagName("td"));
		System.out.println(columns.size());
		
		columns.get(1).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}






}