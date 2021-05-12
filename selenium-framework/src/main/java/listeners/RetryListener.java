package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import enums.ConfigProperties;
import utils.PropertyFileUtils;

public class RetryListener implements IRetryAnalyzer {

	private int retry = 0;
	private int maxRetry;

	@Override
	public boolean retry(ITestResult result) {
		maxRetry = Integer.parseInt(PropertyFileUtils.getValue(ConfigProperties.RETRYCOUNT));
		if (PropertyFileUtils.getValue(ConfigProperties.RETRYCHECK).equalsIgnoreCase("Yes") && retry < maxRetry) {
			retry++;
			return true;
		}
		return false;
	}

}
