package hybridApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybridCapabilities {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Jyoti");       // connect Emulator through device name       
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");  // platform name
//		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore"); // connect app through app package name
//		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity"); //app activity
		
		//gmail   Name: Gmail
		
		
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.gm"); 
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.email.activity.setup.AccountCredentials");
		
		
		dc.setCapability(MobileCapabilityType.NO_RESET, true);// not reset app state before this session
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		return driver;
	}
	
	//com.androidsample.generalstore.SplashActivity - GeneralStore
	
}
