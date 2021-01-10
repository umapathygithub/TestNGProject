package org.flipkart.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int count=0;
	int retrycount=5;
	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		if (count<retrycount) {
			count++;
			return true;
			
		}
		return false;
	}

}
