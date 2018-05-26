package testcases;

import org.junit.Test;

import org.openqa.selenium.WebElement;

import wdMethods.SeMethods;
public class LogInAndLogOut extends SeMethods{
	@Test
	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement uName = locateElement("id", "username");
		type(uName, "DemoSalesManager");
		WebElement pwd = locateElement("id", "password");
		type(pwd, "crmsfa");
		WebElement loginButton = locateElement("class", "decorativeSubmit");
		click(loginButton);
		}
	
	

}
