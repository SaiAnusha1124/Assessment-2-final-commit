package com.atmecs.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.helpers.LocatorType;

public class DropDownAction {
	/*
	 * In this class,Drop Down actions are performed
	 */
	static WebElement element;
	static Select select;

	public void dropDownElement(WebDriver driver, LocatorType locator, String locatorValue, String dropDownValue) {

		switch (locator) {
		case CSSSELECTOR:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case CLASSNAME:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case ID:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case LINKTEXT:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case NAME:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case PARTIALLINKTEXT:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case TAGNAME:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		case XPATH:
			select = new Select(driver.findElement(By.cssSelector(locatorValue)));
			select.selectByVisibleText(dropDownValue);
			break;

		default:
			break;
		}
	}
}
