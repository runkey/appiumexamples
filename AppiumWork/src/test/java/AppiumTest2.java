import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest2 

{	
	public WebDriver driver;
	public DesiredCapabilities capabilities;
	public File file;

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
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void testCase1() 
	{
		
		
		WebElement element=driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("testcase");
		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("testcase1111");
		driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("test@gnail.com");
		driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("kiran@123");
		driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();  
	}

	@AfterClass
	public void tearDown()
	{

		driver.quit();
	}

}
