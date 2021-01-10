package org.test.execution;

import org.flipkart.utils.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.tets.paefactory.Homepage;

public class HomePageExe extends Homepage {

	
	@Test(groups= {"smoke"})
	public void smoke() {
		System.out.println("my first test");
	}
	
	@Test(groups= {"sanity","smoke"})
	public void sanity() {
		System.out.println("my first test");
	}
	
	@Test(groups= {"regression"}, dataProvider="testdata")
	public void regression(String data, String data2) {
		System.out.println(data);
		System.out.println(data2);
	}

	/*@DataProvider(name ="testdata")
	public String[][] data(){
		return (ExcelUtil.dataexcel());
	}*/

	@DataProvider(name ="testdata", parallel=true)
	public Object[][] data1(){
		return new Object[][] {{"username","password"},{"maha","vedha"}};
	}

}
