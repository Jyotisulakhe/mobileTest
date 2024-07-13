package switchcareTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import switchcareMobileTest.capabilities;

public class login extends capabilities {

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void lg() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void login() {
	driver.findElement(MobileBy.className("com.horcrux.svg.PathView")).click();
	
	driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc=\"SIGN UP\"]/android.widget.TextView")).click();
	driver.findElement(MobileBy.xpath("//*[@text='John']")).sendKeys("kumari");
	
	driver.findElement(MobileBy.xpath("//*[@text='Doe']")).sendKeys("kumari");
	driver.findElement(MobileBy.xpath("//*[@text='(512) 123-4567']")).sendKeys("12345678");
	driver.findElement(MobileBy.xpath("//*[@text='johndoe@gmail.com']")).sendKeys("kumari@123");
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	}
	
	

}
