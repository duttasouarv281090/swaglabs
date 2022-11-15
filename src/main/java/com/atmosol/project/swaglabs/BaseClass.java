package com.atmosol.project.swaglabs;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends DriverManager {

	public WebDriver initializeDriver() throws IOException {
		driver = getDriver();
		return driver;

	}

	@BeforeMethod(alwaysRun = true)

	public void launchApplication() throws IOException {
		if (driver == null) {
			driver = initializeDriver();
			driver.get(ConfigReader.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownApplication() {

		if (driver != null) {
			driver.close();
		}

	}

}