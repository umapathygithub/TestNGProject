package org.test.execution;

import java.util.Date;

import org.flipkart.utils.RetryAnalyser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.DataProviderAnnotation;
import org.tets.paefactory.Homepage;

public class HomePageExe2 extends Homepage {

	@Parameters({"mango","orange"})
	@Test
	public void executeo0(String mango, String orange) {
		Date d = new Date();
		System.out.println(d);
		System.out.println(mango);
		System.out.println(orange);
	}
	
	@Test(groups= {"regression"})
	public void executeo420() {
		Assert.assertTrue(false);
	}
	@Test(groups= {"regression"}, dataProvider = "testdata",dataProviderClass=HomePageExe.class )
	public void regression1(String data, String data2) {
		System.out.println(data);
		System.out.println(data2);
	}
}
