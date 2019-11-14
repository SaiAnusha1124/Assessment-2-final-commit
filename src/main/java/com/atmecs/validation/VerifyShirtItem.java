package com.atmecs.validation;

import java.util.Properties;
import org.openqa.selenium.By;
import com.atmecs.actions.ClickOnElementAction;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.helpers.LocatorType;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.ReadLocatorsFile;

public class VerifyShirtItem extends TestBase {
	static String actualhomepage, actualshirtsize, actualname, actualshirtcolor, actualprice, actualtotal,
			actualtotalafterupdate, actualitemname, actualmensactualhomepage, actualhotsauce, actualmerchandise,
			actualclearance, actualnewtohotsauce, actualfaq;
	static Properties properties;
	static Properties properties1;
	static ClickOnElementAction click = new ClickOnElementAction();

	public static void validatingProduct() {
		// locators are reading through LOCATOR_FILE
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		// expected data are reading through TESTDATA_FILE
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);

		actualitemname = driver.findElement(By.xpath((properties.getProperty("loc-verify-itemname")))).getText();
		ValidationResult.validateData(actualitemname, properties1.getProperty("expecteditemname"),
				"Verifying item Name");

		actualshirtsize = driver.findElement(By.xpath((properties.getProperty("loc-verify-shirtsize")))).getText();
		ValidationResult.validateData(actualshirtsize, properties1.getProperty("expectedshirtsize"),
				"Verifying Shirt Size");

		actualname = driver.findElement(By.xpath((properties.getProperty("loc-verify-name")))).getText();
		ValidationResult.validateData(actualname, properties1.getProperty("expectedname"), "Verifying Customer Name");

		actualshirtcolor = driver.findElement(By.xpath((properties.getProperty("loc-verify-shirtcolor")))).getText();
		ValidationResult.validateData(actualshirtcolor, properties1.getProperty("expectedshirtcolor"),
				"Verifying Shirt Color");

		actualprice = driver.findElement(By.xpath((properties.getProperty("loc-verify-price")))).getText();
		ValidationResult.validateData(actualprice, properties1.getProperty("expectedprice"), "Verifying Shirt Price");

		actualtotal = driver.findElement(By.xpath((properties.getProperty("loc-verify-total")))).getText();
		ValidationResult.validateData(actualtotal, properties1.getProperty("expectedtotal"), "Verifying Total Amount");
		log.info("Validated Product Details");
	}

	public static void validatingAfterUpdate() {
		actualtotalafterupdate = driver.findElement(By.xpath((properties.getProperty("loc-verify-totalafterupdate"))))
				.getText();
		ValidationResult.validateData(actualtotalafterupdate, properties1.getProperty("expectedtotalafterupdate"),
				"Verifying Total Amount after updating");
		log.info("Completed Selecting Shirt and validating all details");
	}

	public static void testingHomePageTabs() {

		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);

		actualhomepage = driver.findElement(By.xpath((properties.getProperty("loc-verify-homepage")))).getText();
		ValidationResult.validateData(actualhomepage, properties1.getProperty("expectedhomepage1"),
				"Verifying Home Page");
		log.info("Validated Home Page");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-hotsauces"));
		actualhotsauce = driver.findElement(By.xpath((properties.getProperty("loc-click-hotsauces")))).getText();
		ValidationResult.validateData(actualhotsauce, properties1.getProperty("expectedhotsauce"),
				"Verifying Hot Sauce tab");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-merchandise"));
		actualmerchandise = driver.findElement(By.xpath((properties.getProperty("loc-click-merchandise")))).getText();
		ValidationResult.validateData(actualmerchandise, properties1.getProperty("expectedmerchandise"),
				"Verifying Merchandise tab");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-clearance"));
		actualclearance = driver.findElement(By.xpath((properties.getProperty("loc-verify-clearance")))).getText();
		ValidationResult.validateData(actualclearance, properties1.getProperty("expectedclearance"),
				"Verifying Clearance tab");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-newtohotsauce"));
		actualnewtohotsauce = driver.findElement(By.xpath((properties.getProperty("loc-verify-newtohotsauce"))))
				.getText();
		ValidationResult.validateData(actualnewtohotsauce, properties1.getProperty("expectednewtohotsauce"),
				"Verifying New to Hot Sauce tab");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-faq"));
		actualfaq = driver.findElement(By.xpath((properties.getProperty("loc-verify-faq")))).getText();
		ValidationResult.validateData(actualfaq, properties1.getProperty("expectedfaq"), "Verifying FAQ tab");
		log.info("Successfully Validated all tabs in a Home Page");
	}
}
