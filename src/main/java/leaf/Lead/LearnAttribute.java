package leaf.Lead;

import org.testng.annotations.Test;

public class LearnAttribute {
	
	//@Test(priority=-99)
	@Test
	public void duplicateLead() {
		System.out.println("duplicateLead");
	}
	@Test()
	public void createLead() {
		System.out.println("createLead");
		throw new RuntimeException();
	}
	//@Test(priority=2)
	//@Test(dependsOnMethods= {"leaf.Lead.LearnAttribute.duplicateLead"})
	@Test(enabled=false,alwaysRun=true)
	public void editLead() {
		System.out.println("editLead");		
	}	
	@Test(dependsOnMethods= {"leaf.Lead.LearnAttribute.createLead"},alwaysRun=true)
	public void mergeLead() {
		System.out.println("mergeLead");		
		
		
		
		
		
		
		
		
	}

}
