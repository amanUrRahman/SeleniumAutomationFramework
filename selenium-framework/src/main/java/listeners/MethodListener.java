package listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import constants.FrameworkConstants;
import utils.ExcelUtils;

public class MethodListener implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> methodsToBeExecuted = new ArrayList<>();
		List<Map<String, String>> excelMappedInList = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanager());

		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < excelMappedInList.size(); j++) {
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(excelMappedInList.get(j).get("TestName"))
						&& String.valueOf(excelMappedInList.get(j).get("Execute")).equalsIgnoreCase("Yes")) {
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(excelMappedInList.get(j).get("Count")));
					methods.get(i).getMethod().setDescription(excelMappedInList.get(j).get("TestDescription"));
					methods.get(i).getMethod().setPriority(Integer.parseInt(excelMappedInList.get(j).get("Priority")));
					methodsToBeExecuted.add(methods.get(i));
					break;

				}
			}
		}
		return methodsToBeExecuted;
	}

}
