package com.atmecs.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.atmecs.logreports.LogReports;

public class PerformActionMethods {
	/*
	 * In this class,all perform actions are involved
	 */
	public static LogReports log = new LogReports();
	static WebDriver driver;

	public void selectDropdown(WebDriver driver, String xpath, String visibleText) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public static void clickOnElement(WebDriver driver, String xpath) {
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (ElementNotInteractableException e) {
			log.info("Such Element is Not Present");
		}
	}

	public static void sendKeys(WebDriver driver, String xpath, String value) throws Exception {
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}

	public static void performActionEnter(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public static void sendKeys(Keys enter) {
	}

	public static void explicitWait(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static String getText(String loactor) {
		String text = driver.findElement(By.xpath(loactor)).getText();
		return text;
	}

	public void javaScriptExecutor() {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollTo(0,1000, document.body.scrollHeight)");
	}
}
