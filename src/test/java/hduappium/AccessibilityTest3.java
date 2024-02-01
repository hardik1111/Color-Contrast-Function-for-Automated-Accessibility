package hduappium;

import static org.testng.Assert.assertNotNull;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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


public class AccessibilityTest3 extends Baseclass5 {
	
	
    @Test
	public void accessibilityTest() throws InterruptedException, IOException
    {
        
    	List<WebElement> imageViews = driver.findElements(By.xpath("//android.widget.ImageView"));
        List<WebElement> textViews = driver.findElements(By.xpath("//android.widget.TextView"));
        List<WebElement> imagebutton = driver.findElements(By.xpath("//android.widget.ImageButton"));
        List<WebElement> elements = new ArrayList<>();
        elements.addAll(imageViews);
        elements.addAll(textViews);
        elements.addAll(imagebutton);
        System.out.println(elements.size());
        // Common base class for UI elements
    	
    	int i=0;
    	
    	for (WebElement element : elements) {
    		if(i<elements.size())
    		{
    			String contentDesc = element.getAttribute("text");
    			System.out.println(contentDesc);
    			Assert.assertNotNull("Content description should not be null", contentDesc);
        	
        	i++;
    		}
    		
    		else
    		{
    			break;
    		}
    	    
    	}
    	
    	

    	// Get the location of element on the page
    

    	// Get width and height of the element

    } 	
    	
    
        
}
    																									


    