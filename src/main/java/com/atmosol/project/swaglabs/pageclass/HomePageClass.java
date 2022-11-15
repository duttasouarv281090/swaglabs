package com.atmosol.project.swaglabs.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmosol.project.swaglabs.AbstractComponent;
import com.atmosol.project.swaglabs.BaseClass;

public class HomePageClass extends BaseClass {

	WebDriver driver;
	AbstractComponent absCom = new AbstractComponent(driver);

	HomePageClass(WebDriver driver) {
		this.driver = driver;
	}

	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By aboutBtn = By.id("react-burger-menu-btn");
	private By aboutlink = By.id("about_sidebar_link");
	private By labicon = By.xpath("(//a[@class='nav-image-link'])[1]");
	private By producttext = By.xpath("//*[text()='Products']");

	public HomePageClass enterCredentials(String getUserName, String getPaswrd) {

		driver.findElement(userName).sendKeys(getUserName);
		driver.findElement(password).sendKeys(getPaswrd);
		driver.findElement(loginBtn);
		return this;

	}

	public HomePageClass navigateHomePage() {
		absCom.waitForElementToDisplay(aboutBtn);
		driver.findElement(aboutBtn).click();
		driver.findElement(aboutlink).click();
		return this;

	}

	public String navigateToNextPage() {
		absCom.waitForElementToDisplay(labicon);
		String getCurrentUrl = driver.getCurrentUrl();
		return getCurrentUrl;
	}

	public String navigateToPreviousPage() {
		driver.navigate().back();
		absCom.waitForElementToDisplay(producttext);
		String getCurrentUrl = driver.getCurrentUrl();
		return getCurrentUrl;
	}
}
