package hduappium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseclass {
	
	@Test
	public void browserTest()
	{
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
