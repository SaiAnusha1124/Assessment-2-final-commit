package com.atmecs.validation;

import java.util.Properties;
import org.openqa.selenium.By;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.ReadLocatorsFile;

public class VerifyProducts extends TestBase {
	static Properties properties;
	static Properties properties1;
	static String actualhomepage, actualstock, productprice, actualextax, actualdescription, actualsubtotal,
			actualecotax, actualvat, actualhomepage2, actualstock2, productprice2, actualextax2, actualdescription2,
			actualcartproduct1, actualcartproduct2, actualgrandtotal, actualgrandtotal1, actualgrandtotal2,
			actualnegativecase;

	public static void verifyingHomePage() {

		try {

			properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
			properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);
			actualhomepage = driver.findElement(By.cssSelector((properties.getProperty("loc-verify-homepage-content"))))
					.getText();
			ValidationResult.validateData(actualhomepage, properties1.getProperty("expectedhomepage"),
					"Verifying Home Page Content");
			log.info("Successfully Validated Home Page");
			log.info("******************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyingFirstProduct() {
		// locators are reading through LOCATOR_FILE
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);

		// expected data are reading through TESTDATA_FILE
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);
		actualstock = driver.findElement(By.xpath((properties.getProperty("loc-verify-availability1")))).getText();
		ValidationResult.validateData(actualstock, properties1.getProperty("expectedstock1"),
				"Verifying availability stock");

		productprice = driver.findElement(By.xpath((properties.getProperty("loc-verify-productprice1")))).getText();
		ValidationResult.validateData(productprice, properties1.getProperty("expectedprice1"),
				"Verifying product price");

		actualextax = driver.findElement(By.xpath((properties.getProperty("loc-verify-extax1")))).getText();
		ValidationResult.validateData(actualextax, properties1.getProperty("expectedextax1"), "Verifying ex tax");

		actualdescription = driver.findElement(By.xpath((properties.getProperty("loc-verify-description1")))).getText();
		ValidationResult.validateData(actualdescription, properties1.getProperty("expecteddescription1"),
				"Verifying product description");
	}

	public static void verifyingSecondProduct() {
		actualstock2 = driver.findElement(By.xpath((properties.getProperty("loc-verify-availability2")))).getText();
		ValidationResult.validateData(actualstock2, properties1.getProperty("expectedstock2"),
				"Verifying availability stock");

		productprice2 = driver.findElement(By.xpath((properties.getProperty("loc-verify-productprice2")))).getText();
		ValidationResult.validateData(productprice2, properties1.getProperty("expectedprice2"),
				"Verifying product price");

		actualextax2 = driver.findElement(By.xpath((properties.getProperty("loc-verify-extax2")))).getText();
		ValidationResult.validateData(actualextax2, properties1.getProperty("expectedextax2"), "Verifying ex tax");

		actualdescription2 = driver.findElement(By.xpath((properties.getProperty("loc-verify-description2"))))
				.getText();
		ValidationResult.validateData(actualdescription2, properties1.getProperty("expecteddescription2"),
				"Verifying product description");
	}

	public static void verifyingCartList() {
		actualcartproduct1 = driver.findElement(By.xpath((properties.getProperty("loc-verify-cartproduct1"))))
				.getText();
		ValidationResult.validateData(actualcartproduct1, properties1.getProperty("expectedcartproduct1"),
				"Verifying cart product 1");

		actualcartproduct2 = driver.findElement(By.xpath((properties.getProperty("loc-verify-cartproduct2"))))
				.getText();
		ValidationResult.validateData(actualcartproduct2, properties1.getProperty("expectedcartproduct2"),
				"Verifying cart product 2");

		actualgrandtotal1 = driver.findElement(By.xpath((properties.getProperty("loc-verify-grandtotal")))).getText();
		ValidationResult.validateData(actualgrandtotal1, properties1.getProperty("expectedgrandtotal"),
				"Verifying cart grand total before removing product");
	}

	public static void afterUpdateGrandTotal() {

		actualgrandtotal2 = driver.findElement(By.xpath((properties.getProperty("loc-click-afterremoveproducttotal"))))
				.getText();
		ValidationResult.validateData(actualgrandtotal2, properties1.getProperty("expectedafterremovegrandtotal"),
				"Verifying after removing grand total");
	}

	public static void verifyingNegativeCase() {
		actualnegativecase = driver.findElement(By.xpath((properties.getProperty("loc-verify-negativecase"))))
				.getText();
		ValidationResult.validateData(actualnegativecase, properties1.getProperty("expectednegativecase"),
				"Verifying after removing grand total");
	}
}
