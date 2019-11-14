package com.atmecs.validation;

import org.testng.Assert;

import com.atmecs.logreports.LogReports;

public class ValidationResult {
	/*
	 * It shows final output present in the console
	 */
	static LogReports report = new LogReports();

	public static boolean validateData(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			report.info("Passed : " + message + " : " + " Actual data : " + actual + " Expected data : " + expected);
			return true;
		} catch (AssertionError assertionError) {
			report.info("failed : " + message + " : " + " Actual data : " + actual + " Expected data : " + expected);
			return false;
		}
	}
}
