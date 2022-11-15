package com.atmosol.project.swaglabs.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.atmosol.project.swaglabs.AbstractComponent;
import com.atmosol.project.swaglabs.BaseClass;

public class CheckOutPage extends BaseClass {
	WebDriver driver;
	AbstractComponent absCom = new AbstractComponent(driver);

	CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	private By checkoutInfoPage = By.xpath("//*[text()='Checkout: Your Information']");
	private By checkoutFrstname = By.id("first-name");
	private By checkoutlstname = By.id("last-name");
	private By checkoutpostalCde = By.id("postal-code");
	private By continuebtn = By.id("continue");
	private By checkoutOverviewpge = By.xpath("//*[text()='Checkout: Overview']");
	private By checkoutTotalPrice = By.xpath("//div[@class='inventory_item_price']");

	public CheckOutPage navigateToCheckoutInfoPage()

	{
		absCom.waitForElementToDisplay(checkoutInfoPage);
		return this;
	}

	public CheckOutPage fillcustomerDetails(String getfrstName, String getLstName, String getpostalcde) {
		driver.findElement(checkoutFrstname).sendKeys(getfrstName);
		driver.findElement(checkoutlstname).sendKeys(getLstName);
		driver.findElement(checkoutpostalCde).sendKeys(getpostalcde);
		driver.findElement(continuebtn).click();
		return this;
	}

	public String navigateToOverViewPageeandCheckTotalPrce()

	{
		absCom.waitForElementToDisplay(checkoutOverviewpge);
		String extractTotalPrice = driver.findElement(checkoutTotalPrice).getText();
		return extractTotalPrice;
	}
}
