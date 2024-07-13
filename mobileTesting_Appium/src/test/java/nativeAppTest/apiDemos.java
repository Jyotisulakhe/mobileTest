package nativeAppTest;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import nativeApp.apiCapabilities;

public class apiDemos extends apiCapabilities{
	
	AndroidDriver<AndroidElement> driver; // globally declare driver variable 
	//for accessing all over class
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait
		
		
	}

	@Test(enabled=true)
	public void accesibility() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Access'ibility")).click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
	driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
	driver.findElement(MobileBy.id("android:id/checkbox")).click();
	//driver.findElement(MobileBy.xpath("//*[@text='WiFi settings']")).click();
	
	//another way of using text which you can follow easily is
	//use AndroidUIAutomator to identify an element using the attribute
	//use the UiSelector method for selecting the attribute
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
	driver.findElement(MobileBy.id("android:id/edit")).sendKeys("jyoti");
	driver.findElement(MobileBy.id("android:id/button1")).click();
	driver.hideKeyboard();
		
	}
	@Test(enabled=true)
	public void notifications() {
		
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
	}
	@Test(enabled=true)
	public void view() { //Scrolling
		System.out.println("views demo");
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//if you have to Scroll you need three things
		//1. UIAutomator
		//2. UISelector
		//3. UIScrollable
		//4. scrollIntoView
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		driver.findElement(MobileBy.AccessibilityId("WebView")).click();
		
		
	}
	@Test(enabled=true)
	public void lognPress() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		AndroidElement fish=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish Names\")"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(fish)).withDuration(ofSeconds(3))).release().perform();
	}

	@Test(enabled=true)
	public void dragDrop() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement ball1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement ball3 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_3"));
		TouchAction ts=new TouchAction(driver);
		ts.longPress(longPressOptions().withElement(element(ball1)).withDuration(ofSeconds(3))).moveTo(element(ball3)).release().perform();
		
	}
	@Test(enabled=true)
	public void dateWidget() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		AndroidElement date1 = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement date2 = driver.findElement(MobileBy.AccessibilityId("9"));
		TouchAction date=new TouchAction(driver);
		date.longPress(longPressOptions().withElement(element(date1)).withDuration(ofSeconds(3))).moveTo(element(date2)).release().perform();
				
	}
	
	//switching app and send messages
	@Test(enabled=true)
	public void sendMsg() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello");
		driver.hideKeyboard();
		
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
//		driver.activateApp("com.google.android.apps.messaging");//package name of messaging app
//		Thread.sleep(7000);
//		String msg = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
//		driver.activateApp("io.appium.android.apis");
//		Thread.sleep(3000);
//		
//		System.out.println(msg);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));//means in mobile bottom side square button is called switching app button
		
		
		
	}

}
