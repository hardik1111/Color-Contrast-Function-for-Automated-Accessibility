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
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
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


public class AccessibilityTest5 extends Baseclass5 {
	
	 static { System.load("C:/Users/hdu/eclipse/opencv/build/java/x64/opencv_java490.dll"); }
    @Test
	public void accessibilityTest() throws InterruptedException, IOException
    {
        
    	driver.findElement(By.id("de.hafas.android.standard4:id/button_tracking_optin_agree")).click();
    	Thread.sleep(5000);
    	driver.findElement(AppiumBy.accessibilityId("Close tutorial")).click();
    	Thread.sleep(5000);
    	driver.switchTo().alert().accept();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout[1]")).click();
    	Thread.sleep(5000);
    	
    	List<WebElement> imageViews = driver.findElements(By.xpath("//android.widget.ImageView"));
        List<WebElement> textViews = driver.findElements(By.xpath("//android.widget.TextView"));
        List<WebElement> imagebutton = driver.findElements(By.xpath("//android.widget.ImageButton"));
        List<WebElement> elements = new ArrayList<>();
        elements.addAll(imageViews);
        elements.addAll(textViews);
        elements.addAll(imagebutton);
        // Common base class for UI elements
    	File screenshot = driver.getScreenshotAs(OutputType.FILE);
    	BufferedImage fullImg = ImageIO.read(screenshot);
    	int i=0;
    	//int maxWidth = 300; // maximum width
    	//int maxHeight = 300; // maximum height
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
    	    
    	}
    	
    	List<Color> colors= findDominantColors("C:/Users/hdu/eclipse/Appium/src/test/java/Screenshots/element_screenshot3.png", 2);
    	if (colors.size() >= 2) {
    	    Color mostDominantColor = colors.get(0);
    	    Color secondMostDominantColor = colors.get(1);

    	    double contrastRatio = calculateContrastRatio(mostDominantColor, secondMostDominantColor);
    	    System.out.println("Contrast Ratio: " + contrastRatio);
    	}
    	   

    	   

    	  
    	

    	// Get the location of element on the page
    

    	// Get width and height of the element

    	
    }

    public List<Color> findDominantColors(String imagePath, int k) {
    
    	 List<Color> dominantColors = new ArrayList<>();	
    // Read the image
    Mat src = Imgcodecs.imread(imagePath);
    if (src.empty()) {
        System.out.println("Cannot read image: " + imagePath);
        return dominantColors;
    }

    // Convert to RGB
    Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2RGB);

    // Reshape the image to a 2D matrix
    Mat data = src.reshape(1, (int) src.total());

    // Convert to floating point
    data.convertTo(data, CvType.CV_32F);

    // Implement k-means clustering
    Mat centers = new Mat();
    Mat labels = new Mat();
    TermCriteria criteria = new TermCriteria(TermCriteria.MAX_ITER + TermCriteria.EPS, 100, 0.1);
    Core.kmeans(data, k, labels, criteria, 1, Core.KMEANS_PP_CENTERS, centers);

    // Convert centers to proper format and extract dominant colors
    centers.convertTo(centers, CvType.CV_8UC1);
    centers = centers.reshape(3);

    for (int i = 0; i < centers.rows(); i++) {
        double[] color = centers.get(i, 0);
        Color dominantColor = new Color((int) color[0], (int) color[1], (int) color[2]);
        dominantColors.add(dominantColor);
    }
    return dominantColors;
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
    }*/

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
    	} 
    	
    	private BufferedImage getCroppedImage(BufferedImage image)
    	{
    		int minX = Integer.MAX_VALUE;
    		int minY = Integer.MAX_VALUE;
    		int maxX = 0;
    		int maxY = 0;

    		for (int x = 0; x < image.getWidth(); x++) {
    		    for (int y = 0; y < image.getHeight(); y++) {
    		        if (image.getRGB(x, y) != Color.WHITE.getRGB()) {
    		            if (x < minX) minX = x;
    		            if (x > maxX) maxX = x;
    		            if (y < minY) minY = y;
    		            if (y > maxY) maxY = y;
    		        }
    		    }
    		}
    		
    		BufferedImage croppedImage= image.getSubimage(minX, minY, maxX - minX + 1, maxY - minY + 1);
    		return croppedImage;
    	}
    	
    
        
}


    																									


    