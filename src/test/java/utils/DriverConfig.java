package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

public class DriverConfig extends BasePage {
	public static WebDriver driver1;

	@Before
	public void setup(Scenario scenario) throws MalformedURLException {
		//initialize config properties
		Utils.getInstance();

		if (Utils.getValue("local").equals("true")) {
			
			/*if(System.getProperty("browser").equals("chrome")) {
				
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver1 = new ChromeDriver();
			}*/
			//else 
//				if("firefox".equals("firefox")) {
//				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//				driver1= new FirefoxDriver();
//			}
//			
//			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//			driver1= new FirefoxDriver();
			
			
			/*System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver1= new InternetExplorerDriver();*/
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver1 = new ChromeDriver();
		}

		else {

			// browser stack connection config
			final String bsUrl = "https://" + Utils.getValue("bsUserName") + ":" + Utils.getValue("bsAccessKey")
					+ "@hub-cloud.browserstack.com/wd/hub";

			DesiredCapabilities desiredCap = new DesiredCapabilities();
			desiredCap.setCapability("browserstack.local", true);
			desiredCap.setCapability("browserstack.autoWait", 0);
			desiredCap.setCapability("project", "SCB");
			desiredCap.setCapability("browserstack.localIdentifier", "S2BNG");
			desiredCap.setCapability("acceptSslCerts", "true");
			desiredCap.setCapability("name", "S2BNG");

			desiredCap.setCapability("browser", "chrome");
			desiredCap.setCapability("browser_version", "78");
			desiredCap.setCapability("os", "Windows");
			desiredCap.setCapability("os_version", "10");
			desiredCap.setCapability("resolution", "1366x768");

			driver1 = new RemoteWebDriver(new URL(bsUrl), desiredCap);
		}

	}

	public static WebDriver getDriver() {
		return driver1;
	}

	public static String getBrowserVersion() {
		String browserName ="chrome";
		//browserName = Utils.isBlank_Null(browserName) ? "chrome" : browserName;
		String version = System.getProperty("version");
		System.out.println(browserName);
		switch (browserName) {
		
		case "chrome":
			version = !Utils.isBlank_Null(version) ? version : "77.0";
			break;

		case "firefox":
			version = !Utils.isBlank_Null(version) ? version : "70.0";
			break;

		case "ie":
			version = !Utils.isBlank_Null(version) ? version : "11";
			break;

		default:
			return version;
		}

		return version;

	}

	@After
	public void tearDown() {
		driver1.quit();
		eyes.abortIfNotClosed();
	}
}
