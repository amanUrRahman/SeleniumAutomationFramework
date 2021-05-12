package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	private static FileInputStream file;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;

	static {

		try {
			file = new FileInputStream(FrameworkConstants.getExcelpath());
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static List<Map<String, String>> getTestDetails(String SheetName) {
		int lastRowNum, lastColNum;
		List<Map<String, String>> excelMappedInList = new ArrayList<>();
		Map<String, String> excelEntries = null;
		sheet = workbook.getSheet(SheetName);
		lastRowNum = sheet.getLastRowNum();
		lastColNum = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= lastRowNum; i++) {
			excelEntries = new HashMap<>();
			for (int j = 0; j < lastColNum; j++) {
				String key = String.valueOf(sheet.getRow(0).getCell(j).getStringCellValue());
				String value = null;
				switch (sheet.getRow(i).getCell(j).getCellType()) {
				case STRING:
					value = sheet.getRow(i).getCell(j).getStringCellValue();
					break;
				case NUMERIC:
					value = String.valueOf(String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue()).split(".0")[0]);
					break;
				case BOOLEAN:
					value = String.valueOf(sheet.getRow(i).getCell(j).getBooleanCellValue());
					break;
				default:
					break;
				}
				excelEntries.put(key, value);
			}
			excelMappedInList.add(excelEntries);
		}
		return excelMappedInList;
	}

}
