package webApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import webApp.webCapabilities;

public class webTesting extends webCapabilities{

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait
		
		
	}
	@Test
	public void testWeb() throws InterruptedException {
		driver.get("https://www.google.com/");
		
 WebElement ma = driver.findElement(MobileBy.xpath("//textarea[@name='q']"));
ma.sendKeys("masai");
ma.sendKeys(Keys.ENTER);
//		
//		
//		//scroll till any element using javascript
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		AndroidElement ele = driver.findElement(MobileBy.xpath("//*[text()=));
//		Thread.sleep(3000);
//		js.executeScript("arguments[0].scrollIntoView();", ele);
		//
	}
	
	//js is  more flexible than java  , js handle dynamicly 
	//appium is two version desktop and node version
	
}
