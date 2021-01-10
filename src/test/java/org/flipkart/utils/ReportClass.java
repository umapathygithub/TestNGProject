package org.flipkart.utils;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportClass extends Common{
	
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
	
@BeforeTest
public void report() {
	// initialize the HtmlReporter
	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Extendsreport/reportextends.html");
	
	  //initialize ExtentReports and attach the HtmlReporter
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    
    //configuration items to change the look and feel
    //add content, manage tests etc
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setDocumentTitle("Extent Report Demo");
    htmlReporter.config().setReportName("Test Report");
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.DARK);
    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    
}

@Test
public void test_methfail() {
	 test = extent.createTest("test_methfail", "FAILED test case");
	Assert.assertTrue(false);
}


@Test
public void test_methpass() {
	 test = extent.createTest("test_methpass", "PASSED test case");
		Assert.assertTrue(true);
}

@Ignore
@Test
public void test_methskip() {
	 test = extent.createTest("test_methskip", "PASSED test case");
}

@AfterMethod
public void getResult(ITestResult result) throws IOException {
	
    if(result.getStatus() == ITestResult.FAILURE) {
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
        test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build());
    }
    else if(result.getStatus() == ITestResult.SUCCESS) {
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
    }
    else {
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        test.skip(result.getThrowable());
    }
}

@AfterTest
public void tearDown() {
	//to write or update test information to reporter
    extent.flush();
}



    
}
