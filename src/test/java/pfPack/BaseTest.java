package pfPack;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.LogStatus;


import pfPack.util.ExtentManager;
import pfPack.util.constant;
//Code is for Invoke Browser
//Generic Method


public class BaseTest {
	public WebDriver driver=null;
	public com.relevantcodes.extentreports.ExtentReports eReport = ExtentManager.getInstance();
	com.relevantcodes.extentreports.ExtentTest eTest = eReport.startTest("Login Test");
	public void openbrowser(String browsertype){
		if(browsertype.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.geco.driver", constant.FIREFOX_DRIVER);
			driver = new FirefoxDriver();
		}else if(browsertype.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",constant.CHROME_DRIVER);
		 driver = new ChromeDriver();
					
		}
		
		driver.manage().window().maximize();
		eTest.log(LogStatus.INFO,"Browser got Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eTest.log(LogStatus.INFO,"Sucessfully opened the Browser"+browsertype);
				
	}
    public void reportPass(String message){
    	eTest.log(LogStatus.PASS,message);
    }

   public void reportFail(String message){
	   eTest.log(LogStatus.FAIL, message);
	   //screen shot method need to call
	   takeScreenshot();
	   Assert.fail(message);
   }
 //Reusable method for taking screenshot
 	public void takeScreenshot(){
 		
 		// fileName of the screenshot
 		Date d=new Date();
 		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
 		// store screenshot in that file
 		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		try {
 			FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		//put screenshot file into the reports
 		eTest.log(LogStatus.INFO,"Screenshot-> "+ eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
 			
 	}
}

