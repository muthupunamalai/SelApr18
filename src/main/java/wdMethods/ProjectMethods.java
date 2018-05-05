package wdMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import leaf.Lead.ReadExcel;

public class ProjectMethods extends SeMethods{
	public String excelFileName = "";

	@Parameters({"url","password", "userName"})
	@BeforeMethod
	public void login(String urlValue, String pwd, String uName) {
		startApp("chrome", urlValue);
		WebElement userName = locateElement("id","username");
		type(userName, uName);
		WebElement passWord = locateElement("id", "password");
		type(passWord, pwd);
		WebElement login = locateElement("class", "decorativeSubmit");
		click(login);

		click(locateElement("link", "CRM/SFA"));
		click(locateElement("link", "Leads"));
	}
	@AfterMethod
	public void closeApp() {
		closeAllBrowsers();

	}

	@DataProvider(name = "fetchData",indices= {1})
	public Object[][] getData() throws IOException {
		ReadExcel excel = new ReadExcel();
		return excel.fetchData(excelFileName);

	}












}
