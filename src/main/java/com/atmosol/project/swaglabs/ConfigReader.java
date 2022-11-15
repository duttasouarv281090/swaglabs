package com.atmosol.project.swaglabs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class ConfigReader {
	static Properties prop;

	public static String getProperty(String propKey) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/swaglabs/src/main/java/global.properties");
		prop = new Properties();
		prop.load(fis);
		String propvalue = prop.getProperty(propKey);
		return propvalue;

	}
}
