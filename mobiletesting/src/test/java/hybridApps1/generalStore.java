package hybridApps1;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hybridApp.hybridCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class generalStore extends hybridCapabilities{
	
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	} //Austria

	@Test
	public void addCart() throws InterruptedException {
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		AndroidElement aust = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))");
		aust.click();   	
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("kumari");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();	
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
//		AndroidElement jorden = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))");
//		jorden.click();
//		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
		

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String pr1 = driver.findElement(MobileBy.xpath("//*[@text='$160.97']")).getText();
		String product1 = pr1.substring(1);
		System.out.println(product1);
		Double firstpr = Double.parseDouble(product1);
		
		String pr2 = driver.findElement(MobileBy.xpath("//*[@text='$120.0']")).getText();

		String product2 = pr2.substring(1);
		System.out.println(product2);
		Double secondpr = Double.parseDouble(product2);
		
		String pr3 = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

		String totalp = pr3.substring(1);
		Double totapprice1=Double.parseDouble(totalp);
		System.out.println(totalp);
		
		Double total=firstpr+secondpr;
		if(total.equals(totapprice1)) {
			System.out.println("coast matching");
		}else {
			System.out.println("coast matching");
		}
		driver.findElement(MobileBy.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
//		
	}
	//gmail
}