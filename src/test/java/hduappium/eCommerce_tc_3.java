package hduappium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends Baseclass {
	
	@Test
	public void fillForm() throws InterruptedException
	{
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hardik Dudhat");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
		//Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText(), "Please enter your name");
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		/*int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<productCount; i++)
		{
		  String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		 
			if (productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		  
		}*/
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click(); 
		
		if(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText().equalsIgnoreCase("Cart"))
		{
		int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double j =0; 
		for(int i=0; i<productCount; i++)
		{
		  String productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		  StringBuilder sb = new StringBuilder(productPrice);
		  String dummy = sb.deleteCharAt(0).toString();
		  double price = Double.parseDouble(dummy);
		  j = j+price;
		}
		String str= String.valueOf("$ "+j);
		
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText(),str);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.TextView)[1]")).getText(), "Terms Of Conditions");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		}
		
		Thread.sleep(2000);
	}

}
