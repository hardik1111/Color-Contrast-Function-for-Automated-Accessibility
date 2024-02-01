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

public class DragDropDemo extends Baseclass {

    @Test
    public void dragGesture() throws MalformedURLException, InterruptedException {
        
    	
    	driver.findElement(AppiumBy.accessibilityId("Views")).click();
    	

        // Perform actions and assertions for accessibility testing
        // For example, check if an element has a valid content description
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));
        String contentDescription = element.getAttribute("content-desc");
        if (contentDescription != null && !contentDescription.isEmpty()) {
            System.out.println("Accessibility test passed: Element has a valid content description.");
        } else {
            System.out.println("Accessibility test failed: Element lacks a content description.");
        }
    	
    	/*driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();	
    	WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
    	// Java
    	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
    	    "elementId", ((RemoteWebElement) source).getId(),
    	    "endX", 650,
    	    "endY", 1050
    	));
    	
    	Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");*/
    	Thread.sleep(2000);
    }
}