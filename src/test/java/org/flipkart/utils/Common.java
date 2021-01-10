package org.flipkart.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Common {
	
	protected static WebDriver driver= null;
	
	public static synchronized WebDriver browserlaunch (String browser) {
	switch (browser) {
	case "chrome":
		if (driver!=null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\umapathy\\eclipse-workspace\\BaseClass\\Driver\\chromedriver.exe");
			return driver;
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\umapathy\\eclipse-workspace\\BaseClass\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		break;
	case "firefox":
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\umapathy\\eclipse-workspace\\BaseClass\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		break;
	default:
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\umapathy\\eclipse-workspace\\BaseClass\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
	}
	return driver;
	}


public static void browserMax() {
	driver.manage().window().maximize();
}
public static void loadURL(String url) {
	driver.get(url);
}

public static WebElement element(String xpath) {
WebElement findelement=driver.findElement(By.xpath(xpath));
return findelement;
}


public static void type(WebElement element, String data) {
	element.sendKeys(data);
}

public static WebElement  element(By name) {
	 return driver.findElement(name);
}

public static WebElement  element_click(By name) {
	 return driver.findElement(name);
}

public static String takeScreenshotAtEndOfTest() throws IOException {
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    TakesScreenshot ts = (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String destination = System.getProperty("user.dir") + "/Extendsreport/" +  dateName
            + ".png";
    File finalDestination = new File(destination);
    FileHandler.copy(source, finalDestination);
    return destination;
}


}
