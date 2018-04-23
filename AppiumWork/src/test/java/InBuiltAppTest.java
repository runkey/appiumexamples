import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class InBuiltAppTest 
{

	public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities capabilities;
	public File file;
	public TouchAction<?> touch;



	@BeforeClass
	public void setUp() throws MalformedURLException 
	{


		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "1db4cebe9804");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		//	capabilities.setCapability("app",file.getAbsolutePath());
		capabilities.setCapability("appPackage","net.one97.paytm");
		capabilities.setCapability("appActivity","net.one97.paytm.landingpage.activity.AJRMainActivity t21167");
		capabilities.setCapability("noReset","true");
		//	capabilities.setCapability("unicodeKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		touch=new TouchAction<>(driver);

	}

	@Test

	public void testCase1() throws InterruptedException 
	{
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Bus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='From']")).click();
		
	
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='Bengaluru']")).click();
		driver.findElements(By.className("android.widget.ListView")).get(0).click();
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='To']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Pune']")).click();
		driver.findElements(By.className("android.widget.ListView")).get(0).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Search Buses']")).click();

		
	//	driver.findElements(By.className("android.widget.ListView")).get(1).click();
	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}

}
