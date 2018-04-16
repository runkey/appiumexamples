import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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


public class TappingTest 

{	
	public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities capabilities;
	public File file;
	public TouchAction<?> touch;



	@BeforeClass
	public void setUp() throws MalformedURLException 
	{

		System.out.println(System.getProperty("user.dir"));
		file=new File(System.getProperty("user.dir")+"\\apk\\selendroid-test-app.apk");
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulaotor-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("app",file.getAbsolutePath());
		capabilities.setCapability("appPackage","io.selendroid.testapp");
		capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("unicodeKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		touch=new TouchAction<>(driver);

	}

	@Test
	public void testCase1() throws InterruptedException 
	{
		MobileElement e=	driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		//touch.tap(e).perform();        //deprecated
		//touch.tap(PointOption.point(500,300)).perform();  // to tap on x,y coordinates
		touch.tap(new TapOptions().withElement(ElementOption.element(e))).perform();  // tapping on web element
	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}

}
