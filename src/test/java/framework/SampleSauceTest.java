package framework;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import java.net.URL;
	
	public class SampleSauceTest {
	
		public static final String USERNAME = "ahsan_miran";
		public static final String ACCESS_KEY = "972c97fd-a98e-4db4-b647-9ee62178b1d4";
		public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		
		public static void main(String[] args) throws Exception {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "59.0");
			
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			
			driver.get("https://saucelabs.com/test/guinea-pig");
			System.out.println("title of page is: " + driver.getTitle());
			
			driver.quit();
		}
		
	}
