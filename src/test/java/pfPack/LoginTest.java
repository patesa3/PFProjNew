package pfPack;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pfPack.pages.LaunchPage;
import pfPack.util.constant;

//Login Test Java Comment


public class LoginTest extends BaseTest {
	//This is testLogin Method
	
	@Test
	//public void testLogin(Class<Object> LaunchPage) {
	public void testLogin() throws InterruptedException {
		
		
		eTest.log(LogStatus.INFO,"Stating Login Test");
		openbrowser(constant.BROWSTER_TYPE);
		LaunchPage launchPage = new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, launchPage);
		boolean	loginStatus=launchPage.goToLoginPage();
			if(loginStatus){
				
				reportPass("Login TestCases Passed");
			}else {
			  reportFail("Login TestCases Failed");
				
			//	Assert.fail(message);
				
			}
				
			}
		
		
@AfterMethod
public void testClousure(){
	//this method is for all report test connnecton & browser close
	if(eReport != null){
		eReport.endTest(eTest);
		eReport.flush(); //all logs are put in report from memory catch
	}
	if(driver != null){
		driver.quit();
	}
	
}
}
		
		
	
	


