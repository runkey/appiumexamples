
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class PressAndLongPress
{



	public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities capabilities;
	public File file;
	public TouchAction<?> touch;



	@BeforeClass
	public void setUp() throws MalformedURLException 
	{

		System.out.println(System.getProperty("user.dir"));
		file=new File(System.getProperty("user.dir")+"\\apk\\com.socialnmobile.dictapps.notepad.color.note.apk");
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulaotor-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("app",file.getAbsolutePath());
		capabilities.setCapability("appPackage","com.socialnmobile.dictapps.notepad.color.note");
		capabilities.setCapability("appActivity","com.socialnmobile.colornote.activity.Main");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("unicodeKeyboard", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		touch=new TouchAction<>(driver);

	}

	@Test
	public void testCase1() throws InterruptedException 
	{

       //long press
		WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='add1']"));
		touch.longPress(new LongPressOptions().withElement(ElementOption.element(element))).perform();
        
		
		touch.press(PointOption.point(350, 300)).perform();  // press
		
	

		/*	List<MobileElement> me=driver.findElements(By.className("android.widget.FrameLayout"));

		for(int i=0;i<me.size();i++)
		{
			if(me.get(i).getAttribute("text").equals("Archive"))
			{
				me.get(i).click();
				break;

			}
		}*/
		/*	MobileElement e1=	driver.findElement(By.className("android.widget.TextView"));
		//touch.tap(e).perform();        //deprecated
		//touch.tap(PointOption.point(500,300)).perform();  // to tap on x,y coordinates
		touch.tap(new TapOptions().withElement(ElementOption.element(e1))).perform(); */

		// tapping on web element/*






		
		//	MobileElement e=	driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		//touch.tap(e).perform();        //deprecated
		//touch.tap(PointOption.point(500,300)).perform();  // to tap on x,y coordinates
		//	touch.tap(new TapOptions().withElement(ElementOption.element(e))).perform();  // tapping on web element

		// touch.press
	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}

}



