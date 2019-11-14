package com.atmecs.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.testbase.TestBase;

public class Waits extends TestBase {
	/*
	 * In this class, waits are using to resolve some errors and bugs
	 */
	public By selectLocator(String locator) {
		By by = null;
		String[] loc = locator.split(",", 2);

		switch (loc[0].toUpperCase()) {
		case "ID":
			by = (By.id(loc[1]));
			break;
		case "NAME":
			by = (By.name(loc[1]));
			break;
		case "CLASS":
			by = (By.className(loc[1]));
			break;
		case "LINKTEXT":
			by = (By.linkText(loc[1]));
			break;
		case "PARTIAL":
			by = (By.partialLinkText(loc[1]));
			break;
		case "CSS":
			by = (By.cssSelector(loc[1]));
			break;
		case "TAGNAME":
			by = (By.tagName(loc[1]));
			break;
		case "XPATH":
			by = (By.xpath(loc[1]));
			break;
		}
		return by;

	}

	public void implicitWait(long waitingTime) {
		driver.manage().timeouts().implicitlyWait(waitingTime, TimeUnit.SECONDS);
	}

	public WebElement waitElementToBeClickable(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectLocator(locator)));
		return element;
	}

	public void textToBePresentInElement(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(selectLocator(locator), "text to be present"));
	}

	public void titles(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.titleIs("title"));
	}

	public void alertIsPresent(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void elementSelectionStateToBe(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.elementSelectionStateToBe(selectLocator(locator), false));
	}

	public void elementToBeSelected(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.elementToBeSelected(selectLocator(locator)));
	}

	public void invisisbilityOfTheElementLocated(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(selectLocator(locator)));
	}

	public void frameToBeAvilableAndSwitchToIt(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(selectLocator(locator)));
	}

	public void invisibilityOfElementWithText(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(selectLocator(locator), "text to be present"));
	}

	public void presenceOfAllElementLocatedBy(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selectLocator(locator)));
	}

	public void presenceOfElementLocated(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(selectLocator(locator)));
	}

	public void textToBePresentInElementLocated(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(selectLocator(locator), "text to be present"));
	}

	public void textToBePresentInElementValue(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.textToBePresentInElementValue(selectLocator(locator), "text to be present"));
	}

	public void titleContains(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.titleContains("title"));
	}

	public void visibilityOfAllElementsLocatedBy(WebDriver driver, String locator, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectLocator(locator)));
	}

	public void visibilityOfElementLocated(WebDriver driver, String locator,long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void fluentWait(WebDriver driver, String locator, long waitingTime, long polingTime) {
		@SuppressWarnings({ "unused", "deprecation" })
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).ignoring(Exception.class)
				.pollingEvery(polingTime, TimeUnit.SECONDS).withTimeout(waitingTime, TimeUnit.SECONDS);

	}

	public void pageLoadTimeout(long waitingTime) {
		driver.manage().timeouts().pageLoadTimeout(waitingTime, TimeUnit.SECONDS);
	}

	public void setScriptTimeoutCommand(long waitingTime) {
		driver.manage().timeouts().setScriptTimeout(waitingTime, TimeUnit.SECONDS);
	}

}
