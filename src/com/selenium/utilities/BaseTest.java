package com.selenium.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver = null;
	protected static Properties prop = null;

	protected static String propertiesPath1 = TestConstants.OR_DIR + "/LoginOR.properties";

	@BeforeMethod
	public void browserLaunch() throws Throwable {
		String geckoDriverPath = "/usr/local/Cellar/geckodriver/0.24.0";
		System.setProperty("webdriver.firefox.marionette", geckoDriverPath);
        WebDriver driver = new FirefoxDriver();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.automatic-ntlm-auth.allow-proxies", true);
      	profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "noiproxy");
		//ProfilesIni profile =new ProfilesIni();
		//FirefoxProfile profile_ =profile.getProfile("/usr/local/Cellar/geckodriver/0.24.0");
		
      	//FirefoxOptions options= new FirefoxOptions().setProfile(profile_);
      	//driver = new FirefoxDriver(options);
		final FileInputStream fis1 = new FileInputStream(propertiesPath1);
		prop = new Properties();
		prop.load(fis1);
		final String baseUrl = prop.getProperty(TestConstants.TARGET_ENV + ".url");
		Reporter.log("Using application URL " + baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      	
      	

	}

}
