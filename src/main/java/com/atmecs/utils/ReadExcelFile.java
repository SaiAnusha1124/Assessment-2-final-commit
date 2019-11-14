package com.atmecs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.atmecs.logreports.LogReports;

public class ReadExcelFile {
	/*
	 * In this class,reading the excel sheet
	 */
	static FileInputStream fileReader;
	static Workbook book;
	static Sheet sheet;
	static LogReports log = new LogReports();

	public Object[][] readExcel(String sheetName, String path)
	// sheet name to fetch data from particular sheet
	{
		@SuppressWarnings("unused")
		FileInputStream file = null;
		try {
			fileReader = new FileInputStream(path);
			// set test data excel file as testData_path in // constants class

		} catch (FileNotFoundException e) {
			log.info("file not found");
		}
		try {
			book = WorkbookFactory.create(fileReader);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		// Read Every rows,columns and pass value to data provider

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
