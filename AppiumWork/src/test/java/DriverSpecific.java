import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DriverSpecific 
{

	public AndroidDriver<MobileElement> driver;
	public DesiredCapabilities capabilities;
	public File file;
	public TouchAction<?> touch;



	@BeforeClass
	public void setUp() throws MalformedURLException 
	{

		System.out.println(System.getProperty("user.dir"));
		file=new File(System.getProperty("user.dir")+"\\apk\\selendroid-test-app.apk");
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "1db4cebe9804");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("app",file.getAbsolutePath());
		capabilities.setCapability("appPackage","io.selendroid.testapp");
		capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
		capabilities.setCapability("noReset","true");
		//	capabilities.setCapability("unicodeKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


	}

	@Test

	public void testCase1() throws InterruptedException 
	{

		System.out.println(driver.getContext());  ///  native,web,hybdrid
		System.out.println(driver.getOrientation());   // landscapre,portrait
		// driver.isLocked();
		System.out.println(driver.isKeyboardShown());
		System.out.println(driver.currentActivity());
		System.out.println(driver.isKeyboardShown());
		//	driver.hideKeyboard();
		System.out.println(driver.getCurrentPackage());
		driver.getCurrentPackage();

	//	MobileElement e=	driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
	//	touch.tap(new TapOptions().withElement(ElementOption.element(e))).perform();  // tapping on web element
	    driver.pressKeyCode(AndroidKeyCode.BACK);
	    
	    Thread.sleep(12000);



	}


	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}
}
