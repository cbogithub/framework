package com_movii_commons;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer{

	int counter=0;
	int maxRetryCount=2;

	@Override
	public boolean retry(ITestResult result) {
		if(counter<maxRetryCount){
			counter++;
			return true;
		}
		return false;
	}
}
