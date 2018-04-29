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

public class LearnReportersBasics {	


	public void beforeSuite() throws IOException {
		
		ExtentHtmlReporter html = new ExtentHtmlReporter(new File("./snaps/result.html"));
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();		
		extent.attachReporter(html);	
	
		ExtentTest test = extent.createTest("TC001_CreateLead", "Create a new Lead");
		test.assignAuthor("Raji");
		test.assignCategory("Smoke");	
	
		test.pass("The data DemoSalesManager is entered Successfully",
				MediaEntityBuilder.createScreenCaptureFromPath("./snaps/imgName1.png").build());
		
		test.pass("The data crmsfa is entered Successfully",
				MediaEntityBuilder.createScreenCaptureFromPath("./snaps/imgName2.png").build());
		
		test.pass("The Element Login is clicked successfully",
				MediaEntityBuilder.createScreenCaptureFromPath("./snaps/imgName3.png").build());
		
		
		extent.flush();
	}
}
