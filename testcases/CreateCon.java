package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateCon {

	//@Test(invocationCount=2,threadPoolSize=2)
	//@Test(invocationCount=2,invocationTimeOut=40000)
	//@Test(invocationCount=2,timeOut=40000)
	@Test(successPercentage=80)
	public void createCon() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoCSR");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("kumar");
		driver.findElementById("lastNameField").sendKeys("none");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("kumar");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("none");
		driver.findElementById("createContactForm_personalTitle").sendKeys("demotitle");
		driver.findElementById("createContactForm_departmentName").sendKeys("retail");
		driver.findElementById("createContactForm_accountPartyId").sendKeys("demoaccount");
		driver.findElementById("createContactForm_description").sendKeys("demo describtion");
		driver.findElementById("createContactForm_importantNote").sendKeys("demo important");
		driver.findElementById("createContactForm_primaryPhoneCountryCode").sendKeys("91");
		driver.findElementById("createContactForm_primaryPhoneExtension").sendKeys("044");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("jai@gmail.com");
		driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("98762345");
		driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("job");
		driver.findElementById("generalToNameField").sendKeys("raj");
		driver.findElementById("createContactForm_generalAttnName").sendKeys("kumar");
		driver.findElementById("createContactForm_generalAddress1").sendKeys("no:1,anna nager");
		driver.findElementById("createContactForm_generalAddress2").sendKeys("no:2,anna nager");
		driver.findElementById("createContactForm_generalCity").sendKeys("chennai");
		driver.findElementById("createContactForm_generalPostalCode").sendKeys("600011");
		driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("6");
		driver.findElementById("createContactForm_generalProfTitle").sendKeys("DemoTitele");
		driver.findElementById("createContactForm_primaryPhoneAreaCode").sendKeys("44");
		WebElement element=driver.findElementById("createContactForm_preferredCurrencyUomId");
		Select dropdown=new Select(element);
		dropdown.selectByValue("INR");
		WebElement element1=driver.findElementById("createContactForm_generalCountryGeoId");
		Select dropdown1=new Select(element1);
		dropdown1.selectByValue("IND");
		Thread.sleep(5000);
		WebElement element2=driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select dropdown2=new Select(element2);
		dropdown2.selectByVisibleText("TAMILNADU");
		
		
		driver.findElementByClassName("smallSubmit").click();
	driver.close();
		
		
	}
}
