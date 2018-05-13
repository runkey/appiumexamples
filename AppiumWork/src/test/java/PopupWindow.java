import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class PopupWindow {


	public AndroidDriver driver;
	public DesiredCapabilities capabilities;
	public File file;

	@BeforeClass
	public void setUp() throws MalformedURLException 
	{

		System.out.println(System.getProperty("user.dir"));
		file=new File(System.getProperty("user.dir")+"\\apk\\selendroid-test-app.apk");
		capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "MJVSBIHAZ5EIPNAI");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.2");
		capabilities.setCapability("app",file.getAbsolutePath());
		capabilities.setCapability("appPackage","io.selendroid.testapp");
		capabilities.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
		capabilities.setCapability("noReset","true");
		capabilities.setCapability("unicodeKeyboard", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void testCase1() throws InterruptedException 
	{

	//	driver.findElement(By.id("buttonTestCD")).click();
	//	driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
	//	Thread.sleep(5000);
		driver.findElement(By.id("buttonStartWebviewCD")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		//driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.ListView[@index='0']/android.widget.TextView[@text='xhtmlTestPage']")).click();
	    Thread.sleep(8000);
		//	android.widget.ListView
	    
	    
	    List<WebElement> list = driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.ListView[@index='0']/android.widget.TextView"));
	    System .out.println(list.size());
	   // System
	    
	    for(WebElement ele:list)
	    {
	    	System.out.println(ele.getAttribute("text"));
	    	
	    }
	    for(int i=0;i<list.size();i++)
	    {
	    	
	    	//System.out.println(ele.getText());
	    	System.out.println(list.get(i).getAttribute("text"));
	    	
	    	
	    }
	    
		
	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}


}
