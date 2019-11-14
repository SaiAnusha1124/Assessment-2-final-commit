package com.atmecs.dataproviders;

import org.apache.poi.ss.usermodel.Sheet;

public class TestDataProviders {
	/*
	 * In this class,data provider is used to read the excel data
	 */

	static Sheet sheet;

	public static Object[][] readExcel(String sheetName, String path) {

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
