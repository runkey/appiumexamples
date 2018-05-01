import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SpinnerTest
{
	public AndroidDriver<AndroidElement> driver;
	public DesiredCapabilities capabilities;
	public File file;
	public TouchAction<?> touch;



	@BeforeClass
	public void setUp() throws MalformedURLException 
	{
		System.out.println(System.getProperty("user.dir"));
		file=new File(System.getProperty("user.dir")+"\\apk\\API Demos for Android_v1.9.0_apkpure.com.apk");

		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "MJVSBIHAZ5EIPNAI");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.2");
		capabilities.setCapability("app",file.getAbsolutePath());
		capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
	    capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
	    capabilities.setCapability("noReset","true");
		capabilities.setCapability("unicodeKeyboard", true);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void scrollTest() throws InterruptedException 
		
	{
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Controls']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='01. Light Theme']")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Mars']")).click();
		

	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}

}
