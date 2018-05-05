package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
//	@Test(invocationCount=2, threadPoolSize=2)
	//@Test(invocationCount=2 ,invocationTimeOut=45000)
//	@Test(invocationCount=2 ,timeOut = 20000)
	//@Test(expectedExceptions= {NoSuchElementException.class})
	@Test(invocationCount=10,successPercentage=80)
	public void main() throws InterruptedException   {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    try {
			driver.findElementById("username").sendKeys("DemoSalesManager1");
		} catch (NoSuchElementException e1) {
			//e1.printStackTrace();
			System.err.println("the Username1 not found");
		}
	    driver.findElementById("password").sendKeys("crmsfa");
	    driver.findElementByClassName("decorativeSubmit").click();
	    Thread.sleep(3000);
	  //  driver.findElementByClassName("decorativeSubmit").click();
	    driver.findElementByLinkText("CRM/SFA").click();
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByLinkText("Create Lead").click();
	    driver.findElementById("createLeadForm_companyName").sendKeys("TL");
	    driver.findElementById("createLeadForm_firstName").sendKeys("Gopi");
	    driver.findElementById("createLeadForm_lastName").sendKeys("J");
	    driver.findElementByClassName("smallSubmit").click();
	    driver.close();
		/*File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img.png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		//NoSuchElementException
		driver.close();*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
