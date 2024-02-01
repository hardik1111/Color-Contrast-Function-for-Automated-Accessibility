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

public class Assignment extends Baseclass {

    @Test
    public void assignment() throws MalformedURLException, InterruptedException {
        
    	driver.findElement(AppiumBy.accessibilityId("App")).click();
    	driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
    	driver.findElement(AppiumBy.accessibilityId("Single choice list")).click(); 
    	driver.findElement(By.xpath("(//android.widget.CheckedTextView)[3]")).click();
    	driver.findElement(By.id("android:id/button1")).click();
    }
}