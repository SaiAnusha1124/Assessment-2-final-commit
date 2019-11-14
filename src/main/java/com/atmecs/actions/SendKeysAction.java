package com.atmecs.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmecs.helpers.LocatorType;

public class SendKeysAction {
	/*
	 * In this class,send keys actions are performed
	 */
	public void sendKeys(WebDriver driver, LocatorType locator, String locatorValue, String sendkeys) {

		switch (locator) {
		case CLASSNAME:
			driver.findElement(By.className(locatorValue)).sendKeys(sendkeys);
			break;

		case CSSSELECTOR:
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(sendkeys);
			break;

		case ID:
			driver.findElement(By.id(locatorValue)).sendKeys(sendkeys);
			break;

		case LINKTEXT:
			driver.findElement(By.linkText(locatorValue)).sendKeys(sendkeys);
			break;

		case NAME:
			driver.findElement(By.name(locatorValue)).sendKeys(sendkeys);
			break;

		case PARTIALLINKTEXT:
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(sendkeys);
			break;

		case TAGNAME:
			driver.findElement(By.tagName(locatorValue)).sendKeys(sendkeys);
			break;

		case XPATH:
			driver.findElement(By.xpath(locatorValue)).sendKeys(sendkeys);
			break;

		default:
			break;
		}
	}
}
