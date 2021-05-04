package listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import utils.ExcelUtils;

public class MethodListener implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> methodsToBeExecuted = new ArrayList<>();
		List<Map<String, String>> excelMappedInList = ExcelUtils.getTestMethodDetails();
		
		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < excelMappedInList.size(); j++) {
				if (methods.get(i).getMethod().getMethodName()
						.equalsIgnoreCase(excelMappedInList.get(j).get("TestName"))) {
					if (String.valueOf(excelMappedInList.get(j).get("Execute")).equalsIgnoreCase("Yes")) {
						methods.get(i).getMethod()
								.setInvocationCount(Integer.parseInt(String.valueOf(excelMappedInList.get(j).get("Count").charAt(0))));
						methods.get(i).getMethod().setDescription(excelMappedInList.get(j).get("TestDescription"));
						methods.get(i).getMethod()
								.setPriority(Integer.parseInt(String.valueOf(excelMappedInList.get(j).get("Priority").charAt(0))));
						methodsToBeExecuted.add(methods.get(i));
						break;
					}
				}
			}
		}
		return methodsToBeExecuted;
	}

}
