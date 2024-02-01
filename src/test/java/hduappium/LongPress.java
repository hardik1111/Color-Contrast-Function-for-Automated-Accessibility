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

public class LongPress extends Baseclass {

    @Test
    public void longPressGesture() throws MalformedURLException, InterruptedException {
        
    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
    	driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
    	WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
    	longPressAction(ele);
    	String popUp = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
        Assert.assertEquals(popUp, "Sample menu");
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
        
    	
    }
}