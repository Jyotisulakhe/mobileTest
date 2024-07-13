package hybridApps1;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hybridApp.hybridCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class gmailapp {
	public class ggmailapp extends hybridCapabilities{
		
		AndroidDriver<AndroidElement> driver;
		@BeforeTest
		public void bt() throws MalformedURLException {
			driver=capabilities();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		@Test
		public void newaccount() {
			
		}
}
	
	
}