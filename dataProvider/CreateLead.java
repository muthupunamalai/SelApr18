package leaf.Lead;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods{
	@BeforeClass
	public void excelSheet() {
		excelFileName="TC001";
	}

	@Test( dataProvider = "fetchData")
	public void createLead(String cName, String fName, String lName, String phNo) {	
		click(locateElement("link", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cName);
		type(locateElement("id", "createLeadForm_firstName"), fName);
		type(locateElement("id", "createLeadForm_lastName"), lName);
		type(locateElement("id", "createLeadForm_primaryEmail"), "gopinath@testleaf.com");
		type(locateElement("id", "createLeadForm_primaryPhoneNumber"), phNo);
		click(locateElement("name", "submitButton"));
	}
		
	
	
	
	
	
	
	
	
}












