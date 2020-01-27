package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	
	public String baseUrl=readconfig.getApplicationURL();
	public String userName=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

@Parameters("browser")	
@BeforeClass	
public void setUp(String br)
{
	logger=Logger.getLogger("ebanking");
	PropertyConfigurator.configure("log4j.properties");
	
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readconfig.getChromePath());
	driver=new ChromeDriver();
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+readconfig.getFirefoxPath());
		driver=new FirefoxDriver();
	}
				
}

@AfterClass
public void tearDown()
{
	driver.quit();
}

//code to take screen shot
public static void captureScreen(WebDriver driver,String tname) throws IOException{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot ts =((TakesScreenshot)driver);

    //Call getScreenshotAs method to create image file

            File source=ts.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

            File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");

            //Copy file at destination

            FileUtils.copyFile(source, target);
            System.out.println("Screenshot is taken");
            
}
}
