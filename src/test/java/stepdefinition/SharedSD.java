package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SharedSD {

	public static final String USERNAME = "ahsan_miran";
	public static final String ACCESS_KEY = "972c97fd-a98e-4db4-b647-9ee62178b1d4";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	
	private static final String myURL = "https://facebook.com/";
	public static WebDriver driver = null;
//    private static AppiumDriver appiumDriver;
	
//	@Given("^I open the default browser$")
	@Before("@web-regression")
	public static void before() throws MalformedURLException {

//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\ahsan\\Desktop\\webdrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "59.0");
		
		driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get(myURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Then("^I close the default browser$")
	@After("@web-regression")
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
//    public static AppiumDriver getAppiumDriver() {
//  
//        return appiumDriver;
//    }
	
//    @Before("@mobile-regression")
//    public static void intializeAppiumDriver() throws MalformedURLException {
//        appiumDriver = buildAppiumDriver();
//
//        // This is used in cases where fluent wait is not applied (fluentWait() at BaseWebPage class)
//        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
    
    /**
     * This method is used to quit the Appium driver if it is not null
     */
//    @After
//    public static void quitAppiumDriver() {
//        if(appiumDriver != null) {
//            System.out.println("Quitting Appium..");
//            appiumDriver.quit();
//            System.out.println("Quitting Appium - Done");
//            appiumDriver = null;
//        }
//    }
//    
//    /**
//     * This method builds the Appium driver using Desired Capability to respected mobile devices
//     * @return Appium driver
//     * @throws MalformedURLException
//     */
//   
//    private static AppiumDriver buildAppiumDriver() throws MalformedURLException {
//        AppiumDriver appiumDriver = null;
//        String appiumServerURL = "http://0.0.0.0:4723/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S6");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ahsan\\workspace\\hotels.apk");
//
//        appiumDriver = new AndroidDriver<>(new URL(appiumServerURL), capabilities);
//
//        return appiumDriver;
//    }
}
