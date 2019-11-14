package com.atmecs.constants;

import java.io.File;

public class ConstantsFilePaths {
	/*
	 * In this class,all required paths are made
	 */

	public final static String homeDir = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = homeDir + "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator;

	public final static String LIB_HOME = homeDir + "lib" + File.separator;

	public final static String CHROME_FILE = LIB_HOME + "chromedriver.exe";

	public final static String FIREFOX_FILE = LIB_HOME + "geckodriver.exe";

	public final static String IE_FILE = LIB_HOME + "IEDriverServer.exe";

	public final static String CONFIG_FILE = RESOURCES_HOME + "config" + File.separator + "config.properties";

	public static final String LOCATOR_FILE = RESOURCES_HOME + "locators" + File.separator + "locators.properties";

	public final static String TESTDATA_FILE = RESOURCES_HOME + "testData" + File.separator + "testdata.properties";

	public final static String LOG4J_FILE = RESOURCES_HOME + "log4j" + File.separator + "log4j.properties";

	public final static String TESTDATA_FILE1 = RESOURCES_HOME + "testData" + File.separator + "inputs-ninja-store.xlsx";

	public final static String EXTENT_REPORTFILE = "entendreport.html";
}
