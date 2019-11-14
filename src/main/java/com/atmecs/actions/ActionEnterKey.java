package com.atmecs.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.atmecs.helpers.LocatorType;

public class ActionEnterKey {
	public static void actionEnter(WebDriver driver, LocatorType locator, String locatorValue) {
		/*
		 * In this class, all enter key actions performed
		 */
		switch (locator) {
		case CLASSNAME:
			driver.findElement(By.className(locatorValue));
			break;

		case CSSSELECTOR:
			driver.findElement(By.cssSelector(locatorValue));
			break;

		case ID:
			driver.findElement(By.id(locatorValue));
			break;

		case LINKTEXT:
			driver.findElement(By.linkText(locatorValue));
			break;

		case NAME:
			driver.findElement(By.name(locatorValue));
			break;

		case PARTIALLINKTEXT:
			driver.findElement(By.partialLinkText(locatorValue));
			break;

		case TAGNAME:
			driver.findElement(By.tagName(locatorValue));
			break;

		case XPATH:
			driver.findElement(By.xpath(locatorValue));
			break;

		default:
			break;
		}
	}
}
