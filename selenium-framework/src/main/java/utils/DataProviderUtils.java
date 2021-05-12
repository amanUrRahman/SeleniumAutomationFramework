package utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import constants.FrameworkConstants;

public final class DataProviderUtils {

	private static List<Map<String, String>> testData = new ArrayList<>();

	@DataProvider
	public static Object[] getTestData(Method method) {

		if (testData.isEmpty()) {
			testData = ExcelUtils.getTestDetails(FrameworkConstants.getTestdata());
		}
		List<Map<String, String>> executionList = new ArrayList<>();
		for (Map<String, String> m : testData) {
			if (m.get("TestName").equalsIgnoreCase(method.getName()) && m.get("Execute").equalsIgnoreCase("Yes")) {
				executionList.add(m);
			}
		}
		return executionList.toArray();
	}

}
