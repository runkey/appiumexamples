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


public class ScrollTest 

{	
	public AndroidDriver<AndroidElement> driver;
	public DesiredCapabilities capabilities;
	public File file;
	public TouchAction<?> touch;



	@BeforeClass
	public void setUp() throws MalformedURLException 
	{

		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulaotor-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("appPackage","com.example.android.apis");
		capabilities.setCapability("appActivity","com.example.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void scrollTest() throws InterruptedException 
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}

}
