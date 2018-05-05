package wdMethods;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods{

	public static RemoteWebDriver driver = null;
	int i = 1;
	Actions builder;
	/**
	 * This method will launch the given browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @author Babu - TestLeaf
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * 		 * 
	 */
	public void startApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--disable-notifications");
				driver = new ChromeDriver(op);
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);		
			System.out.println("The browser "+browser+" is launched");
		} catch (NoSuchElementException e) {
			System.err.println(" Element is Not present");
			
		} catch( WebDriverException e) {
			System.err.println(" Driver is not found");
		}
		finally {
		//takeSnap();
	}
	}
	public WebElement locateElement(String locator, String locValue) {
		WebElement element = null;
		try {
			switch (locator) {
			case "id":element = driver.findElementById(locValue);			
			break;
			case "class":element = driver.findElementByClassName(locValue);			
			break;
			case "name":element = driver.findElementByName(locValue);			
			break;
			case "xpath":element = driver.findElementByXPath(locValue);			
			break;
			case "link":element = driver.findElementByLinkText(locValue);			
			break;
			case "partialtext":element = driver.findElementByPartialLinkText(locValue);			
			break;
			}
		} catch (NoSuchElementException e) {
			System.err.println(" Element is not found");
		} catch( WebDriverException e) {
			System.err.println(" Driver is not found");
		}
		finally {
		takeSnap();
	}
		return element;
	}
	public List<WebElement> locateElements(String locator, String locValue) {
		List<WebElement> element = null;
		try {
			switch (locator) {
			case "id":element = driver.findElementsById(locValue);			
			break;
			case "class":element = driver.findElementsByClassName(locValue);			
			break;
			case "name":element = driver.findElementsByName(locValue);			
			break;
			case "xpath":element = driver.findElementsByXPath(locValue);			
			break;
			case "linktext":element = driver.findElementsByLinkText(locValue);			
			break;
			case "partialtext":element = driver.findElementsByPartialLinkText(locValue);			
			break;
			}
		} catch (NoSuchElementException e) {
			System.err.println(" Element is not found");
		} catch( WebDriverException e) {
			System.err.println(" Driver is not found");
		}
		finally {
		takeSnap();
	}
		return element;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The text field is entered with "+data);
		} catch (NoSuchElementException e) {
			System.err.println(" Element is not found");
		}catch(WebDriverException e) {
			System.err.println(" Driver is not found");
		}
		finally {
			takeSnap();
		}
	}
	public void typeEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.ENTER);
			System.out.println("The text field is entered with "+data);
		} catch (NoSuchElementException e) {
			System.err.println(" Element is not found");
		}catch(WebDriverException e) {
			System.err.println(" Driver is not found");
		}
		finally {
			takeSnap();
		}
	}


	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The button/link is clicked");
			takeSnap();
		} catch (NoSuchElementException e) {
			System.err.println(" Element is not found");
		}catch(WebDriverException e) {
			System.err.println(" Driver is not found");
		}
		finally {
			takeSnap();
		}	
		
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			ele.click();
			System.out.println("The element:"+text+" is clicked");
		} catch (InvalidElementStateException e) {
			System.err.println("The element: "+text+" is not interactable");
			throw new RuntimeException();
		} }

	public String getText(WebElement ele) {
		String data;
		try {
			data = ele.getText();
		} catch (NoSuchFrameException e) {
			System.err.println("Element is not found");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
		return data;
	}
	
	public String getTitle() {
		String data;
		try {
			data = driver.getTitle();
		
		} catch (NoSuchFrameException e) {
			System.err.println("Element is not found");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
		return data;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select src = new Select(ele);
			src.selectByVisibleText(value);
			System.out.println("The dropdown is selected with index "+value);
		} catch (WebDriverException e) {
			System.err.println("The dropdown could not be selected with index "+value);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select src = new Select(ele);
		/*	List<WebElement> options = src.getOptions();*/
			src.selectByIndex(index);
			System.out.println("The dropdown is selected with index "+index);
		} catch (WebDriverException e) {
			System.err.println("The dropdown could not be selected with index "+index);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}}

	public boolean verifyTitle(String expectedTitle) {
        try {
			String text= driver.getTitle();
			if(text.equals(expectedTitle)) {
				System.out.println("The expected title matches the actual "+expectedTitle);
			}else {
				System.err.println("The expected title doesn't matches the actual "+expectedTitle);
			}
		} catch (NoSuchElementException e) {
			System.err.println("No element is fount");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				System.out.println("The expected text matches the actual "+expectedText);
			}else {
				System.err.println("The expected text doesn't matches the actual "+expectedText);
			}
		} catch (NoSuchElementException e) {
			System.err.println("No element is fount");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}

	}
	public void Actions(WebElement ele) {
		//System.out.println(ele);
		Actions builder =new Actions(driver);
		builder.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).click(ele).perform();
		builder.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).release();
		//driver.getTitle();
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				System.out.println("The expected text contains the actual "+expectedText);
			}else {
				System.err.println("The expected text doesn't contain the actual "+expectedText);
			}
		} catch (NoSuchElementException e) {
			System.err.println("No element is fount");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}

	}
	public String getAttribute(WebElement ele, String value) {
		try {
			String attribute="";
			 attribute = ele.getAttribute(value);
			//String attribute2 = driver.findElementById("").getAttribute("");
		System.out.println(attribute);

		return attribute;
			
		} catch (NoSuchElementException e) {
			System.err.println("No element is fount");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
	}
	
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String att=ele.getAttribute(attribute);
			if(att.contains(value)) {
				System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
			}else {
				System.err.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("No element is fount");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
	}
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String arb=ele.getAttribute(value);
			if(arb.contains(value)) {
				System.out.println("The expected attribute :"+attribute+" value contains the actual "+value);
			}else {
				System.err.println("The expected attribute :"+attribute+" value does not contains the actual "+value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("No element is fount");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				
				System.out.println("The element "+ele+" is selected");
			} else {
				System.err.println("The element "+ele+" is not selected");
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element is not Found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}
	
	public void ClickCheckbox(WebElement ele) {
		if(!ele.isSelected()) {
			ele.click();
	}/*else {
		System.err.println("The element "+ele+" is not selected");
	}*/
	}
    public void verifyDisplayed(WebElement ele) {
    	try {
			if(ele.isDisplayed()) {
				System.out.println("The element "+ele+" is visible");
			} else {
				System.err.println("The element "+ele+" is not visible");
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element is not Found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("The driver could not moveing to the given window  "+index);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			System.err.println("Frame is Not Present");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.err.println("Alert is Not present");
		}catch (UnhandledAlertException e) {
			System.err.println("Alert is Not handled");
		    throw new RuntimeException();
		    }finally {
		    	takeSnap();
		    	}
		    }

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert is dismissed");
		} catch (NoAlertPresentException e) {
			throw new RuntimeException();
		}finally {
			takeSnap();
		}

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.err.println("There is no alert present.");
		}
		return text;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;		

	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("The browser is closed");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All the browsers are closed");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	public void openInNewTab(WebElement ele) {
		builder = new Actions(driver);
		ele.click();
		builder.sendKeys(Keys.CONTROL).click(ele).perform();
	}
	
	public void moveToElement(WebElement ele) {
		builder = new Actions(driver);
		builder.moveToElement(ele).perform();
	}
	public void moveToElementAndClick(WebElement ele) {
		builder = new Actions(driver);
		builder.moveToElement(ele).click().perform();
	}
	public WebElement locateElement(String locValue) {
		WebElement element = driver.findElementById(locValue);
		return element;
	}
 public String replaceAll(String data) {
	 String replace = data.replaceAll("\\D", "");
	return replace;
	 
 }
}