package com.atmecs.testbase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.logreports.LogReports;
import com.atmecs.utils.ReadLocatorsFile;
import com.aventstack.extentreports.ExtentReports;

public class TestBase {
	/*
	 * In this class, all drivers are present and browser starts here
	 */
	Properties baseProperty;
	String url;
	String browser;
	String normal;
	public static WebDriver driver;
	public static LogReports log = new LogReports();
	public static ExtentReports extent = new ExtentReports();

	@BeforeTest
	public void initializeBrowser() {
		/*
		 * In this method,multiple browser can be opened as per requirements
		 */
		baseProperty = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		url = baseProperty.getProperty("url");
		// browser = baseProperty.getProperty("browsertype");
		browser = System.getenv("browserName");
		normal = baseProperty.getProperty("normal");
		if (normal.equalsIgnoreCase("normal")) {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ConstantsFilePaths.CHROME_FILE);

				driver = new ChromeDriver();
				log.info("Chrome is Started");

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ConstantsFilePaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox is Started");

			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ConstantsFilePaths.IE_FILE);
				driver = new InternetExplorerDriver();
				log.info("IE is Started");

			}
		} else {
			try {
				driver = TestGridConnection.getDriver(browser);
				System.out.println(browser);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit(); // closes the opened browser and start another browser

	}

}