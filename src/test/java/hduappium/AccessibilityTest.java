package hduappium;

import static org.testng.Assert.assertNotNull;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
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


public class AccessibilityTest extends Baseclass5 {
	
	
    @Test
	public void accessibilityTest() throws InterruptedException, IOException
    {
        
    	List<WebElement> elements = driver.findElements(By.xpath("//*")); // Common base class for UI elements
    	File screenshot = driver.getScreenshotAs(OutputType.FILE);
    	BufferedImage fullImg = ImageIO.read(screenshot);
    	/*int i=0;
    	for (WebElement element : elements) {
    		if(i<elements.size())
    		{
    	    System.out.println("Element: " + element.getAttribute("text"));
    	    Point point = element.getLocation();
        	int elementWidth = element.getSize().getWidth();
        	int elementHeight = element.getSize().getHeight();
        	BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
        	
        	File outputFile = new File("C:/Users/hdu/eclipse/Appium/src/test/java/Screenshots/element_screenshot"+i+".png");
        	try {
        	    ImageIO.write(elementScreenshot, "png", outputFile);
        	    System.out.println("Saved element screenshot to " + outputFile.getAbsolutePath());
        	} catch (IOException e) {
        	    System.err.println("Error while saving the element screenshot: " + e.getMessage());
        	}
        	i++;
    		}
    		
    		else
    		{
    			break;
    		}
    	    
    	}*/
    	
    	

    	// Get the location of element on the page
    

    	// Get width and height of the element

    	WebElement element = elements.get(44);
    	// Crop the entire page screenshot to get only element screenshot
    	Point point = element.getLocation();
    	int elementWidth = element.getSize().getWidth();
    	int elementHeight = element.getSize().getHeight();
    	BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
    	File outputFile = new File("C:/Users/hdu/eclipse/Appium/src/test/java/Screenshots/element_screenshot.png");
    	try {
    	    ImageIO.write(elementScreenshot, "png", outputFile);
    	    System.out.println("Saved element screenshot to " + outputFile.getAbsolutePath());
    	} catch (IOException e) {
    	    System.err.println("Error while saving the element screenshot: " + e.getMessage());
    	}
    	int centerX = elementWidth / 2;
    	int centerY = elementHeight / 2;
    	int foregroundRGB = elementScreenshot.getRGB(centerX, centerY);
    	Color foregroundColor = new Color(foregroundRGB);
    	System.out.println(foregroundColor);
    	
    	//int edgeX = elementWidth - 5; // or elementWidth - 1 for the right edge
    	//int edgeY = elementHeight - 5 ; // or for the bottom edge
    	//int backgroundRGB = elementScreenshot.getRGB(edgeX, edgeY);
    	int borderWidth = (int) (elementWidth * 0.36);//Math.max(1, Math.min(elementWidth, elementHeight) / 20); // 5% of the smaller dimension
    	
    	
    	//Color backgroundColor = getBorderColor(elementScreenshot,borderWidth);
    	//System.out.println(backgroundColor);

    	//ouble contrastRatio = calculateContrastRatio(foregroundColor, backgroundColor);
    	//System.out.println("Contrast Ratio for Element " + element.getAttribute("text") + ": " + contrastRatio);
    }
    	// ...
    	/*private Color getBorderColor(BufferedImage elementScreenshot, int borderWidth) {
        long sumR = 0, sumG = 0, sumB = 0;
        int count = 0;

        // Top and Bottom border
        for (int x = 0; x < elementScreenshot.getWidth(); x++) {
            for (int y = 0; y < borderWidth; y++) { // Top border
                Color color = new Color(elementScreenshot.getRGB(x, y));
                sumR += color.getRed();
                sumG += color.getGreen();
                sumB += color.getBlue();
                count++;
            }
            for (int y = elementScreenshot.getHeight() - borderWidth; y < elementScreenshot.getHeight(); y++) { // Bottom border
                Color color = new Color(elementScreenshot.getRGB(x, y));
                sumR += color.getRed();
                sumG += color.getGreen();
                sumB += color.getBlue();
                count++;
            }
        }

        // Left and Right border
        for (int y = borderWidth; y < elementScreenshot.getHeight() - borderWidth; y++) {
            for (int x = 0; x < borderWidth; x++) { // Left border
                Color color = new Color(elementScreenshot.getRGB(x, y));
                sumR += color.getRed();
                sumG += color.getGreen();
                sumB += color.getBlue();
                count++;
            }
            for (int x = elementScreenshot.getWidth() - borderWidth; x < elementScreenshot.getWidth(); x++) { // Right border
                Color color = new Color(elementScreenshot.getRGB(x, y));
                sumR += color.getRed();
                sumG += color.getGreen();
                sumB += color.getBlue();
                count++;
            }
        }

        return new Color((int) (sumR / count), (int) (sumG / count), (int) (sumB / count));
    }

    	// Helper methods to calculate contrast ratio
    	private double linearize(double value) {
    	    return (value <= 0.03928) ? value / 12.92 : Math.pow((value + 0.055) / 1.055, 2.4);
    	}

    	private double getLuminance(Color color) {
    	    double r = linearize(color.getRed() / 255.0);
    	    double g = linearize(color.getGreen() / 255.0);
    	    double b = linearize(color.getBlue() / 255.0);
    	    return 0.2126 * r + 0.7152 * g + 0.0722 * b;
    	}

    	private double calculateContrastRatio(Color foreground, Color background) {
    	    double luminance1 = getLuminance(foreground) + 0.05;
    	    double luminance2 = getLuminance(background) + 0.05;
    	    return (luminance1 > luminance2) ? (luminance1 / luminance2) : (luminance2 / luminance1);
    	} */
    	
    	
    
        
}
    																									


    