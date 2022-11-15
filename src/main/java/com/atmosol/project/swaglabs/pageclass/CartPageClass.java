package com.atmosol.project.swaglabs.pageclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmosol.project.swaglabs.AbstractComponent;
import com.atmosol.project.swaglabs.BaseClass;

public class CartPageClass extends BaseClass {

	WebDriver driver;
	AbstractComponent absCom = new AbstractComponent(driver);

	CartPageClass(WebDriver driver) {
		this.driver = driver;
	}

	private By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
	private By yourCartPage = By.xpath("//*[text()='Your Cart']");
	private By checkoutBtn = By.id("checkout");
	private By priceList = By.xpath("//div[@class='inventory_item_description']/div[@class='pricebar']/div");

	public CartPageClass clickCartIcon() {

		driver.findElement(cartIcon).click();
		return this;

	}

	public CheckOutPage navigateToCartPageandClickcontinueBtn() {
		absCom.waitForElementToDisplay(yourCartPage);
		driver.findElement(checkoutBtn).click();
		return new CheckOutPage(driver);
	}

	public double getHighestItem() {
		List<WebElement> listitems = driver.findElements(priceList);
		double highestitem = listitems.stream().mapToDouble(e -> Double.parseDouble(e.getText())).max().getAsDouble();
		return highestitem;
	}
}
