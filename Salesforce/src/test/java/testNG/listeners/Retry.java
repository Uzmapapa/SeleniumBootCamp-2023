package testNG.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	private int count =0;
	private int max=2;
	public boolean retry(ITestResult result)
 {
		if(count<max) {
			count++;
			return true;
		}
		return false;
	}
	
}
