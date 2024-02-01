package hduappium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ScrollDemo extends Baseclass {

    @Test
    public void scrollGesture() throws MalformedURLException, InterruptedException {
        
    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
    	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    	
    	// Java
    	scrollToEndAction();
    	
    	
    	Thread.sleep(2000);
    	
    }
}