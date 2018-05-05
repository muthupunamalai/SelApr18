package learnReports;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearnReportersAdvance {	

	public ExtentHtmlReporter html;
	public ExtentReports extent;
	public ExtentTest test;
	public String testCaseName, testDescription, authorName, category;

	@BeforeSuite
	public void beforeSuite() {
		html = new ExtentHtmlReporter(new File("./snaps/result.html"));
		html.setAppendExisting(true);
		extent = new ExtentReports();		
		extent.attachReporter(html);		
	}

	@BeforeTest
	public void setData() {
		testCaseName = "TC001_CreateLead";
		testDescription = "Create new Lead in Leaf Taps";
		authorName = "Gopinath";
		category = "smoke";				
	}

	@BeforeClass
	public ExtentTest startTest() {
		ExtentTest test = extent.createTest(testCaseName, testDescription);
		return test;
	}

	@BeforeMethod
	public void beforeMethod() {		
		test.assignAuthor(authorName);
		test.assignCategory(category);	
	}

	public void reportStep(String desc, String status) throws IOException {

		MediaEntityModelProvider img = MediaEntityBuilder.createScreenCaptureFromPath("./snaps/imgName.jpe").build();

		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);
		}else if (status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
		}else if (status.equalsIgnoreCase("WARNING")) {
			test.warning(desc, img);
		}else if (status.equalsIgnoreCase("INFO")) {
			test.info(desc);
		}

	}


	public void afterMethod() {	
		extent.flush();
	}
}
