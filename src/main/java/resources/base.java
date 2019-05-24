package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class base {
	
	public static WebDriver driver; //make driver static so once the object is initilaized(driver=initializedriver()) till it got null all our driver wherever we use driver in our test will refer to that driver object only(driver=initialize()) , so that another class cannot modify your static object
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\ME\\Project\\src\\main\\java\\resources\\data.properties");
	    prop.load(fs);
	    
	    String browserName=prop.getProperty("browser");
	    
	    if(browserName.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ME\\Desktop\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
	    }
	    else if(browserName.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ME\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
	    }
	    else if(browserName.equals("IE"))
	    {
	    	System.setProperty("webdriver.ie.driver", "C:\\Users\\ME\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    return driver;
	
	}
	
	public void getScreenshot(String result) throws IOException  //here we are taking screenshots of failed cases
	{
		File srcs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //the way which can takescreenshot
	    //this will capture our screen and we want to take that into some file (File srcs)
		// we need to copy this source variable inot our local file so that we acn open in our machine and check the screenshot
		FileUtils.copyFile(srcs, new File("C://test//"+result+"screenshot.png"));// this will store our screenshot in given path
		//there is one concept in testng called testng listeners they are basically listening to your execution stATUS so whenever there is a failure we can tell to our listeners to execute this block
		
	}
	
	
	

}
