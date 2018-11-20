package com.project.Durgasoft_6PMBatch;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage 
{
	
	public static WebDriver driver;
	public static String path="./data.properties";
	
	
	public static String loadData(String key) throws Exception
	{
		Properties p=new Properties();
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		p.load(fis);
		return p.getProperty(key);
	}
	
	
	public static void launch(String browser,String url)
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "D:\\Browser Drivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("FF"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("EDGE"))
		{
			driver=new EdgeDriver();
		}
		
		//driver.get(url);
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
	}

}
