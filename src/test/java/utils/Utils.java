package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver;
	private static Utils instance = null;
	private static Properties properties;
	private static String propertyFilePath = System.getProperty("user.dir") + "//config.properties";

	private Utils() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static Utils getInstance() {
		if (instance == null) {
			instance = new Utils();
		}
		return instance;
	}

	public static String getValue(String key) {
		return properties.getProperty(key).trim();
	}

	public WebElement getExpWait(WebElement element) {
		String webEle = element.toString();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement tile;
		tile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webEle)));
		return tile;
	}

	public static boolean isBlank_Null(String str) {
		if (str != null && !str.equals(""))
			return false;
		else
			return true;
	}

}