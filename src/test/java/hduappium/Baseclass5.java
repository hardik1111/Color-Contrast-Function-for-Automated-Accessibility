package hduappium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Baseclass5 {

	public AndroidDriver driver;
	public AppiumDriverLocalService appiumService;
	
	
	public void ConfigureAppium() throws MalformedURLException
	{
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")) // Path to Node.js executable on Windows
                .withAppiumJS(new File("C:\\Users\\hdu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) // Path to Appium's main.js file on Windows
                .withLogFile(new File("appium.log")) // Optional: Set log file path
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE) 
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info"); // Optional: Set log level

        
        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
			
								
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Pixel 6 API 33"); //emulator
			//options.setDeviceName("Android Device");// real device
			
			ChromeOptions chromeOptions1 = new ChromeOptions();
		    chromeOptions1.addArguments("--disable-popup-blocking");
		    chromeOptions1.addArguments("--disable-infobars");
		    chromeOptions1.addArguments("--disable-notifications");
			
			//options.setChromedriverExecutable("C://Users//hdu//Downloads//chromedriver_win32");
			options.setCapability("chromedriverExecutable", "C:\\Users\\hdu\\Downloads\\chromedriver.exe");
			
			options.setCapability("chromeOptions", chromeOptions1.toJson());
			options.setApp("C://Users//hdu//eclipse-workspace//Appium//src//test//java//resources//standard-366-standard4-prod.apk");	
		//	options.setApp("//Users//rahulshetty//workingcode//Appium//src//test//java//resources//General-Store.apk");
			
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeClass
	public void ConfigureAppium1() throws MalformedURLException
	{
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")) // Path to Node.js executable on Windows
                .withAppiumJS(new File("C:\\Users\\hdu\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) // Path to Appium's main.js file on Windows
                .withLogFile(new File("appium.log")) // Optional: Set log file path
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE) 
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .withArgument(() -> "--allow-insecure", "adb_shell");// Optional: Set log level

        
        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
			
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Pixel 6 API 33"); // Replace with your device name or emulator
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "C:/Users/hdu/eclipse/Espresso_Integration/src/test/java/resources/standard-366-standard4-prod.apk");
        caps.setCapability("appPackage", "de.hafas.android.standard4");
        caps.setCapability("appActivity", "de.hafas.main.HafasApp");
        caps.setCapability("enforceXPath1", true);
        
        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	 
	
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	
	
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}
	
	static private double linearize(double value) {
	    return (value <= 0.03928) ? value / 12.92 : Math.pow((value + 0.055) / 1.055, 2.4);
	}
	
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		appiumService.stop();
		}
	
}
